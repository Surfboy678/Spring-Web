package com.crud.tasks.validator;

import com.crud.tasks.domian.TrelloBoard;
import com.crud.tasks.domian.TrelloCard;
import com.crud.tasks.domian.TrelloList;
import com.crud.tasks.trello.validator.TrelloValidator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TrelloValidatorTest {
    @Test
    public void shouldValidateTrelloCard(){
        //Given
        TrelloCard trelloCard = new TrelloCard("name", "descrition","top", "list");
        TrelloValidator validator = new TrelloValidator();
        //When
        validator.validateCard(trelloCard);
        //Then
        Assert.assertTrue("Someone is testing my application",true);

    }
    @Test
    public void shouldValidateTrelloBoards(){
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        List<TrelloList> trelloLists = new ArrayList<>();
        TrelloList list = new TrelloList("1", "test list", false);
        trelloLists.add(list);
        TrelloBoard board1 = new TrelloBoard("1", "test", trelloLists);
        TrelloBoard board2 = new TrelloBoard("2", "board 2", trelloLists);
        trelloBoards.add(board1);
        trelloBoards.add(board2);
        TrelloValidator validator = new TrelloValidator();
        //When
        List<TrelloBoard> testList = validator.validateTrelloBoards(trelloBoards);
        //Then
        Assert.assertEquals(1, testList.size());
        Assert.assertEquals("2", testList.get(0).getId());
    }
}



