import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by User on 12/03/17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        int x=8, y=8, mines=6;

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter field size (XxY) and number of mines");
        String s[] = reader.readLine().split(" ");
        try {
            x = Integer.parseInt(s[0]);
            y = Integer.parseInt(s[1]);
            mines = Integer.parseInt(s[2]);
        }
        catch (Exception e) {

        }

        if (x>9) x=9;
        if (y>9) y=9;

        Game game = new Game(x,y,mines);

    }
}
