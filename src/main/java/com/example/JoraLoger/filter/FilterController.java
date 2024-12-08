package com.example.JoraLoger.filter;

import com.example.JoraLoger.KafkaLogConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filter")
public class FilterController {
    @Autowired
    private KafkaLogConsumer kafkaLogConsumer;

    @PostMapping("/default")
    public ResponseEntity<String> setDefaultFilter() {
        kafkaLogConsumer.setFilter(new DefaultLogFilter());
        return ResponseEntity.ok("Default filter set");
    }
    @PostMapping("/error")
    public ResponseEntity<String> setErrorFilter() {
        kafkaLogConsumer.setFilter(new ErrorLogFilter());
        return ResponseEntity.ok("Error filter set");
    }
    @PostMapping("/debug")
    public ResponseEntity<String> setDebugFilter() {
        kafkaLogConsumer.setFilter(new DebugFilter());
        return ResponseEntity.ok("Debug filter set");
    }
}