package com.chuan.myfinanceweb.dao;

import com.chuan.myfinanceweb.bean.Holdings;
import com.chuan.myfinanceweb.bean.HoldingsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HoldingsMapper {
    long countByExample(HoldingsExample example);

    int deleteByExample(HoldingsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Holdings record);

    int insertSelective(Holdings record);

    List<Holdings> selectByExample(HoldingsExample example);

    Holdings selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Holdings record, @Param("example") HoldingsExample example);

    int updateByExample(@Param("record") Holdings record, @Param("example") HoldingsExample example);

    int updateByPrimaryKeySelective(Holdings record);

    int updateByPrimaryKey(Holdings record);
}