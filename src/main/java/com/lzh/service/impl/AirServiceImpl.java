package com.lzh.service.impl;

import com.lzh.bean.Air;
import com.lzh.dao.AirDao;
import com.lzh.service.AirService;
import com.lzh.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lizhenhao
 */

@Service
public class AirServiceImpl implements AirService {

    @Autowired
    private AirDao airDao;

    @Override
    public PageInfo<Air> findAirByDistrictIdPage(Long districtId, Integer page, Integer size) {

        Integer count = airDao.findCountByDistrictId(districtId);

        PageInfo<Air> pageInfo = new PageInfo<>(page, size, count);

        List<Air> airList = airDao.findAirByDistrictIdPage(districtId, pageInfo.getOffset(), size);

        pageInfo.setList(airList);

        return pageInfo;
    }

    @Override
    public Integer save(Air air) {

        return airDao.save(air);
    }

    @Override
    public Air findByAirId(Long airId) {
        return airDao.findByAirId(airId);
    }

    @Override
    public Integer updateAir(Air air) {
        return airDao.updateAir(air);
    }

    @Override
    public Integer deleteAirById(Long airId) {
        return airDao.deleteAirById(airId);
    }
}
