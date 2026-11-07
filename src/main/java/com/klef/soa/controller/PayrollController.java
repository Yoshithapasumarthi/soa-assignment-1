
package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klef.soa.dto.PayrollDTO;
import com.klef.soa.service.PayrollService;

@RestController
@RequestMapping("/api/payroll")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    
    @PostMapping("/insert")
    public PayrollDTO insertPayroll(@RequestBody PayrollDTO dto) {
        return payrollService.insertPayroll(dto);
    }

       @PutMapping("/update/{id}")
    public PayrollDTO updatePayroll(
            @PathVariable Long id,
            @RequestBody PayrollDTO dto) {
        return payrollService.updatePayroll(id, dto);
    }

       
    
    @DeleteMapping("/delete/{id}")
    public String deletePayroll(@PathVariable Long id) {
        payrollService.deletePayroll(id);
        return "Payroll deleted successfully";
    }

    
    @GetMapping("/displayall")
    public List<PayrollDTO> getAllPayrolls() {
        return payrollService.getAllPayrolls();
    }

    
    @GetMapping("/id/{id}")
    public PayrollDTO getPayrollById(@PathVariable Long id) {
        return payrollService.getPayrollById(id);
    }

   
    @GetMapping("/name/{name}")
    public List<PayrollDTO> findByName(@PathVariable String name) {
        return payrollService.findByName(name);
    }

    
    @GetMapping("/type/{type}")
    public List<PayrollDTO> findByType(@PathVariable String type) {
        return payrollService.findByType(type);
    }
    
    @GetMapping("/")
    public String home() {
        return "Payroll Service is running";
    }
}
