package com.whisk.qa.rest.dao.shoppingList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Items {
    @JsonProperty("id")
    String id;
    @JsonProperty("item")
    Item item;
    @JsonProperty("image_url")
    String image_url;
    @JsonProperty("analysis")
    Analysis analysis;
    @JsonProperty("created_time")
    String created_time;
    @JsonProperty("updated_at")
    String updated_at;
}
