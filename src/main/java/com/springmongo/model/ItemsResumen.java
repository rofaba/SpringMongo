package com.springmongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemsResumen {

    private long totalItems;
    private long itemsCountLessThan10;
    List<String> fabricantes;


    public ItemsResumen(long totalItems, long itemsCountLessThan10) {
        this.totalItems = totalItems;
        this.itemsCountLessThan10 = itemsCountLessThan10;
        this.fabricantes = new ArrayList<>();
    }

}
