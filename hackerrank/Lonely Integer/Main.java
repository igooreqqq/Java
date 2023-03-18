import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    public static int lonelyinteger(List<Integer> a) {
    Integer[] lista = new Integer[a.size()];
    lista = a.toArray(lista);
    int lonely = 0;
    
    for(int i = 0; i < lista.length; i++) {
        boolean foundDuplicate = false;
        for(int j = 0; j < lista.length; j++) {
            if(i != j) {
                if(lista[i] == lista[j]) {
                    foundDuplicate = true;
                    break;
                }
            }
        }
        if(!foundDuplicate) {
            lonely = lista[i];
            break;
        }
    }
    return lonely;
}

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.lonelyinteger(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
