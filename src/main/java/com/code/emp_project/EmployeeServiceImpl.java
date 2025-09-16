package com.code.emp_project;

import org.springframework.beans.factory.annotation.Autowired;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.beans.BeanUtils;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// @Service
// public class EmployeeServiceImpl implements EmployeeService{

//    @Autowired
//    private  EmployeeRepository employeeRepository;
//    // List<Employee> employees = new ArrayList<>();

//     @Override
//     public String createEmployee(Employee employee) {
//       EmployeeEntity employeeEntity = new EmployeeEntity();
//       BeanUtils.copyProperties(employee, employeeEntity);
//       employeeRepository.save(employeeEntity);
//        //employees.add(employee);
//        return "Saved Successfully";
//         }

//     @Override
//     public List<Employee> readEmployees() {
//       List<EmployeeEntity> employeesList=employeeRepository.findAll();
//       List<Employee> employees = new ArrayList<>();
//       for(EmployeeEntity employeeEntity : employeesList) {
//          Employee emp = new Employee();
//          emp.setId(employeeEntity.getId());
//          emp.setName(employeeEntity.getName());
//          emp.setPhone(employeeEntity.getPhone());
//          emp.setEmail(employeeEntity.getEmail());
//          employees.add(emp);
//       }
//        return employees;
//     }
//     @Override
//     public boolean deleteEmployee(Long id) {
//       EmployeeEntity emp= employeeRepository.findById(id).get();
//       employeeRepository.delete(emp);
//        return true;
//     }
// }
//package com.code.emp_project;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
     @Autowired
     private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> readEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    @Override
    public Employee getEmployeeById(Long id) {
    return employeeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }


    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        return employeeRepository.findById(id)
                .map(existing -> {
                    existing.setName(employee.getName());
                    return employeeRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    @Override
    public boolean deleteEmployee(Long id) {
       employeeRepository.deleteById(id);
       return true;
    }

}

