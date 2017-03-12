import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by User on 12/03/17.
 */
public class Field {
    private int xSize, ySize, numberOfMines, fieldSize, numberOfFlags=0, numberOfOpenFields=0;
    private Cell[][] cells;

    public Field (int xSize, int ySize, int numberOfMines) { // creatin a field
        if (xSize>1) { // size must be >1
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

        if ((numberOfMines>(this.xSize-1)*(this.ySize-1))||numberOfMines==0) { // Number of mines must be >0 and < some value (here (X-1)*(Y-1))
            this.numberOfMines=(this.xSize-1)*(this.ySize-1);
        }
        else {
            this.numberOfMines = numberOfMines;
        }

        cells = new Cell[this.xSize][this.ySize]; // creating array of cells

        for (int i=0; i<this.xSize; i++) {
            for (int j = 0; j < this.ySize; j++) {
                cells[i][j]=new Cell(); // and initializing all cells
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

    public void PutMines(Coordinates cellCoordinates) { // place mines after first click
        int numberStartCell = CellCoordinatesToNumber(cellCoordinates); // mines are placed to randon cells, each cell is enumerated for more straightforward mine placing (basically, 2D array is converted to 1D)
        Set<Integer> mines = new TreeSet<>(); // TreeSet of mines to ensure no repetition of positions


        while (mines.size()<numberOfMines) { // while there is still something to add
            int putMine = ThreadLocalRandom.current().nextInt(fieldSize);//rangomly generating mine position within the fieldSize
            if (putMine!=numberStartCell) {// if this is not "clicking" point
                mines.add(putMine); // add mine coordinates to the mine array
            }
        }

        for (Integer mine: mines) { // for each mine coordinate
            int x=CellCoordinatesFromNumber(mine).x; // recalculate "linear" position to "2D"
            int y=CellCoordinatesFromNumber(mine).y;
            try {
            cells[x][y].PutMine(); // put a mine there
            }
            catch (Exception e) {
                System.out.println(String.format("Mine number %d, x %d, y %d", mine, x, y));
            }
        }

        for (Integer mine: mines) {// for each mine coordinate
            int x=CellCoordinatesFromNumber(mine).x;
            int y=CellCoordinatesFromNumber(mine).y;
            for (int i=x-1; i<=x+1; i++) // checking all coordinates aroung
                for (int j=y-1; j<=y+1; j++) {
                if (x!=i||y!=j) { // if this is not the mine cell
                    try { // this is needed to check the field boundaries
                        if (!cells[i][j].ContainsMine()) { // if no mine is there
                            cells[i][j].AddNeighboringMine(); // then number in the cell must be increased by 1
                        }
                    } catch (Exception e) {

                    }
                }
                }
        }

        ClickOnCell(cellCoordinates); // finally - click

    }

    public String getStatus (Coordinates cellCoordinates) {//getting what's in the cell
        Cell cell = cells[cellCoordinates.x][cellCoordinates.y];

        if (cell==null) {
            return null;
        }
        else {
            switch (cell.getIsFlaggedOrOpen()) {//checking what is in the cell
                case -1: // flag
                    return "F";
                case 0: // closed
                    return "X";
                case 1: // open
                    if (cell.ContainsMine()) { // if there's mine
                        return "*";
                    }
                    else {
                        return Integer.toString(cell.getNeighboringMines()); // or just cell with number of neighboring mines
                    }
            }

        }
        return null;
    }

    public boolean ClickOnCell (Coordinates cellCoordinates) {//processing the click,  returns if we clicked on mine
        if (cells[cellCoordinates.x][cellCoordinates.y].isClosed()) {// if the cell is not open yet
            cells[cellCoordinates.x][cellCoordinates.y].Open(); // open the cell
            numberOfOpenFields++;//increase the number of open fields
            if (cells[cellCoordinates.x][cellCoordinates.y].getNeighboringMines() == 0) {//if the cell is "0"-cell we must open all surrounding cells
                for (int i = cellCoordinates.x - 1; i <= cellCoordinates.x + 1; i++)
                    for (int j = cellCoordinates.y - 1; j <= cellCoordinates.y + 1; j++) {
                        Coordinates newClick = new Coordinates(i, j);
                        if (newClick.x >= 0 && newClick.x < xSize && newClick.y >= 0 && newClick.y < ySize && !newClick.equals(cellCoordinates)) {// if the surrounding cell is withing the field and is different cell
                                ClickOnCell(newClick);//click on it
                        }
                    }

            }
        }
        return cells[cellCoordinates.x][cellCoordinates.y].isExploded();// checking if we not open a mine
    }

    public void FlagCell (Coordinates cellCoordinates) {
        numberOfFlags+= cells[cellCoordinates.x][cellCoordinates.y].PutFlag();// flag/unflag the cell and increase/decrease number of flags placed
    }


    public String getDrawnOutput (Coordinates cellCoordinates) {// returns what to draw
        if (this.getStatus(cellCoordinates)!=null) {
            return this.getStatus(cellCoordinates);
        }
        else {
            return "X";
        }
    }


    private int CellCoordinatesToNumber (Coordinates coordinates) {// converts coordinates to linear coordinate (for the mine placing)
        return coordinates.x+(coordinates.y)*xSize;
    }

    private Coordinates CellCoordinatesFromNumber (int number) {// converts linear coordinate to coordinates (for mine placing)
        Coordinates coordinates = new Coordinates();
        coordinates.x=number%xSize;
        coordinates.y=(number-coordinates.x)/xSize;
        return coordinates;
    }


}
