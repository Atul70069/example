package com.parctise.PractiseProject.controller;

import com.parctise.PractiseProject.entity.Employee;
import com.parctise.PractiseProject.service.EmpService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmpController {


   @Autowired
    private EmpService service;

    @GetMapping("/")
    public String home(Model m)
    {
        List<Employee> allEmp = service.getAllEmp();
        m.addAttribute("allEmp",allEmp);

        return "index";
    }

    @GetMapping("/addemp")
    public String addEmpForm()
    {
        return "add_emp";
    }

    @PostMapping("/register")
    public String empRegister(@ModelAttribute Employee e, HttpSession session)
    {
        System.out.println(e);
        service.addEmp(e);
        session.setAttribute("msg","EMPLOYEE ADDED SUCCESSFULLY////");

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id,Model m)
    {
    Employee e=  service.getEmpById(id);
    m.addAttribute("emp",e);

        return "edit";
    }

    @PostMapping("/update")
    public String updateEmp(@ModelAttribute Employee e,HttpSession session)
    {

        service.addEmp(e);

        session.setAttribute("msg","DATA UPDATED");
        return "redirect:/";
    }


}
