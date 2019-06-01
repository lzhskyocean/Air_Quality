package com.lzh.service.impl;

import com.lzh.MyTest;
import com.lzh.bean.Air;
import com.lzh.service.AirService;
import com.lzh.util.PageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author lizhenhao
 */
public class AirServiceImplTest extends MyTest {

    @Autowired
    private AirService airService;

    @Test
    public void findAirByDistrictIdPage() {

        PageInfo<Air> pageInfo = airService.findAirByDistrictIdPage(2L, 1, 3);

        System.out.println(pageInfo);
    }

    @Test
    public void save() {

        Air air = new Air();

        air.setDistrictId(4L);
        air.setLastModifyTime(new Date());
        air.setPm10(234L);
        air.setPm25(235L);
        air.setMonitoringStation("老李湾监测站");

        Integer count = airService.save(air);

        System.out.println(count);
    }

    @Test
    public void findByAirId() {

        Air air = airService.findByAirId(6L);

        System.out.println(air);
    }
}