package de.mobilcom.prometheus_demo;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class DemoController {

    private static final String NAME = "demo-counter";

    private final Map<String,Counter> counterMap;
    private final MeterRegistry meterRegistry;

    DemoController(MeterRegistry meterRegistry) {

        this.meterRegistry = meterRegistry;
        counterMap = new ConcurrentHashMap<>();
    }

    @GetMapping("/increaseCounter/{tag}")
    public void increaseCounter(@PathVariable String tag) {

        counterMap.getOrDefault(tag, createCounter(tag)).increment();
    }

    private Counter createCounter(String tag) {

        return Counter.builder(NAME)
                .tag("tag", tag)
                .register(meterRegistry);
    }
}
