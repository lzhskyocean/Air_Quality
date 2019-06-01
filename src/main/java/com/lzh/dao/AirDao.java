package com.lzh.dao;

import com.lzh.bean.Air;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

/**
 * @author lizhenhao
 */


public interface AirDao {

    //根据条件查询数据的总条数
    Integer findCountByDistrictId(@Param("districtId") Long districtId);

    //根据条件分页查询
    List<Air> findAirByDistrictIdPage(@Param("districtId") Long districtId,
                                     @Param("offset") Integer offset,
                                     @Param("size") Integer size);

    //添加空气信息
    Integer save(Air air);

    //根据id查询air
    Air findByAirId(@Param("airId") Long airId);

    //修改空气质量信息
    Integer updateAir(Air air);

    //
    Integer deleteAirById(@Param("airId") Long airId);

}
