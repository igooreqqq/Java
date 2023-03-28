package pl.edu.uj.eo;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8001);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 8001");
            System.exit(-1);
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("Accept failed: 8001");
            System.exit(-1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));
        String inputLine;

        List<String> lista = new ArrayList<>();
        List<String> metody = new ArrayList<>();
        Map<String, Double> wyniki = new HashMap<>();
        Map<String, Double> sortedWyniki = new LinkedHashMap<>();

        metody.add("sin");
        metody.add("cos");
        metody.add("log");
        metody.add("log10");
        metody.add("sqrt");
        metody.add("ceil");
        metody.add("floor");
        double x;
        Pattern pattern = Pattern.compile("x=\\d+");
        Pattern pattern2 = Pattern.compile("^]");

        while ((inputLine = in.readLine()) != null) {
            Matcher matcher = pattern.matcher(inputLine);
            if(metody.contains(inputLine)) {
                lista.add(inputLine);
                System.out.println("Dodano: " + inputLine);
            }

            else if(matcher.matches()){
                String[] splitInt = inputLine.split("=");
                x = Double.parseDouble(splitInt[1]);
                wyniki = sort(oblicz(x, lista));
                for(String variableName : wyniki.keySet()){
                    String variableKey = variableName;
                    Double variableValue = wyniki.get(variableName);

                    out.println(variableKey + " " + variableValue);
                }
            }

            else if(inputLine.equals("^]")) {
                serverSocket.close();
            }

            else  {
                out.println("Niepoprawna nazwa metody: " + inputLine);
            }
        }

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();

    }

    static Map<String, Double> oblicz(double x, List<String> lista){
        Map<String, Double> wyniki = new HashMap<>();

        if(lista.contains("sin")){
            wyniki.put("sin", Math.sin(x));
        }

        if(lista.contains("cos")){
            wyniki.put("cos", Math.cos(x));
        }

        if(lista.contains("log")){
            wyniki.put("log", Math.log(x));
        }

        if(lista.contains("log10")){
            wyniki.put("log10", Math.log10(x));
        }

        if(lista.contains("sqrt")){
            wyniki.put("sqrt", Math.sqrt(x));
        }

        if(lista.contains("ceil")){
            wyniki.put("ceil", Math.ceil(x));
        }

        if(lista.contains("floor")){
            wyniki.put("floor", Math.floor(x));
        }

        return wyniki;
    }

    static Map<String, Double> sort(Map<String, Double> map){
        Map<String, Double> sortedWyniki = new LinkedHashMap<>();
        List<Double> lista = new ArrayList<>();

        for(Map.Entry<String, Double> entry: map.entrySet()){
            lista.add(entry.getValue());
        }

        Collections.sort(lista, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return (o1).compareTo(o2);
            }
        });

        for(Double number : lista){
            for(Map.Entry<String, Double> entry : map.entrySet()){
                if(entry.getValue().equals(number)){
                    sortedWyniki.put(entry.getKey(), number);
                }
            }
        }

        return sortedWyniki;
    }
}