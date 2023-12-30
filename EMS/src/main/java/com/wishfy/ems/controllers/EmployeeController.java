package com.wishfy.ems.controllers;

import com.wishfy.ems.dtos.EmployeeDto;
import com.wishfy.ems.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * @apiNote
     * @author Shubham Dhokchaule
     */
    @PostMapping("/")
    public ResponseEntity<EmployeeDto> addEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        log.info(("Initiated request for add Employee  details"));
        EmployeeDto employeeDto1 = this.employeeService.addEmployee(employeeDto);
        log.info("Completed request for add Employee details");
        return new ResponseEntity<>(employeeDto1, HttpStatus.CREATED);
    }

    /**
     * @author Shubham Dhokchaule
     */
    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        log.info(("Initiated request for get all  Employee  details"));
        List<EmployeeDto> allEmployees = this.employeeService.getAllEmployees();
        log.info(("Completed request for add Employee  details"));
        return new ResponseEntity<>(allEmployees, HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long employeeId) {
        log.info("Initiated request for get employee details with employeeId:{}", employeeId);
        EmployeeDto employeeById = this.employeeService.getEmployeeById(employeeId);
        log.info("Completed request for get employee details with employeeId:{}", employeeId);
        return new ResponseEntity<>(employeeById, HttpStatus.OK);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable Long employeeId) {
        log.info("Initiated request for update employee details with employeeId:{}", employeeId);
        EmployeeDto employeeDto1 = this.employeeService.updateEmployee(employeeDto, employeeId);
        log.info("Completed request for update employee details with employeeId:{}", employeeId);
        return new ResponseEntity<>(employeeDto1, HttpStatus.OK);

    }
    @DeleteMapping("/{employeeId}")

    public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable Long employeeId) {
        log.info("Initiated request for deleteEmployee details with employeeId:{}", employeeId);
        this.employeeService.removeEmployee(employeeId);
        log.info("Completed request for deleteEmployee details with employeeId:{}", employeeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


