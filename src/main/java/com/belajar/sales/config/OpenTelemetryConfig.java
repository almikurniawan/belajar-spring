package com.belajar.sales.config;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.exporter.otlp.http.trace.OtlpHttpSpanExporter;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class OpenTelemetryConfig {
//
//    @Bean
//    public OpenTelemetry openTelemetry() {
//        OtlpHttpSpanExporter spanExporter = OtlpHttpSpanExporter.builder()
//                .setEndpoint("http://localhost:4317") // Sesuaikan dengan endpoint OpenTelemetry/Jaeger Anda
//                .build();
//
//        SdkTracerProvider tracerProvider = SdkTracerProvider.builder()
//                .addSpanProcessor(BatchSpanProcessor.builder(spanExporter).build())
//                .build();
//
//        OpenTelemetrySdk openTelemetrySdk = OpenTelemetrySdk.builder()
//                .setTracerProvider(tracerProvider)
//                .build();
//
//        GlobalOpenTelemetry.set(openTelemetrySdk);
//
//        return openTelemetrySdk;
//    }
//
//    @Bean
//    public Tracer tracer() {
//        return GlobalOpenTelemetry.getTracer("com.belajar");
//    }
//}
