package com.unifiedlogs.platform.model.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document(collection = "logs")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogDocument {

    @Id
    private String id;

    private String source;
    private String message;
    private String level;
    private Instant timestamp;
    private List<String> tags;
}
