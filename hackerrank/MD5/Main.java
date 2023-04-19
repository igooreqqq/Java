import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Solution {

    public static void main(String[] args) throws NoSuchAlgorithmException{
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashedBytes = md.digest(input.getBytes());
        
        StringBuilder sb = new StringBuilder();
        for(byte b : hashedBytes) {
            sb.append(String.format("%02x", b));
        }
        
        System.out.println(sb.toString());
    }
}
