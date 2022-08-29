package com.wufang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wufang.domain.Info;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IInfoDao extends BaseMapper<Info> {
}
