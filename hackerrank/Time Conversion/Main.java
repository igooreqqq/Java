import java.io.*;
import java.text.*;
import java.util.*;


class Result {

    public static String timeConversion(String s) throws ParseException{
        DateFormat input = new SimpleDateFormat("hh:mm:ssa");
        DateFormat output = new SimpleDateFormat("HH:mm:ss");
        Date date = input.parse(s);
        return output.format(date);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
