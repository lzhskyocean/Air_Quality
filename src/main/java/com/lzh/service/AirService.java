package com.lzh.service;

import com.lzh.bean.Air;
import com.lzh.util.PageInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author lizhenhao
 */

public interface AirService {

    //1.
    PageInfo<Air> findAirByDistrictIdPage(Long districtId, Integer page, Integer size);

    Integer save(Air air);

    //根据id查询air
    Air findByAirId( Long airId);

    //修改空气质量信息
    Integer updateAir(Air air);


    //
    Integer deleteAirById(Long airId);

}
