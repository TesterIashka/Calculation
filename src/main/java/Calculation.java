import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Double.NaN;


/**
 * Класс вызывающий работу калькулятора
 */
public class Calculation {

    public static void main(String[] args) {
        getCalculations();
    }

    /** Приравниваем к null переменные для того, чтобы значение, полученное в try использовалось снаружи
     * в try обрабатываем исключение, которое может возникнуть
     * цикл while используется для выбора операций и выхода из программы
     * */
    public static void getCalculations(){
        final Scanner getNumber = new Scanner(System.in);
        getTwoDouble getOneObject = null;
        byte exit = 0;

        try {
            getOneObject = objectOfDouble(getNumber);
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели не число! Или ввели дробное число через точку, " +
                    "пожалуйста, введите через запятую.");
            exit = 1;
        }

        while (exit == 0) {
            System.out.println("\nВведите номер операции:" + "\n1 - это сложение" + "\n2 - это вычитание" + "\n3 - это умножение" +
                    "\n4 - это деление" + "\nДля выхода из программы введите - любой другой символ");
            byte selectOperation;
            try {
                selectOperation = getNumber.nextByte();
            }
            catch (InputMismatchException e) {
                selectOperation = 5;
            }

            if (selectOperation > 0 && selectOperation < 5) {
                choiceOperation(selectOperation, getOneObject.getFirst(), getOneObject.getSecond());
                exit = nextStep(getNumber);
            }
            else
            {
                break;
            }


        }
        getNumber.close();
    }

    /**
     * метод, который считывает два значения типа double и возвращает объект.
     * @param number
     * @return getTwoDouble
     */
    public static getTwoDouble objectOfDouble(Scanner number) {
        System.out.println("Введите первое число");
        double numOne = number.nextDouble();
        System.out.println("Введите второе число");
        double numTwo = number.nextDouble();
        number.nextLine();
        return new getTwoDouble(numOne, numTwo);
    }

    /**
     * метод, который складывает два числа
     * @param a
     * @param b
     */

    public static double Sum(double a, double b) {
        double LinkSum = a + b;
        System.out.printf(a + " + " + b + " = %.4f\n", LinkSum);
        return LinkSum;
    }

    public static double Minus(double a, double b) {
        double LinkMinus = a - b;
        System.out.printf(a + " - " + b + " = %.4f\n",LinkMinus);
        return LinkMinus;
    }

    public static double Umno(double a, double b) {
        double LinkUmno = a * b;
        System.out.printf(a + " * " + b + " = %.4f\n", LinkUmno);
        return LinkUmno;
    }

    public static double Delen(double a, double b) {
        double LinkDelen = 0;
        try {
            LinkDelen = a / b;
            System.out.printf(a + " / " + b + " = %.4f\n", LinkDelen);
        } catch (ArithmeticException e) {
            System.out.println("На ноль делить нельзя!");
        }
        if (Double.isNaN(LinkDelen)) {
            System.out.println("На ноль делить нельзя!");
        }
        return LinkDelen;
    }

    /**
     * метод, позволяющий продолжить выбор операции или завершить программу
     * @param number
     */

    public static byte nextStep(Scanner number) {
        System.out.println("Для вызова меню с операциями введите 0"+"\nДля выхода из программы введите любое значение, отличное от 0");
        String one_exit = number.next();
        if (one_exit.equals("0")) {
            return 0;
        }
        else {
            return 1;
        }

    }

    public static double choiceOperation(byte selectOperation, double a, double b)
    {
        double result = 0;
        switch (selectOperation) {
            case (1):
                result = Sum(a, b);
                break;
            case (2):
                result = Minus(a, b);
                break;
            case (3):
                result = Umno(a, b);
                break;
            case (4):
                result = Delen(a, b);
                break;
        }
        return result;
    }

}