package com.lzh.dao;

import com.lzh.MyTest;
import com.lzh.bean.Air;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author lizhenhao
 */
public class AirDaoTest extends MyTest {

    @Autowired
    private AirDao airDao;

    @Test
    public void findCountByDistrictId() {

        Integer count = airDao.findCountByDistrictId(2L);

        System.out.println(count);

    }

    @Test
    public void findAirByDistrictIdPage() {

        List<Air> airList = airDao.findAirByDistrictIdPage(2L, 0, 2);

        for (Air air : airList) {
            System.out.println(air);
        }

    }

    @Test
    public void save() {

        Air air = new Air();

        air.setDistrictId(4L);
        air.setLastModifyTime(new Date());
        air.setPm10(234L);
        air.setPm25(235L);
        air.setMonitoringStation("老牛湾监测站");

        Integer count = airDao.save(air);

        System.out.println(count);
    }

    @Test
    public void findByAirId() {

        Air air = airDao.findByAirId(10L);
        System.out.println(air);
    }

    @Test
    @Transactional
    public void updateAir() {

        Air air = new Air();
        air.setId(3L);
        air.setDistrictId(4L);
        air.setLastModifyTime(new Date());
        air.setPm10(23L);
        air.setPm25(23L);
        air.setMonitoringStation("老牛湾监测站");
        Integer count = airDao.updateAir(air);
        System.out.println(count);
    }

    @Test
    @Transactional
    public void deleteAirById() {

        Integer count = airDao.deleteAirById(6L);

        System.out.println(count);

    }
}