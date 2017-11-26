package com.crud.tasks.controller;

import com.crud.tasks.domian.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    private static final String KODILLA = "kodilla";

    @Autowired
    private TrelloClient trelloClient;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {

        // List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        //trelloBoards.forEach(trelloBoardDto -> System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName()));


            List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();
            List<TrelloBoardDto> filteredTrelloBoards = trelloBoards.stream()
                    .filter(t -> t.getId() != null)
                    .filter(t->t.getName().contains(KODILLA))
                    .collect(Collectors.toList());
            return filteredTrelloBoards;
        }
    }
