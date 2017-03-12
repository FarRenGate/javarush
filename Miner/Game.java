import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by User on 12/03/17.
 */
public class Game {
    private int numberOfMines, numberOfFlags, fieldsOpen, fieldsTotal, xSize, ySize; // Everything clear by itself?
    private boolean isExploded; // of the mine was exploded = game over
    private Field field; // the game field



    public Game(int xSize, int ySize, int numberOfMines) {
        field = new Field(xSize, ySize, numberOfMines); // creating a game field
        this.numberOfMines = field.getNumberOfMines(); // retrieving the number of mine (it's needed as the field's constructor check if the number of mines entered were allowed (i.e. !=0 and less than field size)
        this.xSize = field.getxSize();// retrieving xSize of field
        this.ySize = field.getySize();// ySize
        this.numberOfFlags=0; // no flags are put yet
        this.fieldsOpen=0;// and the field is totally undiscovered
        this.fieldsTotal=this.xSize*this.ySize; // total size
        this.isExploded=false;
        Run(); // start the game!
    }

    public void Run () {

            Redraw(); // draw our first (closed) field
            Action action = ReadAction(AskForAction()); // wait for action from player
        field.PutMines(new Coordinates(action.getCellCoordinates())); // as first clicked cell must be empty - putting the mines only now
        InGame(); // run main game cycle
    }

    public void InGame (){
        while (true) {
            numberOfFlags=field.getNumberOfFlags();
            fieldsOpen=field.getNumberOfOpenFields();
            Redraw();

            if ((fieldsOpen+numberOfFlags==fieldsTotal)&&(numberOfFlags==numberOfMines)) { // if correct number of flags are placed and the rest of the field is open
                WinGame(); // you win
                break;
            }

            if ((fieldsTotal-fieldsOpen)==(numberOfMines-numberOfFlags )) { //another winning situation - number of unopend fields equal to number of mines-to-be-found
                WinGame(); // you win
                break;
            }

            if (isExploded) { // if the mine is blown
                LoseGame(); // you lost
                break;
            }

            Action action = ReadAction(AskForAction()); // wait for action from player

            switch (action.getAction()) {
                case CLICK:
                     isExploded = field.ClickOnCell(action.getCellCoordinates()); break; // if click - click on cell
                case FLAG:
                    field.FlagCell(action.getCellCoordinates()); break; // if flag - mark cell as flagged
            }



        }
    }

    public Action ReadAction (String s) // convert input to action
    {
        Action action = new Action(s);

        if (action.getCellCoordinates().x<0||action.getCellCoordinates().x>=xSize) { // if coordinates are bad - do not perform the action
            action.setAction(Actions.ERROR);
        }

        if (action.getCellCoordinates().y<0||action.getCellCoordinates().y>=ySize) {
            action.setAction(Actions.ERROR);
        }

        return action; // otherwise everything is fine

    }

    public void Redraw () { // redraw field

        for (int i = 0; i < 50; i++) System.out.println(); // "wipe" previous field

        System.out.println(String.format("Mines: %d, Flags put: %d, Mines left: %d",numberOfMines,numberOfFlags,numberOfMines-numberOfFlags )); // just some game information
        System.out.printf("\n  ");

        for (int i=1; i<=xSize; i++) {
            System.out.printf(Integer.toString(i)); // x-coordinates
        }

        System.out.printf("\n");

        for (int j=1; j<=ySize; j++) {
            System.out.printf(String.format("%d ",j)); // y-coordinate
            for (int i=1; i<=xSize; i++) {
                System.out.printf(field.getDrawnOutput(new Coordinates(i-1,j-1))); // and the fields (getDrawnOutput returns what should be drawn)
            }
            System.out.println();
        }


    }

    public String AskForAction () { // ask user for input
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter your action in format Line Row (optional)f where (optional)f is to flag/unflag cell");
        try {
            return reader.readLine();
        }
        catch (Exception e) {
            return null;
        }
    }

    private void WinGame() {
        System.out.println("Congratulations, you won!");
    }

  private void LoseGame() {
      System.out.println("Unfortunately, your guts are all around!");
    }

}
