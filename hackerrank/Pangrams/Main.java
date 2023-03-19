import java.io.*;

class Result {

    public static String pangrams(String s) {
        s = s.toLowerCase();
        boolean[] letters = new boolean[26];
        int index = 0;
        for(int i = 0; i < s.length(); i++) {
            if ('a' <= s.charAt(i) && s.charAt(i) <= 'z') {
                index = s.charAt(i) - 'a';
                letters[index] = true;
            }
        }
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == false) {
                return "not pangram";
            }
        }
        return "pangram";
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
