import java.io.*;

public class Cryptographer {
    public static void cryptfile(BufferedReader br, BufferedWriter bw, Algorithm algorithm) throws IOException{
            String strLine;

            while((strLine = br.readLine()) != null)   {
                bw.write(algorithm.crypt(strLine));
                bw.newLine();
            }
    }

    public static void decryptfile(BufferedReader br, BufferedWriter bw, Algorithm algorithm) throws IOException{
            String strLine;

            while((strLine = br.readLine()) != null)   {
                bw.write(algorithm.decrypt(strLine));
                bw.newLine();
            }
    }
}

