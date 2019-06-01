package com.lzh.dao;

import com.lzh.bean.District;

import java.util.List;

/**
 * @author lizhenhao
 */
public interface DistrictDao {


    //查询所有的区域
    List<District> findAllDistrict();


}
