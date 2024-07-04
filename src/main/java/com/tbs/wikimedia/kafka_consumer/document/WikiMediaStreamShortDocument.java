package com.tbs.wikimedia.kafka_consumer.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "wikimedia_stream_short")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WikiMediaStreamShortDocument {
    @Id
    private String id;
    private String id_wikimedia;
    private String type;
    private String namespace;
    private String title;
    private String title_url;

}
