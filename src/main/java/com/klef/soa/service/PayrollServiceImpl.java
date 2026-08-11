package com.klef.soa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.dto.PayrollDTO;
import com.klef.soa.entity.Payroll;
import com.klef.soa.repository.PayrollRepository;

@Service
public class PayrollServiceImpl implements PayrollService {

    @Autowired
    private PayrollRepository payrollRepository;

    // Entity to DTO
    private PayrollDTO convertToDTO(Payroll payroll) {

        PayrollDTO dto = new PayrollDTO();

        dto.setPayrollId(payroll.getPayrollId());
        dto.setName(payroll.getName());
        dto.setType(payroll.getType());
        dto.setStatus(payroll.getStatus());
        dto.setLocation(payroll.getLocation());
        dto.setCreatedAt(payroll.getCreatedAt());
        dto.setUpdatedAt(payroll.getUpdatedAt());

        return dto;
    }

    // DTO to Entity
    private Payroll convertToEntity(PayrollDTO dto) {

        Payroll payroll = new Payroll();

        payroll.setPayrollId(dto.getPayrollId());
        payroll.setName(dto.getName());
        payroll.setType(dto.getType());
        payroll.setStatus(dto.getStatus());
        payroll.setLocation(dto.getLocation());

        return payroll;
    }

    // Insert
    @Override
    public PayrollDTO insertPayroll(PayrollDTO payrollDTO) {

        Payroll payroll = convertToEntity(payrollDTO);

        Payroll savedPayroll = payrollRepository.save(payroll);

        return convertToDTO(savedPayroll);
    }

    // Update
    @Override
    public PayrollDTO updatePayroll(Long id, PayrollDTO payrollDTO) {

        Payroll existingPayroll = payrollRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payroll not found"));

        existingPayroll.setName(payrollDTO.getName());
        existingPayroll.setType(payrollDTO.getType());
        existingPayroll.setStatus(payrollDTO.getStatus());
        existingPayroll.setLocation(payrollDTO.getLocation());

        Payroll updatedPayroll = payrollRepository.save(existingPayroll);

        return convertToDTO(updatedPayroll);
    }

    // Delete
    @Override
    public void deletePayroll(Long id) {

        payrollRepository.deleteById(id);
    }

    // Display All
    @Override
    public List<PayrollDTO> getAllPayrolls() {

        return payrollRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    // Display By ID
    @Override
    public PayrollDTO getPayrollById(Long id) {

        Payroll payroll = payrollRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payroll not found"));

        return convertToDTO(payroll);
    }

    // Find By Name
    @Override
    public List<PayrollDTO> findByName(String name) {

        return payrollRepository.findByName(name)
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    // Find By Type
    @Override
    public List<PayrollDTO> findByType(String type) {

        return payrollRepository.findByType(type)
                .stream()
                .map(this::convertToDTO)
                .toList();
    }
}