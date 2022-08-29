package com.wufang.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wufang.controller.utils.R;
import com.wufang.dao.IInfoDao;
import com.wufang.domain.Info;
import org.springframework.web.bind.annotation.PathVariable;

public interface IInfoService extends IService<Info> {
    IPage<Info> pages(Integer current,Integer size);

    IPage<Info> pages(Integer current,Integer size, Info info);


}
