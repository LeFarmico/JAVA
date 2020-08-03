import java.util.Scanner;


public class PhoneBook {

    public static void main(String[] args) {
        String name = "";
        String number = "";
        String[][] book = new String[100][2];

        for (int i = 0; i < book.length; i++) {
            for (int j = 0; j < book[i].length; j++) book[i][j] = " ";
        } //Заполняет масивы пробелами

        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Введиде ФИО либо номер: ");
            String inputLine = scanner.nextLine();

            if (checkNameFormat(inputLine)) {
                name = formatName(inputLine);
                boolean isCorrectNumber = false;
                System.out.println("Создание нового контакта!");
                System.out.print("Введите номер: ");
                while (!isCorrectNumber) {
                    String phoneNumber = scanner.nextLine(); //Считывает строку из System.in
                    isCorrectNumber = checkPhoneNumber(phoneNumber);
                    if (!isCorrectNumber) System.out.println("Введите корректный номер!");
                    else number = formatPhoneNumber(phoneNumber);
                }
                add(book, name, number);
            }
            else if (checkNumberFormat(inputLine)) {
                findInBook(book, formatPhoneNumber(inputLine));
            }
            else if (inputLine.equals("list")){
                list(book);
            }
            else if (inputLine.equals("stop")){
                break;
            }
            else System.out.println("Введите коректные данные");

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
            if(!book[book.length-1][0].equals(" ")) {
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
            if (book[i][0].equals(" ")) break;
            System.out.print(book[i][0] + ": " + book[i][1]);
            System.out.println();
        }
    }

    public static boolean checkNameFormat(String inputString) {
        if (checkName(formatName(inputString))) return true;
        else return false;
    }

    public static boolean checkNumberFormat(String inputString) {
        if (checkPhoneNumber(inputString)) return true;
        else return false;
    }

    public  static void findInBook(String[][] book, String number){
        for (int i = 0; i < book.length; i++) {
            if(book[i][1].equals(number)){
                System.out.println(book[i][0] + ": " + book[i][1]);
                break;
            }
            else {
                System.out.println("Данный номер не найден!");
                break;
            }
        }
    }
}
