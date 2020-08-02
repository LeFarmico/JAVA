import java.util.Scanner;
import java.util.Arrays;

public class PhoneBook {

    public static void main(String[] args) {
        String[][] book = new String[100][2];
        for (int i = 0; i < book.length; i++) {
            for (int j = 0; j < book[i].length; j++) {
                book[i][j] = " ";
            }
        }
        String name = "";
        String number = "";
        Scanner scanner = new Scanner(System.in);
        boolean isCorrectName = false;
        System.out.print("Введиде ФИО: ");
        while (!isCorrectName) {
            String nameCheck = scanner.nextLine(); //Считывает строку из System.in
            isCorrectName = checkName(nameCheck);
            if (!isCorrectName) System.out.println("Введите корректное имя!");
            else name = formatName(nameCheck);
        }

        boolean isCorrectNumber = false;
        System.out.print("Введите номер: ");
        while (!isCorrectNumber) {
            String phoneNumber = scanner.nextLine(); //Считывает строку из System.in
            isCorrectNumber = checkPhoneNumber(phoneNumber);
            if (!isCorrectNumber) System.out.println("Введите корректный номер!");
            else number = formatPhoneNumber(phoneNumber);
        }

        add(book, name, number);
        list(book);
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        String number = phoneNumber.replaceAll("[^0-9]", "");
        return number.length() == 11;
    }

    public static boolean checkName(String fullName) {
        String[] name = fullName.trim().split(" ");
        if (name.length != 3)
            return false;
        else return true;
    }

    public static String formatName(String fullName) {
        String[] name = fullName.trim().split(" ");
        String result = "";
        for (int i = 0; i < name.length; i++){
            char firstLetter = name[i].charAt(0);
            if(!Character.isUpperCase(firstLetter)){
                result += Character.toUpperCase(firstLetter) + name[i].substring(1) + " ";
            }
            else{
                result += firstLetter + name[i].substring(1) + " ";
            }
        }
        return result;
    }

    public static String formatPhoneNumber(String phoneNumber) {
        String cleanNumber = phoneNumber.replaceAll("[^0-9]", "");
        String result = "+7 " + cleanNumber.substring(1,4) + " " +
                cleanNumber.substring(4,7) + " " +
                cleanNumber.substring(7,9) + " " +
                cleanNumber.substring(9);
        return result;
    }

    public static void add(String[][] book, String name, String number) {
        for (int i = 0; i < book.length; i++){
            if (book[i][0].equals(" ")){
                book[i][0] = name;
                book[i][1] = number;
                break;
            }
            else {
                String[][] newBook = new String[book.length+100][2];
                for (int j = 0; j < book.length; j++){
                    newBook[j][0] = book[j][0];
                    newBook[j][1] = book[j][1];
                }
                newBook[book.length][0] = name;
                newBook[book.length][1] = number;
                book = newBook;
            }
        }
    }

    public static void list(String[][] book) {
        for (int i = 0; i < book.length; i++) {
            for (int j = 0; j < book[i].length; j++) {
                System.out.print(book[i][j]);
                System.out.println();
            }
            if (book[i][0].equals(" ")) break;
        }
    }
}
