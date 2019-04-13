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
    @Select("select stuid,stuname from student")
    @Results(id = "stu",value = {
            @Result(property = "id",column = "stuid"),
            @Result(property = "name",column = "stuname")
    })
    public List<Student> findAll();
    @Select("select stuid,stuname from student where stuid=#{id}")
    @ResultMap(value = "stu")
    public Student findById(int id);
    @Insert("insert into student(stuname,grade_id) values(#{name},0)")
    public int insert(Student stu);
    @Update("update student set stuname=#{name} where stuid=#{id}")
    public int update(Student stu);
    @Delete("delete from student where stuid=#{id}")
    public int delete(int id);

}
