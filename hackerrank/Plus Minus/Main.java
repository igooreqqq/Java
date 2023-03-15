import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;


class Result {
    
    public static void plusMinus(List<Integer> arr){
        List<Integer> positive = new ArrayList<Integer>();
        List<Integer> negative = new ArrayList<Integer>();
        List<Integer> zeros = new ArrayList<Integer>();
        for(int num : arr) {
            if(num > 0) {
                positive.add(num);
            }
            if(num < 0) {
                negative.add(num);
            }
            if(num == 0) {
                zeros.add(num);
            }
        }
        
        System.out.println(Double.valueOf(positive.size()) / Double.valueOf(arr.size()));
        System.out.println(Double.valueOf(negative.size()) / Double.valueOf(arr.size()));
        System.out.println(Double.valueOf(zeros.size()) / Double.valueOf(arr.size()));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
