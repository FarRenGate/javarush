import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by User on 12/03/17.
 */
public class Field {
    private int xSize, ySize, numberOfMines, fieldSize, numberOfFlags=0, numberOfOpenFields=0;
    private Cell[][] cells;

    public Field (int xSize, int ySize, int numberOfMines) {
        if (xSize>1) {
            this.xSize=xSize;
        }
        else {
            this.xSize=2;
        }
        this.ySize=ySize;

        if (ySize>1) {
            this.ySize=ySize;
        }
        else {
            this.ySize=2;
        }

        if ((numberOfMines>(this.xSize-1)*(this.ySize-1))||numberOfMines==0) {
            this.numberOfMines=(this.xSize-1)*(this.ySize-1);
        }
        else {
            this.numberOfMines = numberOfMines;
        }
        cells = new Cell[this.xSize][this.ySize];

        for (int i=0; i<this.xSize; i++) {
            for (int j = 0; j < this.ySize; j++) {
                cells[i][j]=new Cell(i,j);
            }
        }
        fieldSize=this.xSize*this.ySize;
    }

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }

    public int getNumberOfFlags () {return numberOfFlags; }

    public int getNumberOfMines() {
        return numberOfMines;
    }

    public int getNumberOfOpenFields() {
        return numberOfOpenFields;
    }

    public void PutMines(Coordinates clickCoordinates) {
        int numberStartCell = CellCoordinatesToNumber(clickCoordinates);
        Set<Integer> mines = new TreeSet<>();


        while (mines.size()<numberOfMines) {
            int putMine = ThreadLocalRandom.current().nextInt(1,fieldSize+1);
            if (putMine!=numberStartCell) {
                mines.add(putMine);
            }
        }

        for (Integer mine: mines) {
            int x=CoordinatesFromNumber(mine).x;
            int y=CoordinatesFromNumber(mine).y;
            try {
            cells[x][y].PutMine();}
            catch (Exception e) {
                System.out.println(String.format("Mine number %d, x %d, y %d", mine, x, y));
            }
        }

        for (Integer mine: mines) {
            int x=CoordinatesFromNumber(mine).x;
            int y=CoordinatesFromNumber(mine).y;
            for (int i=x-1; i<=x+1; i++)
                for (int j=y-1; j<=y+1; j++) {
                if (x!=i||y!=j) {
                    try {
                        if (!cells[i][j].ContainsMine()) {
                            cells[i][j].AddNeigboringMine();
                        }
                    } catch (Exception e) {

                    }
                }
                }
        }

        ClickOnCell(clickCoordinates);

    }

    public String getStatus (Coordinates coordinates) {
        Cell cell = cells[coordinates.x][coordinates.y];

        if (cell==null) {
            return null;
        }
        else {
            switch (cell.getIsFlaggedOfOpen()) {
                case -1:
                    return "F";
                case 0:
                    return "X";
                case 1:
                    if (cell.ContainsMine()) {
                        return "*";
                    }
                    else {
                        return Integer.toString(cell.getNeighboringMines());
                    }
            }

        }
        return null;
    }

    public boolean ClickOnCell (Coordinates clickCoordinates) {
        Coordinates coordinates = CoordinatesFromClick(clickCoordinates);
        if (cells[coordinates.x][coordinates.y].isClosed()) {
            cells[coordinates.x][coordinates.y].Open();
            numberOfOpenFields++;
            if (cells[coordinates.x][coordinates.y].getNeighboringMines() == 0) {
                for (int i = clickCoordinates.x - 1; i <= clickCoordinates.x + 1; i++)
                    for (int j = clickCoordinates.y - 1; j <= clickCoordinates.y + 1; j++) {
                        Coordinates newClick = new Coordinates(i, j);
                        if (newClick.x > 0 && newClick.x <= xSize && newClick.y > 0 && newClick.y <= ySize && !newClick.equals(clickCoordinates)) {
                                ClickOnCell(newClick);
                        }
                    }

            }
        }
        return cells[coordinates.x][coordinates.y].isExploded();
    }

    public void FlagCell (Coordinates clickCoordinates) {
        Coordinates coordinates = CoordinatesFromClick(clickCoordinates);
        numberOfFlags+= cells[coordinates.x][coordinates.y].Flag();
    }


    public String getDrawnOutput (Coordinates coordinates) {
        if (this.getStatus(coordinates)!=null) {
            return this.getStatus(coordinates);
        }
        else {
            return "X";
        }
    }


    private Coordinates CoordinatesFromClick (Coordinates clickCoordinates) {
        Coordinates cordinates = new Coordinates(clickCoordinates);
        cordinates.x--;
        cordinates.y--;
        return cordinates;
    }

    private int CellCoordinatesToNumber (Coordinates coordinates) {
        return coordinates.x+(coordinates.y-1)*xSize;
    }

    private Coordinates CellCoordinatesFromNumber (int number) {
        Coordinates coordinates = new Coordinates();
        coordinates.x=number%xSize;
        if (coordinates.x==0) {
            coordinates.x=xSize;
        }
        coordinates.y=(number-coordinates.x)/xSize+1;
        return coordinates;
    }

    private Coordinates CoordinatesFromNumber (int number) {
        Coordinates coordinates = new Coordinates(CellCoordinatesFromNumber(number));
        coordinates.x--;
        coordinates.y--;
        return coordinates;
    }






}
