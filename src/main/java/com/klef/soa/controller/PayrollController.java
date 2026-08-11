package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.dto.PayrollDTO;
import com.klef.soa.service.PayrollService;

@RestController
@RequestMapping("/api/payroll")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    // Insert Record
    @PostMapping
    public PayrollDTO insertPayroll(@RequestBody PayrollDTO payrollDTO) {

        return payrollService.insertPayroll(payrollDTO);
    }

    // Update Record
    @PutMapping("/{id}")
    public PayrollDTO updatePayroll(
            @PathVariable Long id,
            @RequestBody PayrollDTO payrollDTO) {

        return payrollService.updatePayroll(id, payrollDTO);
    }

    // Delete Record
    @DeleteMapping("/{id}")
    public String deletePayroll(@PathVariable Long id) {

        payrollService.deletePayroll(id);

        return "Payroll deleted successfully";
    }

    // Display All Records
    @GetMapping
    public List<PayrollDTO> getAllPayrolls() {

        return payrollService.getAllPayrolls();
    }

    // Display Record By ID
    @GetMapping("/{id}")
    public PayrollDTO getPayrollById(@PathVariable Long id) {

        return payrollService.getPayrollById(id);
    }

    // Derived Query Method 1
    @GetMapping("/name/{name}")
    public List<PayrollDTO> findByName(@PathVariable String name) {

        return payrollService.findByName(name);
    }

    // Derived Query Method 2
    @GetMapping("/type/{type}")
    public List<PayrollDTO> findByType(@PathVariable String type) {

        return payrollService.findByType(type);
    }
}