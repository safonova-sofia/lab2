import java.util.Scanner;
import java.util.regex.*;

public class lab1 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дату в формате dd/mm/yyyy: ");
        String text = scanner.nextLine();
        Pattern p = Pattern.compile("(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/](199\\d|([2-9]\\d\\d\\d))");
        Matcher m = p.matcher(text);


        if (m.find()) {
            if ((daysInMonth(Integer.valueOf(text.substring(3, 5)), Integer.valueOf(text.substring(6, 10)))) >= Integer.valueOf(text.substring(0, 2))) {
                System.out.print("Введенное выражение является датой");
            } else {
                System.out.print("Введенное выражение не является датой");
            }
        } else if ((text.length() > 5) && ((!(text.substring(2, 3).equals("/"))) || (!(text.substring(5, 6).equals("/"))))) {
            System.out.print("Введенное выражение не соответствует заданному формату даты dd/mm/yyyy");
        } else {
            System.out.print("Введенное выражение не является датой");
        }
    }

    public static int daysInMonth(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return (31);
            case 4:
            case 6:
            case 9:
            case 11:
                return (30);
            case 2:
                if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)) {
                    return (29);
                } else {
                    return (28);
                }
        }
        return 0;
    }
}
