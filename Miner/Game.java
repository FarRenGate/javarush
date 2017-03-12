import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by User on 12/03/17.
 */
public class Game {
    private int numberOfMines, numberOfFlags, fieldsOpen, fieldsTotal, xSize, ySize;
    private boolean isExploded;
    private Field field;



    public Game(int xSize, int ySize, int numberOfMines) {
        field = new Field(xSize, ySize, numberOfMines);
        this.numberOfMines = field.getNumberOfMines();
        this.xSize = field.getxSize();
        this.ySize = field.getySize();
        this.numberOfFlags=0;
        this.fieldsOpen=0;
        this.fieldsTotal=this.xSize*this.ySize;
        this.isExploded=false;
        Run();
    }

    public void Run () {

            Redraw();
            Action action = ReadAction(AskForAction());
        field.PutMines(new Coordinates(action.getCoordinates()));
        InGame();
    }

    public void InGame (){
        while (true) {
            numberOfFlags=field.getNumberOfFlags();
            fieldsOpen=field.getNumberOfOpenFields();
            Redraw();

            if (fieldsOpen+numberOfFlags==fieldsTotal) {
                System.out.println("Congratulations, you won!");
                break;
            }

            if (isExploded) {
                System.out.println("Unfortunately, your guts are all around!");
                break;
            }

            Action action = ReadAction(AskForAction());

            switch (action.getAction()) {
                case CLICK:
                     isExploded = field.ClickOnCell(action.getCoordinates()); break;
                case FLAG:
                    field.FlagCell(action.getCoordinates()); break;
            }



        }
    }

    public void Explode () {
        isExploded=true;
    }

    public boolean IsInGame () {
        return !isExploded;
    }

    public Action ReadAction (String s)
    {
        Action action = new Action(s);
        if (action.getCellCoordinates().x<0||action.getCellCoordinates().x>=xSize) {
            action.setAction(Actions.ERROR);
        }

        if (action.getCellCoordinates().y<0||action.getCellCoordinates().y>=ySize) {
            action.setAction(Actions.ERROR);
        }

        return action;

    }

    public void Redraw () {

        for (int i = 0; i < 50; i++) System.out.println();

        System.out.println(String.format("Mines: %d, Flags put: %d, Mines left: %d",numberOfMines,numberOfFlags,numberOfMines-numberOfFlags ));
        System.out.printf("\n  ");

        for (int i=1; i<=xSize; i++) {
            System.out.printf(Integer.toString(i%10));
        }

        System.out.printf("\n");

        for (int j=1; j<=ySize; j++) {
            System.out.printf(String.format("%d ",j));
            for (int i=1; i<=xSize; i++) {
                System.out.printf(field.getDrawnOutput(new Coordinates(i-1,j-1)));
            }
            System.out.println();
        }


    }

    public String AskForAction () {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter your action in format Line Row (optional)f where (optional)f is to flag/unflag cell");
        try {
            return reader.readLine();
        }
        catch (Exception e) {
            return null;
        }
    }

}
