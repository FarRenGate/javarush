/**
 * Created by User on 12/03/17.
 */
public class Cell {
    private int neighboringMines, isFlaggedOrOpen; //neighboringMines - number of neighboring mines (-1 - has mine); isFlaggedOrOpen: -1 flagged, 0 closed, 1 open;

    public Cell () {

        this.neighboringMines=0;
        this.isFlaggedOrOpen=0;
    }

    public boolean ContainsMine () {
        return (this.neighboringMines==-1);
    }

    public boolean isClosed () {
        return this.isFlaggedOrOpen==0;
    }

    public int getIsFlaggedOrOpen () {return this.isFlaggedOrOpen;}

    public void Open () {
        if (this.isFlaggedOrOpen==0) { // if the field is currently closed
            this.isFlaggedOrOpen=1; // open the field
        }
    }

    public int PutFlag () {// returns change in flags number
       if (this.isFlaggedOrOpen==-1) {//if already flagged
           this.isFlaggedOrOpen=0;//close cell
           return -1;// decrease number of flags
       }
       else if (this.isFlaggedOrOpen==0) {// if closed
           this.isFlaggedOrOpen=-1;// put flag
           return 1;// increase number of flags
       }
       return 0;
    }

    public void PutMine (){
        this.neighboringMines=-1;
    }

    public void AddNeighboringMine () {
        neighboringMines++;
    }

    public int getNeighboringMines () {
        return this.neighboringMines;
    }

    public boolean isExploded () {
        return (isFlaggedOrOpen==1&&ContainsMine());
    }

}
