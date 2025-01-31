package com.transactions.demo.controller;

import com.transactions.demo.model.Transaction;
import com.transactions.demo.repository.TransactionService;
import com.transactions.demo.service.FeatureFlagService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calories")
@CrossOrigin(origins = {"http://65.2.35.58:3000", "http://localhost:3000"})
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    @Autowired
    private FeatureFlagService featureFlagService;
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionService.addTransaction(transaction);
    }

    @GetMapping("/total")
    public double getOverallCalories() {
        return transactionService.getTotalCalories();
    }
    @GetMapping("/maintenance")
    public String checkMaintenanceMode() {
        boolean isMaintenanceOn = featureFlagService.isMaintenanceModeEnabled();
        return isMaintenanceOn ? "Maintenance On" : "Maintenance Off";
    }
}
