package com.example.JoraLoger.filter;

import com.example.JoraLoger.LogEntity;

public interface LogFilter {
    boolean shouldFilter(LogEntity log);
}