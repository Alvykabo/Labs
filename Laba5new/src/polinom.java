
import java.util.*;

public class polinom
{
    private int[] coeff;
    private int deg;
    public polinom(int n)
    {
        deg = n;
        coeff = new int[deg+1];
        for(int i = 0; i < deg+1; i++)
            coeff[i] = 0;
    }
    //Нулевой коэффициент - свободный член
    public void inputCoeff()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите коэффициенты: ");
        for(int i = 0; i < deg+1; i++)
        {
            System.out.print("coeff[" + i + "] = ");
            coeff[i] = in.nextInt();
            System.out.println();
        }
    }
    public void setCoeff(int index, int x)
    {
        coeff[index] = x;
    }
    public int getCoeff(int index)
    {
        return coeff[index];
    }
    public int getDeg()
    {
        return deg;
    }
    //Возвращает полином с суммой соотвутствующих коэффициентов
    public static polinom summ(polinom p1, polinom p2)
    {
        int tempDeg;
        if(p1.getDeg() < p2.getDeg())
            tempDeg = p1.getDeg();
        else
            tempDeg = p2.getDeg();
        polinom tempP = new polinom(tempDeg);
        for(int i = 0; i < tempDeg+1; i++)
            tempP.setCoeff(i, p1.getCoeff(i) + p2.getCoeff(i));
        tempP.output();
        return tempP;
    }
    //Возвращает полином с разностью соотвутствующих коэффициентов
    public static polinom difference(polinom p1, polinom p2)
    {
        int tempDeg;
        if(p1.getDeg() > p2.getDeg())
            tempDeg = p1.getDeg();
        else
            tempDeg = p2.getDeg();
        polinom tempP = new polinom(tempDeg);
        for(int i = 0; i < tempDeg+1; i++)
            tempP.setCoeff(i, p1.getCoeff(i) - p2.getCoeff(i));
        tempP.output();
        return tempP;
    }

    //Возвращает полином, полученный при произведении
    public static polinom multiply(polinom p1, polinom p2)
    {
        int tempDeg = p1.getDeg()+p2.getDeg();
        polinom tempP = new polinom(tempDeg);
        for(int i = 0; i < p1.getDeg()+1; i++)
            for (int j = 0; j < p2.getDeg()+1; j++)
                tempP.setCoeff(i + j, tempP.getCoeff(i + j) + p1.getCoeff(i) * p2.getCoeff(j));
        tempP.output();
        return tempP;//clone
    }
    //Метод для инициализации полиномов
    public static polinom inputPolynom()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите степень полинома: ");
        int degP = in.nextInt();
        polinom p = new polinom(degP);
        p.inputCoeff();
        p.output();
        return p;
    }
    //Вывод полинома на экран
    public void output()
    {
        for(int i = 0; i < deg+1; i++)
        {
            System.out.printf("%d*X(%d)", coeff[i], i);
            if(i < deg)
                System.out.print("+");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        int choose = 0;
        polinom p1 = null, p2 = null, pResult = null;
        Scanner in = new Scanner(System.in);
        do{
            System.out.println("1. Ввод");
            System.out.println("2. Получить сумму");
            System.out.println("3. Получить разность ");
            System.out.println("4. Получить произведение");
            System.out.println("5. Вывести полиномы");
            System.out.println("6. Выход");
            System.out.print("Введите номер пункта: ");
            choose = in.nextInt();
            switch(choose)
            {
                case 1:
                    System.out.println("Полином p1.");
                    p1 = inputPolynom();
                    System.out.println("Полином p2.");
                    p2 = inputPolynom();
                    break;
                case 2:
                    pResult = summ(p1, p2);
                    break;
                case 3:
                    pResult = difference(p1, p2);
                    break;
                case 4:
                    pResult = multiply(p1, p2);
                    break;
                case 5:
                    System.out.println("Полином p1.");
                    p1.output();
                    System.out.println("Полином p2.");
                    p2.output();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный ввод. Попробуйте снова.");
            }
        }while(true);
    }
}