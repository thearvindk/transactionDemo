package com.transactions.demo.repository;

import com.transactions.demo.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TransactionService {

    private final List<Transaction> transactions = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    public List<Transaction> getAllTransactions() {
        return transactions;
    }

    public Transaction addTransaction(Transaction transaction) {
        transaction.setId(counter.getAndIncrement());
        transactions.add(transaction);
        return transaction;
    }

    public double getTotalCalories() {
        return transactions.stream().mapToDouble(Transaction::getCount).sum();
    }
}
