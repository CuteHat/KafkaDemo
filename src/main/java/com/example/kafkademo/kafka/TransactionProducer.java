package com.example.kafkademo.kafka;

import com.example.kafkademo.TransactionDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@Slf4j
public class TransactionProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final String topic = "transaction-events";

    @Autowired
    public TransactionProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(TransactionDetails details) {
        log.info("***[PRODUCER] Sending new message {}", details);

        kafkaTemplate.send(topic, details).addCallback(getCallBack());
        log.info("***[PRODUCER] Some random computation");
    }

    public void publishWithKey(TransactionDetails details, String key) {
        log.info("***[PRODUCER] Sending new message {} with key {}", details, key);
        kafkaTemplate.send(topic, key, details).addCallback(getCallBack());
    }

    private ListenableFutureCallback<SendResult<String, Object>> getCallBack() {
        return new ListenableFutureCallback<>() {

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                log.info("***[PRODUCER] Sending message : SUCCESS ✅");
                log.info(result.toString());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("***[PRODUCER] Sending message : FAILED ❌", ex);
            }
        };
    }
}
