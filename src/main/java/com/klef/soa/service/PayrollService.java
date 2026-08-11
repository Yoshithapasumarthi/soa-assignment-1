package com.klef.soa.service;

import java.util.List;

import com.klef.soa.dto.PayrollDTO;

public interface PayrollService {

    PayrollDTO insertPayroll(PayrollDTO payrollDTO);

    PayrollDTO updatePayroll(Long id, PayrollDTO payrollDTO);

    void deletePayroll(Long id);

    List<PayrollDTO> getAllPayrolls();

    PayrollDTO getPayrollById(Long id);

    List<PayrollDTO> findByName(String name);

    List<PayrollDTO> findByType(String type);
}