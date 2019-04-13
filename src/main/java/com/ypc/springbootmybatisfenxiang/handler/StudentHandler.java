package com.ypc.springbootmybatisfenxiang.handler;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ypc.springbootmybatisfenxiang.po.Student;
import com.ypc.springbootmybatisfenxiang.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author YPC
 * @create 2019 04 13 15:21
 */
@Controller
public class StudentHandler {
    @Resource
    private StudentService ss;

    @RequestMapping("/findAll")
    public String findAll(Model model,Integer pageNum){
        if (pageNum==null){
            pageNum=1;
        }
        PageHelper.startPage(pageNum,3);
        List<Student> list = ss.findAll();
        int pages = new PageInfo(list).getPages();
        model.addAttribute("list",list);
        model.addAttribute("pages",pages);
        model.addAttribute("pageNum",pageNum);
        return "findAll";
    }
    @RequestMapping("/loadInsert")
    public String loadInsert(){
        return "insert";
    }
    @RequestMapping("/insert")
    public String findAll(Student stu){
        boolean insert = ss.insert(stu);
        System.out.println("insert = " + insert);
        return "redirect:findAll";
    }
    @RequestMapping("/findById")
    public String findById(int id,Model model){
        model.addAttribute("stu",ss.findById(id));
        return "update";
    }
    @RequestMapping("/update")
    public String update(Student stu){
        boolean update = ss.update(stu);
        System.out.println("update = " + update);
        return "redirect:findAll";
    }
    @RequestMapping("/delete")
    public String delete(int id){
        boolean delete = ss.delete(id);
        System.out.println("delete = " + delete);
        return "redirect:findAll";
    }
}
