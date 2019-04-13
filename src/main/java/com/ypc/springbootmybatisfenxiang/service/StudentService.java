package com.ypc.springbootmybatisfenxiang.service;

import com.ypc.springbootmybatisfenxiang.po.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author YPC
 * @create 2019 04 13 15:18
 */
public interface StudentService {
    public List<Student> findAll();
    public Student findById(int id);
    public boolean insert(Student stu);
    public boolean update(Student stu);
    public boolean delete(int id);
}
