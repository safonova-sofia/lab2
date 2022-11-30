import java.util.Scanner;
import java.util.regex.*;

public class lab2 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите пароль: ");
        String text = scanner.nextLine();
        Pattern p = Pattern.compile("^(?=\\w*\\d)(?=\\w*[a-z])(?=\\w*[A-Z]).{8,}$");
        Matcher m = p.matcher(text);

        while (true) {
            if (m.matches()) {
                System.out.print("Пароль надежен");
                break;
            } else {
                System.out.print("Пароль ненадежен. Повторите ввод: ");
                text = scanner.nextLine();
                m = p.matcher(text);
            }
        }
    }
}
