package com.maboxuan.mapper;

import com.maboxuan.entities.MbxUser;
import com.maboxuan.entities.MbxUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MbxUserMapper {
    long countByExample(MbxUserExample example);

    int deleteByExample(MbxUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MbxUser record);

    int insertSelective(MbxUser record);

    List<MbxUser> selectByExample(MbxUserExample example);

    MbxUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MbxUser record, @Param("example") MbxUserExample example);

    int updateByExample(@Param("record") MbxUser record, @Param("example") MbxUserExample example);

    int updateByPrimaryKeySelective(MbxUser record);

    int updateByPrimaryKey(MbxUser record);
}