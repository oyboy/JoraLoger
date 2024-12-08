package com.example.JoraLoger.filter;

import com.example.JoraLoger.LogEntity;

public class DebugFilter implements LogFilter {
    @Override
    public boolean shouldFilter(LogEntity logEntity) {
        return logEntity.getLevel().equals("TRACE") ||
                logEntity.getLevel().equals("DEBUG");
    }
}