package pl.edu.uj.javaframe;

import java.io.*;
import java.util.ArrayList;

public class DataFrame {
    ArrayList<Series> columns = new ArrayList<>();

    public DataFrame(Class<? extends Value>[] types, String[] vals){
        for(int i = 0; i < types.length; i++){
            columns.add(new Series(types[i], vals[i]));

        }
    }

    public void addRow(String[] values){
        for(int i  = 0; i < columns.size(); i++){
            columns.get(i).addValue(values[i]);
        }
    }

    public void head(){
        int rows = 0;
        for(int j =0; j < columns.size(); j++) {
            System.out.print(columns.get(j).name+" ");
        }
        System.out.println();
        for(int j =0; j < columns.get(0).values.size(); j++) {
            for (int i = 0; i < columns.size(); i++) {
                columns.get(i).values.get(j).print();
                System.out.print(' ');
            }
            System.out.println();
            rows ++;
            if(rows > 5){
                return;
            }
        }
    }


    public DataFrame iloc(int from, int to){
        Class<? extends Value>[] types = new  Class[columns.size()];
        String[] names = new String[columns.size()];
        for(int i = 0; i < columns.size();i++){
            types[i] = columns.get(i).type;
            names[i] = columns.get(i).name;
        }

        DataFrame result = new DataFrame(types, names);

        for(int i=from; i < to; i++){
            String[] vals = new String[columns.size()];
            for(int ci = 0; ci< columns.size();ci++){
                vals[ci] = columns.get(ci).values.get(i).toString();
            }
            result.addRow(vals);
        }
        return result;
    }


    public static DataFrame readCSV(String path,Class<? extends Value>[] types) throws IOException {
        FileInputStream fstream = new FileInputStream(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;

        //Read File Line By Line
        DataFrame df = null;
        while ((strLine = br.readLine()) != null)   {
            // Print the content on the console
            String[] row = strLine.split(",");
            if(df == null) {
                df = new DataFrame(types, row);
            }else{
                df.addRow(row);
            }


        }

        //Close the input stream
        br.close();

        return df;
    }

    public void apply(Applayable a, String name){
        Series s = null;
        for(int i=0; i < columns.size(); i++){
            if(columns.get(i).name.equals(name)){
                s = columns.get(i);
                break;
            }
        }
        a.apply(s);
    }

    public void apply(Applayable a, String name, int njobs){
        Series s = null;
        for(int i=0; i < columns.size(); i++){
            if(columns.get(i).name.equals(name)){
                s = columns.get(i);
                break;
            }
        }

        int step = this.columns.get(0).values.size()/njobs;
        ApplayableThread [] tasks = new ApplayableThread[njobs];
        for(int i=0,taskid=0;i<columns.get(0).values.size();i+=step,taskid++){
            Series toApply = s.iloc(i,i+step);
            tasks[taskid] = new ApplayableThread(toApply,a);
        }
        try {
            for (ApplayableThread task : tasks) {
                task.start();
                task.join();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        //TODO: zbierz wyniki

    }

    class ApplayableThread extends Thread{
        Series result;
        public ApplayableThread(Series s, Applayable task){
            //TODO
        }
        @Override
        public void run() {
            //TODO
            System.out.println("Obliczam");

        }
    }

    public void print(){
        for(int i = 0; i <columns.size(); i++) {
            System.out.printf("%-16s", columns.get(i).name);
        }
        System.out.println();
        for(int i = 0; i < columns.get(0).values.size(); i++){
            for(int j = 0; j < columns.size(); j++){
                System.out.printf("%-16s", columns.get(j).values.get(i));
            }
            System.out.println();
        }
    }

}
