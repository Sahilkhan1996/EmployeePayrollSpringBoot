package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeeModel;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeModel getEmpDataWithId(long id)
    {
        return employeeRepository.findById(id).orElseThrow(()->new EmployeePayrollException("Please enter valid employee id!!"));
    }

    public EmployeeModel addingEmp(EmployeeModel employeeModel) {
        return employeeRepository.save(employeeModel);
    }

    public EmployeeModel updateEmpData(long id, EmployeeModel employeeModel) {
        employeeModel.setId(id);
        return employeeRepository.save(employeeModel);
    }

    public String deleteEmpData(long id) {
        String res;
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            res = "emp delete successfully!";
        } else {
            res = "no id with  the above emp id";
        }
        return res;
    }

    public List<EmployeeModel> getEmpAllData() {
        return employeeRepository.findAll();
    }
}
