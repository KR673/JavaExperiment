package com.wxb.commontest.dao.mysql;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MonthMapper {
    int insert(Month record);
    List<Month> selectAll();
}