package com.wufang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wufang.dao.IInfoDao;
import com.wufang.domain.Info;
import com.wufang.service.IInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl extends ServiceImpl<IInfoDao, Info> implements IInfoService {
    @Autowired
    private IInfoDao infoDao;

    @Override
    public IPage<Info> pages(Integer current, Integer size) {
        IPage page = new Page(current,size);
        infoDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Info> pages(Integer current, Integer size, Info info) {
        LambdaQueryWrapper<Info> wrapper = new LambdaQueryWrapper<Info>();
        wrapper.like(info.getDeleted() != null,Info::getDeleted,info.getDeleted());
        wrapper.like(info.getId() != null,Info::getId,info.getId());
        wrapper.like(info.getName() != null,Info::getName,info.getName());

        IPage page = new Page(current,size);
        infoDao.selectPage(page,wrapper);
        return page;
    }


}
