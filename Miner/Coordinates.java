/**
 * Created by User on 12/03/17.
 */
public class Coordinates {
    public int x,y;

    public Coordinates(Coordinates coordinates) {
        this.x = coordinates.x;
        this.y = coordinates.y;
    }


    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates() {
        this.x = 0;
        this.y = 0;
    }

    public boolean equals(Coordinates coordinates) {
        return (this.x==coordinates.x&&this.y==coordinates.y);
    }
}
