package com.ypc.springbootmybatisfenxiang.dao;

import com.ypc.springbootmybatisfenxiang.po.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YPC
 * @create 2019 04 13 15:07
 */
@Mapper
@Repository
public interface StudentDao {
    @Select("select stuid,stuname,graid from student")
    @Results(id = "stu",value = {
            @Result(property = "id",column = "stuid"),
            @Result(property = "name",column = "stuname"),
            @Result(property = "grade",one = @One(select = "com.ypc.springbootmybatisfenxiang.dao.GradeDao.findById"),column = "graid")
    })
    public List<Student> findAll();
    @Select("select stuid,stuname,graid from student where stuid=#{id}")
    @ResultMap(value = "stu")
    public Student findById(int id);
    @Insert("insert into student(stuname,graid) values(#{name},1)")
    public int insert(Student stu);
    @Update("update student set stuname=#{name} where stuid=#{id}")
    public int update(Student stu);
    @Delete("delete from student where stuid=#{id}")
    public int delete(int id);

}
