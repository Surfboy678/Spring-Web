package com.crud.tasks.controller;

import com.crud.tasks.domian.CreatedTrelloCard;
import com.crud.tasks.domian.TrelloBoardDto;
import com.crud.tasks.domian.TrelloCardDto;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloService trelloService;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {
        return trelloService.fetchTrelloBoards();
    }

        //List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

//        trelloBoards.forEach(trelloBoardDto -> {

//            System.out.println(trelloBoardDto.getName() + " - " + trelloBoardDto.getId());

        //          System.out.println("This board contains lists: ");

        //        trelloBoardDto.getLists().forEach(trelloList ->
        //              System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed()));

  //  }

        @RequestMapping(method = RequestMethod.POST, value = "createTrelloCard")
                public CreatedTrelloCard createdTrelloCard(@RequestBody TrelloCardDto trelloCardDto){
        return trelloService.createTrelloCard(trelloCardDto);
       }
}
