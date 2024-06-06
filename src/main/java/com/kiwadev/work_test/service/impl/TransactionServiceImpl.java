package com.kiwadev.work_test.service.impl;

import com.kiwadev.work_test.models.Transaction;
import com.kiwadev.work_test.repository.TransactionRepository;
import com.kiwadev.work_test.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction findById(int id) {
        return null;
    }

    @Override
    public Transaction save(Transaction transaction) {
        return null;
    }

    @Override
    public Transaction update(Transaction transaction) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
