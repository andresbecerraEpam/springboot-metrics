package com.epam.edp.demo;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Counter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JVMMetricConfig {

    @Bean
    public void customJvmMemoryMetrics(MeterRegistry meterRegistry) {
        // Get the JVM memory usage in bytes
        long totalMemory = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        long usedMemory = totalMemory - freeMemory;

        // Register the custom metric for memory usage
        meterRegistry.gauge("jvm_memory_usage_8673ceff", usedMemory);
    }
}