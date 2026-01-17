package com.unifiedlogs.platform.scheduler;

import com.unifiedlogs.platform.model.document.LogDocument;
import com.unifiedlogs.platform.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
@RequiredArgsConstructor
public class LogCrawlerJob {

    private final LogService logService;

    @Scheduled(fixedRate = 60000)
    public void crawl() {
        LogDocument log = LogDocument.builder()
                .source("system")
                .message("Health check OK")
                .level("INFO")
                .timestamp(Instant.now())
                .tags(List.of("health"))
                .build();

        logService.ingestLog(log);
    }
}
