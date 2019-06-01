package com.lzh.dao;

import com.lzh.MyTest;
import com.lzh.bean.District;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author lizhenhao
 */
public class DistrictDaoTest extends MyTest {

    @Autowired
    private DistrictDao districtDao;

    @Test
    public void findAllDistrict() {

        List<District> districtList = districtDao.findAllDistrict();

        for (District district : districtList) {

            System.out.println(district);
        }

    }
}