package com.whisk.qa.rest.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whisk.qa.rest.dao.shoppingList.ShoppingListDao;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShoppingListGetAllResponse {
    @JsonProperty("list")
    List<ShoppingListDao> list=new ArrayList<>();

}
