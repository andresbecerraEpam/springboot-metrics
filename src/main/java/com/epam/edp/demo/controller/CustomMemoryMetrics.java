package com.epam.edp.demo.controller;

import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;

@Component
public class CustomMemoryMetrics implements MeterBinder {

    @Override
    public void bindTo(MeterRegistry registry) {
    	
        // Registrar la métrica personalizada
    	
        Gauge.builder("jvm_memory_usage_8d50879d", this, CustomMemoryMetrics::getMemoryUsage)        
            .description("Custom JVM memory usage metrics with suffix 8d50879d")
            // .baseUnit("bytes")
            .register(registry);
        
    }

    // Método para obtener el uso de memoria en la JVM
    
    public double getMemoryUsage() {
    	
        return (double) Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        
    }
}