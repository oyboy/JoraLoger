package com.example.JoraLoger;

import com.example.JoraLoger.filter.DefaultLogFilter;
import com.example.JoraLoger.filter.LogFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaLogConsumer {
    @Autowired
    LogRepository logRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();
    private LogFilter currentFilter = new DefaultLogFilter();

    @KafkaListener(topics = "logs", groupId = "log-group")
    public void listen(String message) {
        System.out.printf("Received message: %s", message);
        String logId = generateUniqueId();
        try {
            LogEntity logEntity = objectMapper.readValue(message, LogEntity.class);
            if (mustBeFiltered(logEntity)) {
                log.warn("message filtered");
                return;
            } else {
                log.info("message passed");
            }
            logEntity.setId(logId);
            logRepository.save(logEntity);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
    private String generateUniqueId() {
        return java.util.UUID.randomUUID().toString();
    }

    private boolean mustBeFiltered(LogEntity logEntity) {
        return currentFilter.shouldFilter(logEntity);
    }
    public void setFilter(LogFilter filter) {
        this.currentFilter = filter;
    }
}