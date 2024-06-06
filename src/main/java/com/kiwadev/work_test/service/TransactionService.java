package com.kiwadev.work_test.service;

import com.kiwadev.work_test.models.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> findAll();
    Transaction findById(int id);
    Transaction save(Transaction transaction);
    Transaction update(Transaction transaction);
    void delete(int id);
}
