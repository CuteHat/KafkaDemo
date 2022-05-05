package com.example.kafkademo.service;

import com.example.kafkademo.TransactionDetails;
import com.example.kafkademo.kafka.TransactionProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TransactionService {
    private final TransactionProducer transactionProducer;
    private final String topic = "transaction-events";

    @Autowired
    public TransactionService(TransactionProducer transactionProducer) {
        this.transactionProducer = transactionProducer;
    }

    public void publish(TransactionDetails details) {
        transactionProducer.publish(details);
    }

    public void processTransaction(TransactionDetails transaction) {
        log.info("***Processing transaction{}", transaction);
    }
}
