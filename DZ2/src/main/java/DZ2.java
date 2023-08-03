import java.util.Scanner;

public class DZ2 {
    public static void main(String[] args) {
        //task1();
        task4();
    }

    public static void task1(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите дробное число типа float:");
        while (!sc.hasNextFloat()){
            System.out.println("Некорректный ввод, попробуйте еще раз:");
            sc.next();
        }
        float inputNumber = sc.nextFloat();
        System.out.println("Введенное число: "+inputNumber);
    }
    public static void task4(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку:");
        String inputStr = sc.nextLine();
        if (inputStr.isEmpty()){
            throw new NullPointerException("Пустые строки вводить нельзя!");
        }
    }
}
