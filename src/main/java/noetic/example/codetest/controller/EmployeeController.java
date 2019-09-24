package noetic.example.codetest.controller;

import noetic.example.codetest.dto.EmployeeDto;
import noetic.example.codetest.model.Employee;
import noetic.example.codetest.serviceInterfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




/**
 * Created by DS hewapathirana.
 * Date: 9/22/2019
 * Time: 10:39 AM
 */

@RestController
@RequestMapping("/emp")
public class EmployeeController {



    @Autowired
    EmployeeService employeeService;




    @PostMapping("/employee/{deptId}")
    public ResponseEntity<?> addEmployee(@PathVariable(name = "deptId") String deptId,@RequestBody EmployeeDto employeeDto) throws ClassNotFoundException {
        return   ResponseEntity.ok(employeeService.saveEmployee(deptId,employeeDto));

    }


    @GetMapping("/employee/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) throws ClassNotFoundException{
        return ResponseEntity.ok(employeeService.findById(id));
    }


    @GetMapping("employees")
    public ResponseEntity<?> getEmployees() throws ClassNotFoundException{
        return ResponseEntity.ok(employeeService.findAllEmployees());

    }


    @DeleteMapping("/employee/{emid}")
    public ResponseEntity<?> deleteEmployee(@PathVariable(name = "emid") Long emid){
        return ResponseEntity.ok(employeeService.deleteEmployee(emid));
    }


    @PutMapping("employee/{deptId}")
    public ResponseEntity<?> updateEmployee(@PathVariable(name = "deptId") String deptId,@RequestBody EmployeeDto employeeDto) throws ClassNotFoundException{
        return   ResponseEntity.ok(employeeService.updateEmployee(deptId,employeeDto));

    }



}
