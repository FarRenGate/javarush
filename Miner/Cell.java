/**
 * Created by User on 12/03/17.
 */
public class Cell {
    private int neighboringMines, isFlaggedOrOpen, x, y; //neighboringMines - number of neighboring mines (-1 - has mine); isFlaggedOrOpen: -1 flagged, 0 closed, 1 open;

    public Cell (int x, int y) {
        this.x=x;
        this.y=y;
        this.neighboringMines=0;
        this.isFlaggedOrOpen=0;
    }

    public boolean ContainsMine () {
        return (this.neighboringMines==-1);
    }

    public boolean isClosed () {
        return this.isFlaggedOrOpen==0;
    }

    public int getIsFlaggedOfOpen () {return this.isFlaggedOrOpen;}

    public void Open () {
        if (this.isFlaggedOrOpen==0) {
            this.isFlaggedOrOpen=1;
        }
    }

    public int Flag () {
       if (this.isFlaggedOrOpen==-1) {
           this.isFlaggedOrOpen=0;
           return -1;
       }
       else if (this.isFlaggedOrOpen==0) {
           this.isFlaggedOrOpen=-1;
           return 1;
       }
       return 0;
    }

    public void PutMine (){
        this.neighboringMines=-1;
    }

    public void setNeighboringMines (int neighboringMines) {
        if (neighboringMines>=0&&neighboringMines<=9) {
            this.neighboringMines = neighboringMines;
        }
    }

    public void AddNeigboringMine () {
        neighboringMines++;
    }

    public int getNeighboringMines () {
        return this.neighboringMines;
    }

    public boolean isExploded () {
        return (isFlaggedOrOpen==1&&ContainsMine());
    }

}
