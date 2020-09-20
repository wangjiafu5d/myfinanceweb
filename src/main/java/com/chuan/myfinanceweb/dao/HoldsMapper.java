package com.chuan.myfinanceweb.dao;

import com.chuan.myfinanceweb.bean.Holds;
import com.chuan.myfinanceweb.bean.HoldsExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HoldsMapper {
    long countByExample(HoldsExample example);

    int deleteByExample(HoldsExample example);

    int insert(Holds record);

    int insertSelective(Holds record);

    List<Holds> selectByExample(HoldsExample example);
    List<Holds> selectAll(@Param("goods")String goods,@Param("date")String date,@Param("comp") String comp);
    List<Holds> selectByDateGoodsAndComp(Date date ,String goods,String compName);
    int updateByExampleSelective(@Param("record") Holds record, @Param("example") HoldsExample example);

    int updateByExample(@Param("record") Holds record, @Param("example") HoldsExample example);
}