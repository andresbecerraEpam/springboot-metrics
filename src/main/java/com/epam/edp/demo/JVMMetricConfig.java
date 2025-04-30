package com.epam.edp.demo;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.jvm.JvmMemoryMetrics;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.micrometer.core.instrument.Metrics;

@Configuration
public class JVMMetricConfig {

    @Bean
    public void customJvmMemoryMetrics(MeterRegistry meterRegistry) {
        // Register the JVM memory usage metrics under a custom name with the desired format
        new JvmMemoryMetrics().bindTo(meterRegistry);
        meterRegistry.gauge("jvm_memory_usage_8673ceff", Runtime.getRuntime(), Runtime::freeMemory);
    }
}