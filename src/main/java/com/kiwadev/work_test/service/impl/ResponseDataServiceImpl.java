package com.kiwadev.work_test.service.impl;

import com.kiwadev.work_test.models.ResponseData;
import com.kiwadev.work_test.models.Status;
import com.kiwadev.work_test.models.Transaction;
import com.kiwadev.work_test.repository.StatusRepository;
import com.kiwadev.work_test.repository.TransactionRepository;
import com.kiwadev.work_test.service.ResponseDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResponseDataServiceImpl implements ResponseDataService {
    private final StatusRepository statusRepository;
    private final TransactionRepository transactionRepository;
    @Override
    public ResponseData findAll() {
        List<Status> statuses = statusRepository.findAll();
        List<Transaction> transactions = transactionRepository.findAll();
        return ResponseData.builder()
                .data(transactions)
                .status(statuses)
                .build();
    }
}
