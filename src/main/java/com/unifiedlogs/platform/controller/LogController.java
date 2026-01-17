package com.unifiedlogs.platform.controller;

import com.unifiedlogs.platform.model.document.LogDocument;
import com.unifiedlogs.platform.model.search.LogSearchDocument;
import com.unifiedlogs.platform.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/logs")
@RequiredArgsConstructor
public class LogController {

    private final LogService logService;

    @PostMapping
    public LogDocument ingest(@RequestBody LogDocument log) {
        log.setTimestamp(Instant.now());
        return logService.ingestLog(log);
    }

    @GetMapping("/search")
    public List<LogSearchDocument> search(@RequestParam String q) {
        return logService.searchLogs(q);
    }
}
