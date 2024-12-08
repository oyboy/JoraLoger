package com.example.JoraLoger.filter;

import com.example.JoraLoger.LogEntity;

public class DefaultLogFilter implements LogFilter {
    @Override
    public boolean shouldFilter(LogEntity logEntity) {
        return logEntity.getLevel().equals("DEBUG") ||
                logEntity.getLevel().equals("INFO") ||
                logEntity.getLevel().equals("TRACE");
    }
}