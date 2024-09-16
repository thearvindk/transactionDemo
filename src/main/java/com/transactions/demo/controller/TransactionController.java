package com.transactions.demo.controller;


import com.transactions.demo.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/Calories")
@CrossOrigin(origins= {"http://65.1.3.184","http://localhost:3000","65.1.92.27"})
public class TransactionController {

    private List<Transaction> transactions = new ArrayList<>();
    private AtomicLong counter = new AtomicLong();

    public TransactionController() {
        // Add some initial transactions
        transactions.add(new Transaction(counter.incrementAndGet(), "Coffee", 100.0));
        transactions.add(new Transaction(counter.incrementAndGet(), "Lemon Tea", 50.0));
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactions;
    }

    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        transaction.setId(counter.incrementAndGet());
        transactions.add(transaction);
        return transaction;
    }
    @GetMapping("/total")
    public int getOverallCalories() {
    	int totalCount=0;
    	for (Transaction transaction : transactions) {
            totalCount += transaction.getCount();
        }
    	return totalCount;
    }
}
