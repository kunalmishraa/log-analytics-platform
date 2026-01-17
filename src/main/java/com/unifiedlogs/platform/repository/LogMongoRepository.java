package com.unifiedlogs.platform.repository;

import com.unifiedlogs.platform.model.document.LogDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogMongoRepository extends MongoRepository<LogDocument, String> {
}
