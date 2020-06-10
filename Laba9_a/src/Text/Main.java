package Text;

import java.io.*;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        FileWriter fw =null;
        File file = new File("Kabo1.txt");
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader("Kabo.txt"));
            fw = new FileWriter(file);
            String tmp = "";
            while ((tmp = br.readLine())!=null){
                int k = counter.counterInt(tmp);
                fw.write("В данной строке наибольшее количество идущих подряд цифр  = "+ k +"\n");
                String s[] = tmp.split("\\s");
                for(String res : s){
                    fw.write(res + " ");
                }
                fw.write("\n");

            }
            System.out.println("Программа выполнена успешно. Результат в файле Kabo1.txt");

        }catch (IOException e){
            e.printStackTrace();
        } finally {
            if (br!=null){
                try {
                    br.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(fw!=null){
                try{
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
