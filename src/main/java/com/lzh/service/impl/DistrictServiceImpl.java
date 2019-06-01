package com.lzh.service.impl;

import com.lzh.bean.District;
import com.lzh.dao.DistrictDao;
import com.lzh.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lizhenhao
 */

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictDao districtDao;


    @Override
    public List<District> findAllDistrict() {

        return districtDao.findAllDistrict();
    }
}
