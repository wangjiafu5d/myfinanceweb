package com.chuan.myfinanceweb.dao;

import com.chuan.myfinanceweb.bean.DailyData;
import com.chuan.myfinanceweb.bean.DailyDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DailyDataMapper {
    long countByExample(DailyDataExample example);

    int deleteByExample(DailyDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DailyData record);

    int insertSelective(DailyData record);

    List<DailyData> selectByExample(DailyDataExample example);

    DailyData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DailyData record, @Param("example") DailyDataExample example);

    int updateByExample(@Param("record") DailyData record, @Param("example") DailyDataExample example);

    int updateByPrimaryKeySelective(DailyData record);

    int updateByPrimaryKey(DailyData record);
}