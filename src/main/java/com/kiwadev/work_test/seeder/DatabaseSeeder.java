package com.kiwadev.work_test.seeder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kiwadev.work_test.models.ResponseData;
import com.kiwadev.work_test.models.Status;
import com.kiwadev.work_test.models.Transaction;
import com.kiwadev.work_test.repository.StatusRepository;
import com.kiwadev.work_test.repository.TransactionRepository;
import com.kiwadev.work_test.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class DatabaseSeeder {
    private final TransactionRepository transactionRepository;
    private final StatusRepository statusRepository;
    private final JdbcTemplate jdbcTemplate;
    private final ObjectMapper objectMapper;
    

    @EventListener
    public void seed(ContextRefreshedEvent event) throws IOException {
        seedTransactionTable();
        seedStatusTable();
    }

    private void seedStatusTable() {
        var sql = "SELECT COUNT(*) FROM public.status";
        var rs = jdbcTemplate.queryForObject(sql, Integer.class);
        if(rs!= null && rs == 0) {
            try{
                ResponseData responseData = objectMapper.readValue(
                        new File(Constants.SEED_PATH + "view_data.json"),
                        new TypeReference<>() {});
                List<Status> statuses = responseData.getStatus();
                log.info("response data: {}",responseData);
                log.info("status data: {}",statuses);
                statusRepository.saveAll(statuses);
            }catch (IOException e){
                log.error("transaction table failed: {}",e.getLocalizedMessage());
            }
        }else {
            log.trace("Transaction Seeding Not Required");
        }
    }

    private void seedTransactionTable() {
        var sql = "SELECT COUNT(*) FROM public.transaction";
        var rs = jdbcTemplate.queryForObject(sql, Integer.class);
        if(rs!= null && rs == 0) {
            try{
                ResponseData responseData = objectMapper.readValue(
                        new File(Constants.SEED_PATH + "view_data.json"),
                        new TypeReference<>() {});
                List<Transaction> transactions = responseData.getData();
                log.info("response data: {}",responseData);
                log.info("transaction data: {}",transactions);
                transactionRepository.saveAll(transactions);
            }catch (IOException e){
                log.error("transaction table failed: {}",e.getLocalizedMessage());
            }
        }else {
            log.trace("Transaction Seeding Not Required");
        }
    }
}
