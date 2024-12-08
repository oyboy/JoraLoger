package com.example.JoraLoger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "logs")
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) //ignore @version from kafka
public class LogEntity {
    @Id
    private String id;
    private String message;
    private String level;
    private String logger;
    private String timestamp;
    private String thread;
    private String mdc;
}