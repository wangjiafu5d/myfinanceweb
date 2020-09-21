package com.chuan.myfinanceweb.dao;

import com.chuan.myfinanceweb.bean.DataOf100ppi;
import com.chuan.myfinanceweb.bean.DataOf100ppiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataOf100ppiMapper {
    long countByExample(DataOf100ppiExample example);

    int deleteByExample(DataOf100ppiExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DataOf100ppi record);

    int insertSelective(DataOf100ppi record);

    List<DataOf100ppi> selectByExample(DataOf100ppiExample example);

    DataOf100ppi selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DataOf100ppi record, @Param("example") DataOf100ppiExample example);

    int updateByExample(@Param("record") DataOf100ppi record, @Param("example") DataOf100ppiExample example);

    int updateByPrimaryKeySelective(DataOf100ppi record);

    int updateByPrimaryKey(DataOf100ppi record);
}