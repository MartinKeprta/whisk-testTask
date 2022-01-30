package com.whisk.qa.rest.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whisk.qa.rest.dao.shoppingList.Content;
import com.whisk.qa.rest.dao.shoppingList.ShoppingListDao;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShoppingListResponseWrapper {
    @JsonProperty("list")
    ShoppingListDao list;
    @JsonProperty("content")
    Content content;


}
