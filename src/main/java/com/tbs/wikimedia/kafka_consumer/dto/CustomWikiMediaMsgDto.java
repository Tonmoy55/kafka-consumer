package com.tbs.wikimedia.kafka_consumer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class CustomWikiMediaMsgDto {

    @JsonProperty("id")
    private String idWikimedia;
    private String type;
    private String namespace;
    private String title;
    @JsonProperty("title_url")
    private String titleUrl;

}
