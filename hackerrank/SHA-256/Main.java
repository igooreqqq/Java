import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Solution {

    public static void main(String[] args) throws NoSuchAlgorithmException{
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        
        byte[] hashedBytes = md.digest(input.getBytes());
        
        StringBuilder sb = new StringBuilder();
        for(byte b : hashedBytes) {
            sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        
        System.out.println(sb.toString());
    }
}
