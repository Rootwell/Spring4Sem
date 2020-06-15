package com.example.sole_shifter.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public interface LoggingAspect {
    Object logMethodAround(ProceedingJoinPoint proceedingJoinPoint);

    void logMethodBefore(JoinPoint joinPoint);
}
