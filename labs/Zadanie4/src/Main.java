import java.io.*;

public class Main {

    public static void main(String[] args) {

        try{
            FileInputStream fstream = new FileInputStream(args[0]);
            FileOutputStream fout = new FileOutputStream(args[1]);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fout));

            if(args[2].equals("crypt")) {
                if (args[3].equals("rot"))
                    Cryptographer.cryptfile(br, bw, new ROT11());
                if (args[3].equals("polibiusz"))
                    Cryptographer.cryptfile(br, bw, new Polibiusz());
            }

            if(args[2].equals("decrypt")) {
                if (args[3].equals("rot"))
                    Cryptographer.decryptfile(br, bw, new ROT11());
                if (args[3].equals("polibiusz"))
                    Cryptographer.decryptfile(br, bw, new Polibiusz());
            }


            br.close();
            bw.close();

            fstream.close();
            fout.close();
        }catch(Exception e){System.out.println(e);}
    }
}
