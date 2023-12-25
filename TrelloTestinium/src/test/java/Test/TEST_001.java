package Test;

import Controllers.BoardsController;
import Controllers.CardController;
import org.testng.annotations.Test;

public class TEST_001 {

    @Test
    public void test(){
        BoardsController boards = new BoardsController();
        CardController cards = new CardController();

        boards.createBoard();

        String Card1 =  cards.CreateCard(boards.BoardID,boards.ListID);
        String Card2 =  cards.CreateCard(boards.BoardID,boards.ListID);
        cards.UpdateCard(Card1);
        cards.DeleteCard(Card1);
        cards.DeleteCard(Card2);
        boards.DeleteBoard(boards.BoardID);
    }
}
