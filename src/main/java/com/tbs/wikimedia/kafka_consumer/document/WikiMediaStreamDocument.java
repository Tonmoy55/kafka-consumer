package com.tbs.wikimedia.kafka_consumer.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "wikimedia_streams")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WikiMediaStreamDocument {
    @Id
    private String id;
    private String msg;
}
