package com.kiwadev.work_test.service;

import com.kiwadev.work_test.models.Status;
import com.kiwadev.work_test.models.Transaction;

import java.util.List;

public interface StatusService {
    List<Status> findAll();
    Status findById(int id);
    Status save(Status status);
    Status update(Status status);
    void delete(int id);
}
