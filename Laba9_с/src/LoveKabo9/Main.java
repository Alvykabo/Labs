package LoveKabo9;

import java.io.*;

public class Main {

        public static void main(String[] args) {
            FileWriter fw =null;
            File file = new File("KaboC1");
            BufferedReader br = null;
            try{
                br = new BufferedReader(new FileReader("KaboC"));
                fw = new FileWriter(file);
                String tmp = "";
                while ((tmp = br.readLine())!=null){
                    String s[] = tmp.split("\\s+");
                    double sum = 0;
                    for (int i = 1; i < s.length; i ++) {
                        sum += Integer.parseInt(s[i]);
                    }
                    if (sum / (s.length - 1) > 7) {
                        fw.write(s[0].toUpperCase() + "\n");
                    }

                }
                System.out.println("Программа выполнена успешно. Результат в файле KaboC1");

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
