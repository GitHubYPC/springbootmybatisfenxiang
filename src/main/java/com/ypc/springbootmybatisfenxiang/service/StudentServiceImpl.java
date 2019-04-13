package com.ypc.springbootmybatisfenxiang.service;

import com.ypc.springbootmybatisfenxiang.dao.StudentDao;
import com.ypc.springbootmybatisfenxiang.po.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author YPC
 * @create 2019 04 13 15:19
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao sd;
    @Override
    public List<Student> findAll() {
        return sd.findAll();
    }

    @Override
    public Student findById(int id) {
        return sd.findById(id);
    }

    @Override
    public boolean insert(Student stu) {
        if (sd.insert(stu)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Student stu) {
        if (sd.update(stu)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (sd.delete(id)>0){
            return true;
        }
        return false;
    }
}
