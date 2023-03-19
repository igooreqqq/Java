import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> eo = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            eo.add(0);
        }
        for(int i = 0; i < arr.size(); i++) {
            int count = 0;
            for(int j = 0; j < arr.size(); j++) {
                if((arr.get(i) == arr.get(j)) && (i != j)) {
                    count += 1;
                }
            }
            eo.set(arr.get(i), count + 1);
        }
        return eo;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.countingSort(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
