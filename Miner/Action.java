/**
 * Created by User on 12/03/17.
 */
public class Action {
    private Actions action;
    private Coordinates coordinates, cellCoordinates; // coordinates - input coordinates, cellCoordinates - coordinates of the corresponding cell

    public Action(Actions action, Coordinates coordinates) { // construct action from activity and coordinates (not used here but probably will be used in the GUI version)
        this.action = action;
        this.coordinates = coordinates;
        this.cellCoordinates=CalculateCellCoordinates(this.coordinates);
    }

    public Action (String action) {// construct action from string input
        this.action=Actions.ERROR;// by default - error
        this.coordinates=new Coordinates();// with 0 coordinates

        String[] CoordinatesAndAction;

        CoordinatesAndAction=action.split(" ");// separate input
        if (CoordinatesAndAction.length==3||CoordinatesAndAction.length==2) {// must be either 2 or 3 parameters

            if (CoordinatesAndAction.length == 2) {// if two parameters
                this.action = Actions.CLICK;// click
            }

            else { // if 3
                this.action=Actions.FLAG;// flag

            }

            try {// if integers are typed
                this.coordinates.y = Integer.parseInt(CoordinatesAndAction[0]);// just convert them (note that Y goes FIRST
                this.coordinates.x = Integer.parseInt(CoordinatesAndAction[1]);
            }
                catch (Exception e) { // if not - apparent ERROR
                    this.action = Actions.ERROR;
                    this.coordinates.x=0;
                    this.coordinates.y=0;
                }

        }

        this.cellCoordinates=CalculateCellCoordinates(this.coordinates);
    }

    private Coordinates CalculateCellCoordinates (Coordinates coordinates) {// needed to convert coordinates to cell coordinates (in the case of text input the difference is 1)
        Coordinates cellCoordinates = new Coordinates();
        cellCoordinates.x=coordinates.x-1;
        cellCoordinates.y=coordinates.y-1;
        return cellCoordinates;
    }

    public Actions getAction() {
        return action;
    }

    public Coordinates getCellCoordinates() {
        return cellCoordinates;
    }

    public void setAction(Actions action) {
        this.action = action;
    }
}
