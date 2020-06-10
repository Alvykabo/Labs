package Text;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static java.lang.Character.isLetter;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Input text: ");
        String text = in.nextLine();

        //разделяю на фрагменты
        LinkedList<StringBuilder> ll = new LinkedList<StringBuilder>();
        for(int fIndex = 0, sIndex;;){
            sIndex = text.indexOf(" ", fIndex);
            if (sIndex==-1) {
                ll.add(new StringBuilder(text.substring(fIndex, text.length())));
                break;
            }
            ll.add(new StringBuilder(text.substring(fIndex, sIndex)));
            fIndex = sIndex+1;
        }

        //отделяю знаки припинания
        for(int i = 0;i<ll.size();i++){
            StringBuilder t = ll.get(i);

            if (t.toString().equals(" ")) continue;

            //отделяю начало
            StringBuilder fCh = new StringBuilder(1);
            while(true){
                char ch = t.charAt(0);
                if (isLetter(ch)) break;
                fCh.append(ch);
                t.deleteCharAt(0);
            }

            //отделяю конец
            StringBuilder lCh = new StringBuilder(1);
            while(true){
                char ch = t.charAt(t.length()-1);
                if (isLetter(ch)) break;
                lCh.append(ch);
                t.deleteCharAt(t.length()-1);
            }

            //добавляю начало в структуру
            if (fCh.length()>0){
                ll.add(i, fCh);
                i++;
            }

            //само задание
            t.insert(t.length(), t.charAt(0));
            //изменяю строку в структуре
            ll.set(i, t);

            //добавляю конец в структуру
            if (lCh.length()>0){
                ll.add(i+1, lCh);
                i++;
            }
        }

        //собираю строку
        StringBuilder sol = new StringBuilder(text.length());
        while(true){
            try{
                sol.append(ll.removeFirst());
                sol.append(' ');
            }
            catch(NoSuchElementException e){
                sol.deleteCharAt(sol.length()-1);
                break;
            }

        }
        System.out.println(sol.toString());      }
}
