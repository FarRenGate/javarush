import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by User on 20/03/17.
 */
public class Solution {


       public static ArrayList<Long> buffer = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        buffer.add(Long.valueOf(0));
        buffer.add(Long.valueOf(1));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(Fibonacci(n));
    }

    static Long Fibonacci (int n) {

        if (n<2) {
            return Long.valueOf(n);
        }
        else {

            if (buffer.size()<n) {
                buffer.add(n-1,Fibonacci(n - 1) + Fibonacci(n - 2));
                return buffer.get(n-1);

            }
            else
                return buffer.get(n-1);
        }
    }
}
