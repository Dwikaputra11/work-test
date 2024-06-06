package com.kiwadev.work_test.models;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ResponseData implements Serializable {
    private List<Transaction> data;
    private List<Status> status;
}
