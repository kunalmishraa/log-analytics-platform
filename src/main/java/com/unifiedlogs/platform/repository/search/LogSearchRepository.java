package com.unifiedlogs.platform.repository.search;

import com.unifiedlogs.platform.model.search.LogSearchDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface LogSearchRepository
        extends ElasticsearchRepository<LogSearchDocument, String> {

    List<LogSearchDocument> findByMessageContaining(String keyword);
}
