package Mobile;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Model mobile = new Model();
        boolean k = true;
        while (true) {
            System.out.println(
                    "1) Enter Siemens community"
                            + "\n2) Make a call" +
                            "\n3) End call\n"
            );
            Scanner scanner = new Scanner(System.in);
            int key = scanner.nextInt();
            switch (key) {
                case 1:
                    mobile.connectToSiemensOnline();
                    break;
                case 2:
                    System.out.println("Enter the number you want to call: ");
                    scanner.hasNext();
                    String number = scanner.next();
                    mobile.startCall(number);
                    break;
                case 3:
                    mobile.breakCall();
                    break;
            }
            System.out.println("Do you want to continue? "
                    + "\nTrue" + "\nFalse");
            if (scanner.hasNext()) {
                k = scanner.nextBoolean();
            }
        }

    }
}

