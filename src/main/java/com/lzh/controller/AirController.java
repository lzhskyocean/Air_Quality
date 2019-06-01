package com.lzh.controller;

import com.lzh.bean.Air;
import com.lzh.bean.District;
import com.lzh.dao.DistrictDao;
import com.lzh.service.AirService;
import com.lzh.service.DistrictService;
import com.lzh.util.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * @author lizhenhao
 */


@Controller
@RequestMapping("/air")
public class AirController {

    @Autowired
    private AirService airService;

    @Autowired
    private DistrictService districtService;

    /*
    * 1.展示空气质量信息
    * */
    @RequestMapping("/list")
    public String list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                       @RequestParam(value = "size",defaultValue = "3") Integer size,
                       Long districtId,
                       Model model
    ){

        PageInfo<Air> pageInfo = airService.findAirByDistrictIdPage(districtId, page, size);

        List<District> districtList = districtService.findAllDistrict();




        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("districtList",districtList);
        //回显
        model.addAttribute("districtId",districtId);

        return "/air_list";
    }


    /*
    * 2.跳转到空气质量添加页面
    * */
    @GetMapping("/add")//@RequestMapping(value = "/add",method = RequestMethod.GET)
    public String toAddPage(Model model,String addMsg){

        //1.查询所有区域
        List<District> districtList = districtService.findAllDistrict();

        model.addAttribute("districtList",districtList);

        model.addAttribute("addMsg",addMsg);

        return "/air_add";
    }

    /*
    * 3.添加空气质量信息
    * */
    @PostMapping("/add")
    public String add(@Valid Air air,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes
    ){
        //1.判断是否有信息错误
        if (bindingResult.hasErrors()){
            String addMsg = bindingResult.getFieldError().getDefaultMessage();
            redirectAttributes.addAttribute("addMsg",addMsg);
            return "redirect:/air/add";

        }

        //进行添加
        Integer count = airService.save(air);

        if (count==1){
            //添加成功,重定向到空气质量列表
            return "redirect:/air/list";
        }

        //添加失败,重定向到添加页面
        redirectAttributes.addAttribute("addMsg","添加失败!!!");
        return "redirect:/air/add";
    }


    /*
    * 4.跳转到空气质量维护页面
    * */
    @GetMapping("/maintain/{airId}")
    public String maintain(@PathVariable Long airId,Model model,String updateMsg,String deleteMsg){

        //1.查询空气质量信息
        Air air = airService.findByAirId(airId);
        //2.查询所有区域
        List<District> districtList = districtService.findAllDistrict();

        //2.将查询信息添加到页面
        model.addAttribute("air",air);
        model.addAttribute("districtList",districtList);

        //4.将错误信息添加到页面
        model.addAttribute("updateMsg",updateMsg);
        model.addAttribute("deleteMsg",deleteMsg);

        return "/air_maintain";

    }

    /*
    * 5.更新天气质量
    * */
    @PutMapping("/update")
    public String update(@Valid Air air,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            String updateMsg = bindingResult.getFieldError().getDefaultMessage();
            redirectAttributes.addAttribute("updateMsg",updateMsg);
            return "redirect:/air/maintain/"+air.getId();
        }

        Integer count = airService.updateAir(air);

        if(count == 1){
            //修改成功,重定向到空气质量列表
            return "redirect:/air/list";
        }

        redirectAttributes.addAttribute("updateMsg","天气质量修改失败!!!");
        return  "redirect:/air/maintain"+air.getId();

    }


    /*
    * 6.根据airId删除air
    * */
    @GetMapping("/delete/{airId}")
    public String delete(@PathVariable Long airId,
                         RedirectAttributes redirectAttributes
    ){

        Integer count = airService.deleteAirById(airId);

        if(count==1){

            redirectAttributes.addAttribute("deleteMsg","删除成功!!!");
            return "redirect:/air/list";

        }

        redirectAttributes.addAttribute("deleteMsg","删除失败!!!");
        return "redirect:/air/maintain/" + airId;


    }



}
