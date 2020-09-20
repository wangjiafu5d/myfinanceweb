package com.chuan.myfinanceweb.dao;

import com.chuan.myfinanceweb.bean.Dailydatasum;
import com.chuan.myfinanceweb.bean.DailydatasumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DailydatasumMapper {
    long countByExample(DailydatasumExample example);

    int deleteByExample(DailydatasumExample example);

    int insert(Dailydatasum record);

    int insertSelective(Dailydatasum record);

    List<Dailydatasum> selectByExample(DailydatasumExample example);

    int updateByExampleSelective(@Param("record") Dailydatasum record, @Param("example") DailydatasumExample example);

    int updateByExample(@Param("record") Dailydatasum record, @Param("example") DailydatasumExample example);
}