package com.epam.edp.demo;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Gauge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JVMMetricConfig {

    @Bean
    public Gauge customJvmMemoryMetrics(MeterRegistry meterRegistry) {
        // Get the JVM memory usage in bytes
        long totalMemory = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        long usedMemory = totalMemory - freeMemory;

        // Create and register the custom metric for memory usage
        return Gauge.builder("jvm_memory_usage_8673ceff", () -> usedMemory)
                    .description("Custom JVM memory usage")
                    .baseUnit("bytes")
                    .register(meterRegistry);
    }
}