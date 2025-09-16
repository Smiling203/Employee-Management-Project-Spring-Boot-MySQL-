package com.code.emp_project;
// import java.util.List;

// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// public class empController {

//     //List<Employee> employees = new ArrayList<>();
//     //EmployeeService employeeService = new EmployeeServiceImpl() ;
// //Dependency Injection

// EmployeeService employeeService;

//     @GetMapping("employees")
//     public List<Employee> getAllEmployees(){
//         return employeeService.readEmployees();
//     }
//     @PostMapping("/employees")
//     public String createEmployee(@RequestBody Employee employee) {
//         return employeeService.createEmployee(employee);
//     }

//     @DeleteMapping("/employees/{id}")
//     public String deleteEmployee(@PathVariable Long id) {
//        if(employeeService.deleteEmployee(id))
//        return "Deleted Successfully";
//        return "Not Found";
//     }
// }


//package com.code.emp_project;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class empController {

   EmployeeService employeeService;

    public empController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.readEmployees();
    }
    @GetMapping("/{id}")
public Employee getEmployeeById(@PathVariable Long id) {
    return employeeService.getEmployeeById(id);
}

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Employee with ID " + id + " deleted successfully.";
    }
}
