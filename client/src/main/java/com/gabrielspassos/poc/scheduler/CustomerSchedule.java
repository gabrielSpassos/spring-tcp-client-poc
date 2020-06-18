package com.gabrielspassos.poc.scheduler;

import com.gabrielspassos.poc.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
@AllArgsConstructor
public class CustomerSchedule {

    private CustomerService customerService;
    private final ZoneId BR_ZONE_ID = ZoneId.of("America/Sao_Paulo");

    @Scheduled(fixedDelayString = "${customer.check-delay-milliseconds-time}")
    private void checkCustomer() {
        String now = LocalDateTime.now(BR_ZONE_ID).toString();
        String message = String.format("Gabriel - Time: %s", now);

        customerService.sendMessage(message);
    }


}
