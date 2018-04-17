package com.ycx.wpp.core.dao;

import com.ycx.wpp.core.domain.dataobject.TUser;
import org.springframework.stereotype.Component;

public interface TUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
}