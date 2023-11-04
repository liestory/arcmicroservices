package com.arcmicroservices.schedule;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Clock;

/**
 * CronSchedule.
 *
 * @author Ilya_Sukhachev
 */
@Component
@ConditionalOnProperty(prefix = "scheduling.timeout", name = {"enabled"}, matchIfMissing = false)
@Slf4j
@AllArgsConstructor
public class TimeSchedule {

    private Clock clock;

    @Scheduled(fixedDelayString = "${scheduling.timeout.interval}")
    public void schedule() {
        var now = clock.instant();
        log.info("application is work: {}", now);
    }

}
