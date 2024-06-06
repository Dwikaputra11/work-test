package com.kiwadev.work_test.controller;

import com.kiwadev.work_test.models.ResponseData;
import com.kiwadev.work_test.service.ResponseDataService;
import com.kiwadev.work_test.utils.Constants;
import com.kiwadev.work_test.utils.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ResponseDataController {
    private final ResponseDataService responseDataService;

    @GetMapping("/")
    public ResponseData findAll(){
        return responseDataService.findAll();
    }





}
