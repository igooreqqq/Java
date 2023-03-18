import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    public static void miniMaxSum(List<Integer> arr) {
        Collections.sort(arr);
        Integer[] intArray = new Integer[arr.size()];
        intArray = arr.toArray(intArray);
        
        List<Integer> min = new ArrayList<Integer>();
        List<Integer> max = new ArrayList<Integer>();
        
        for(int i = 0; i < 4; i++) {
            min.add(intArray[i]);
        }
        long sumMin = 0;
        for(int x : min) {
            sumMin += x;
        }
        
        for(int i = 1; i < 5; i++) {
            max.add(intArray[i]);
        }
        long sumMax = 0;
        for(int x : max) {
            sumMax += x;
        }
        
        System.out.println(sumMin + " " + sumMax);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
