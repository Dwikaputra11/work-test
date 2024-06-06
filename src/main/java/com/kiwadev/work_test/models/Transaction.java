package com.kiwadev.work_test.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "transaction",schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trx_id")
    public Integer id;
    public Integer productID;
    public String productName;
    public Integer amount;
    public Integer status;
    public String customerName;
    public String transactionDate;
    public String createBy;
    public String createOn;
}
