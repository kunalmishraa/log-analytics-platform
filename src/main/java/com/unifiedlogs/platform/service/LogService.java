package com.unifiedlogs.platform.service;

import com.unifiedlogs.platform.model.document.LogDocument;
import com.unifiedlogs.platform.model.search.LogSearchDocument;
import com.unifiedlogs.platform.repository.LogMongoRepository;
import com.unifiedlogs.platform.repository.search.LogSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogService {

    private final LogMongoRepository mongoRepository;
    private final LogSearchRepository searchRepository;

    public LogDocument ingestLog(LogDocument log) {
        LogDocument saved = mongoRepository.save(log);

        searchRepository.save(
                LogSearchDocument.builder()
                        .id(saved.getId())
                        .message(saved.getMessage())
                        .level(saved.getLevel())
                        .source(saved.getSource())
                        .timestamp(saved.getTimestamp())
                        .tags(saved.getTags())
                        .build()
        );

        return saved;
    }

    @Cacheable(value = "searchCache", key = "#keyword")
    public List<LogSearchDocument> searchLogs(String keyword) {
        return searchRepository.findByMessageContaining(keyword);
    }
}
