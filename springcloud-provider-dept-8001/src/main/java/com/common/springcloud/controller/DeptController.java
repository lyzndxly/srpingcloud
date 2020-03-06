package com.common.springcloud.controller;

import com.common.springcloud.pojo.Dept;
import com.common.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController = @Controller + @ResponseBody组成,
// @RestController注解Controller，则Controller中的方法无法返回jsp页面，
//这里没有前端页面使用@RestController就够了
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("dept/add")
    public boolean addDept(@RequestBody Dept dept) {
        return  deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptService.queryId(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll(Dept dept) {
        System.out.println(deptService.queryAll());
        return deptService.queryAll();
    }
}
