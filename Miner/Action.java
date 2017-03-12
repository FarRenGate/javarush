/**
 * Created by User on 12/03/17.
 */
public class Action {
    private Actions action;
    private Coordinates coordinates, cellCoordinates;

    public Action(Actions action, Coordinates coordinates) {
        this.action = action;
        this.coordinates = coordinates;
        this.cellCoordinates=CalculateCellCoordinates(this.coordinates);
    }

    public Action (String action) {
        this.action=Actions.ERROR;
        this.coordinates=new Coordinates();

        String[] CoordinatesAndAction;

        CoordinatesAndAction=action.split(" ");
        if (CoordinatesAndAction.length==3||CoordinatesAndAction.length==2) {

            if (CoordinatesAndAction.length == 2) {
                this.action = Actions.CLICK;
            }

            else {
                this.action=Actions.FLAG;

            }

            try {
                this.coordinates.y = Integer.parseInt(CoordinatesAndAction[0]);
                this.coordinates.x = Integer.parseInt(CoordinatesAndAction[1]);
            }
                catch (Exception e) {
                    this.action = Actions.ERROR;
                    this.coordinates.x=0;
                    this.coordinates.y=0;
                }

        }

        this.cellCoordinates=CalculateCellCoordinates(this.coordinates);
    }

    private Coordinates CalculateCellCoordinates (Coordinates coordinates) {
        Coordinates cellCoordinates = new Coordinates();
        cellCoordinates.x=coordinates.x-1;
        cellCoordinates.y=coordinates.y-1;
        return cellCoordinates;
    }

    public Actions getAction() {
        return action;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Coordinates getCellCoordinates() {
        return cellCoordinates;
    }

    public void setAction(Actions action) {
        this.action = action;
    }
}
