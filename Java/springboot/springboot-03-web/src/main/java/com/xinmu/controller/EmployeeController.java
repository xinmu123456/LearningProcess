package com.xinmu.controller;

import com.sun.org.glassfish.gmbal.ParameterNames;
import com.xinmu.dao.DepartmentDao;
import com.xinmu.dao.EmployeeDao;
import com.xinmu.pojo.Department;
import com.xinmu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.Collection;

/**
 * author: xinmu
 * date: 2022/4/16
 * time: 15:28
 */

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddpage(Model model){
        //查出所有部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //添加的操作
        System.out.println("save=>"+employee);
        employeeDao.save(employee);//调用底层业务方法保存员工信息

        return "redirect:/emps";
    }

    //去员工的修改页面
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id,Model model){
        //查出原来的数据
        Employee employee= employeeDao.getEmployeeById(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        model.addAttribute("emp",employee);
        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //删除员工
    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeDao.deleteEmployeeById(id);
        return "redirect:/emps";
    }
}
