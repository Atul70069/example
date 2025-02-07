package com.parctise.PractiseProject.service;

import com.parctise.PractiseProject.entity.Employee;
import com.parctise.PractiseProject.repositry.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {


    @Autowired
    private EmpRepo repo;

    public void addEmp(Employee e)
    {
        repo.save(e);
    }


    public List<Employee> getAllEmp()
    {
        return repo.findAll();
    }


    public Employee getEmpById(int id)
    {
       Optional<Employee> e=repo.findById(id);
       if (e.isPresent())
       {
           return e.get();
       }
       return null;
    }
}
