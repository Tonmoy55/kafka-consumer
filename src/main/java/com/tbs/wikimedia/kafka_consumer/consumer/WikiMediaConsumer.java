package com.tbs.wikimedia.kafka_consumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tbs.wikimedia.kafka_consumer.document.WikiMediaStreamShortDocument;
import com.tbs.wikimedia.kafka_consumer.dto.CustomWikiMediaMsgDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class WikiMediaConsumer {

    private final MongoTemplate mongoTemplate;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "wikimedia_stream", groupId = "kafka-consumer")
    public void consumeWikiMediaStreamMsg(String msg) throws JsonProcessingException {
        log.info(String.format("#### -> Consuming message from wikimedia_stream topic :: %s", msg));
        /*var wikiMediaMsg = WikiMediaStreamDocument
                .builder()
                .msg(msg)
                .build();
        mongoTemplate.save(wikiMediaMsg);*/

        var customWikiMediaMsg = objectMapper.readValue(msg, CustomWikiMediaMsgDto.class);

        var wikiMediaMsg =WikiMediaStreamShortDocument.builder()
                .id_wikimedia(customWikiMediaMsg.getIdWikimedia())
                .type(customWikiMediaMsg.getType())
                .namespace(customWikiMediaMsg.getNamespace())
                .title(customWikiMediaMsg.getTitle())
                .title_url(customWikiMediaMsg.getTitleUrl())
                .build();
        mongoTemplate.save(wikiMediaMsg);
    }
}
