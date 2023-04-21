import java.math.BigDecimal;
import java.util.*;
class Solution{

    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
      	sc.close();

        
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                double d1, d2;
                try {
                    d1 = Double.parseDouble(s1);
                } catch (NumberFormatException | NullPointerException e) {
                    d1 = Double.NEGATIVE_INFINITY;
                }
                try {
                    d2 = Double.parseDouble(s2);
                } catch (NumberFormatException | NullPointerException e) {
                    d2 = Double.NEGATIVE_INFINITY;
                }
                return Double.compare(d2, d1);
            }
        });
        

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}
