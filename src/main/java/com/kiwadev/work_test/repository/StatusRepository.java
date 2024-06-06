package com.kiwadev.work_test.repository;

import com.kiwadev.work_test.models.Status;
import com.kiwadev.work_test.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status,Integer> {
}
