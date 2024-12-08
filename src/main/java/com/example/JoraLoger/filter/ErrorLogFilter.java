package com.example.JoraLoger.filter;

import com.example.JoraLoger.LogEntity;

public class ErrorLogFilter implements LogFilter {
    @Override
    public boolean shouldFilter(LogEntity logEntity) {
        return logEntity.getLevel().equals("WARN") ||
                logEntity.getLevel().equals("INFO") ||
                logEntity.getLevel().equals("TRACE") ||
                logEntity.getLevel().equals("DEBUG");
    }
}