package com.ypc.springbootmybatisfenxiang.dao;

import com.ypc.springbootmybatisfenxiang.po.Grade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author YPC
 * @create 2019 04 14 16:15
 */
@Mapper
@Repository
public interface GradeDao {
    @Select("select graid,graname from grades where graid=#{id}")
    @Results(id = "gra",value = {
            @Result(property = "id",column = "graid"),
            @Result(property = "name",column = "graname")
    })
    public Grade findById(int id);
}
