package com.crud.tasks.domian;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TrelloCard {
    private String name;
    private String description;
    private String pos;
    private String listId;
}
