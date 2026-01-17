package com.unifiedlogs.platform.model.search;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.Instant;
import java.util.List;

@Document(indexName = "logs_index")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogSearchDocument {

    @Id
    private String id;

    private String message;
    private String level;
    private String source;
    private Instant timestamp;
    private List<String> tags;
}
