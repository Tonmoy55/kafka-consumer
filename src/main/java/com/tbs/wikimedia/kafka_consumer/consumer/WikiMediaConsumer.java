package com.tbs.wikimedia.kafka_consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WikiMediaConsumer {

    @KafkaListener(topics = "wikimedia_stream", groupId = "kafka-consumer")
    public void consumeWikiMediaStreamMsg(String msg) {
        log.info(String.format("#### -> Consuming message from wikimedia_stream topic :: %s", msg));
    }
}
