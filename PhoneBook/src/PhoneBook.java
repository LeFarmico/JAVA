import java.util.Scanner;
import java.util.Arrays;

public class PhoneBook {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean isCorrectName = false;
        System.out.print("Введиде ФИО: ");
        while (!isCorrectName) {
            String name = scanner.nextLine(); //Считывает строку из System.in
            isCorrectName = checkName(name);
            if (!isCorrectName) {
                System.out.println("Введите корректное имя!");
            } else {
                System.out.println(formatName(name));
            }
        }
        boolean isCorrectNumber = false;
        System.out.println("Введите номер: ");
        while (!isCorrectNumber) {
            String phoneNumber = scanner.nextLine(); //Считывает строку из System.in
            isCorrectNumber = checkPhoneNumber(phoneNumber);
            if (!isCorrectNumber) {
                System.out.println("Введите корректный номер!");
            } else {
                System.out.println(formatPhoneNumber(phoneNumber));
            }
        }
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
                result += name[i].substring(1) + " ";
            }
        }
        return result;
    }

    public static String formatPhoneNumber(String phoneNumber) {
        String cleanNumber = phoneNumber.replaceAll("[^0-9]", "");
        String result = cleanNumber.substring(1,4) + " " +
                cleanNumber.substring(4,7) + " " +
                cleanNumber.substring(7,9) + " " +
                cleanNumber.substring(9);
        return result;
    }

    public static void add(String[][] book, String name, String number) {
        //add logic
    }

    public static void list(String[][] book) {
        //print phone book
    }
}
