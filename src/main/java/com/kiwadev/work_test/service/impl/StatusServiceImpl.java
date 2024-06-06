package com.kiwadev.work_test.service.impl;

import com.kiwadev.work_test.models.Status;
import com.kiwadev.work_test.repository.StatusRepository;
import com.kiwadev.work_test.service.StatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusServiceImpl implements StatusService {
    private final StatusRepository statusRepository;
    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    @Override
    public Status findById(int id) {
        return null;
    }

    @Override
    public Status save(Status status) {
        return null;
    }

    @Override
    public Status update(Status status) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
