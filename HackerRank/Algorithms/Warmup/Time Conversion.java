import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        String time_in_12hr = in.next();
        SimpleDateFormat sdf12 = new SimpleDateFormat("hh:mm:ssaa");
        SimpleDateFormat sdf24 = new SimpleDateFormat("HH:mm:ss");
        try {
            Date date = sdf12.parse(time_in_12hr);

            System.out.print(sdf24.format(date));
        }
        catch (ParseException e){
            System.out.print(e.getMessage());
        }

    }
}