package pl.edu.uj.javaframe;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MicroDVD {

    public static void delay(BufferedReader br, BufferedWriter bw, int delay, int fps) throws FileException{
        Scanner in = new Scanner(br);
        PrintWriter out = new PrintWriter(bw);
        String nextline = "";
        String finalLine = "";
        int LineInFile = 0;
        while(in.hasNextLine()) {
            LineInFile++;
            nextline = in.nextLine();
            String line[] = nextline.split("[{}]");
            if(Pattern.matches("[0-9]+", line[1]) && Pattern.matches("[0-9]+", line[3])) {

                //System.out.println(line[1] + "     " + line[3]);

                Integer begin_frame = Integer.parseInt(line[1]);
                Integer end_frame = Integer.parseInt(line[3]);

                if(begin_frame > end_frame) {
                    throw new FileException(nextline, LineInFile);
                }

                begin_frame += (delay * fps) / 1000;
                end_frame += (delay * fps) / 1000;

                if(begin_frame < 0 || end_frame < 0) {
                    throw new FileException();
                }

                finalLine = "{" + begin_frame.toString() + "}" + "{" + end_frame.toString() + "}" + line[4];

                out.write(finalLine + '\n');

            } else {
                throw new FileException(nextline, LineInFile);
            }

        }
        in.close();
        out.close();
    }
}