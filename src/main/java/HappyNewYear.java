import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;


public class HappyNewYear {
    public static void main(String[] args)
    {
        Scanner inputCandies = new Scanner(System.in);
        List<Candy> candies = addCandies(inputCandies);
        List<Cookies> coolCookies = addCookies(inputCandies);

        candies.forEach(System.out::println); // список конфет
        List<Gift> boxGift = new ArrayList<>();
        String boxExit = "y";
        while (boxExit.equals("y")) {
            try {
                System.out.println("Введите id конфеты, которую хотите добавить в подарок");
                boxGift.add(candies.get(inputCandies.nextInt()));
                System.out.println("Добавить ещё конфету? ('y' - да, остальные значения - нет)");
                inputCandies.nextLine();
                boxExit = inputCandies.nextLine();
            }
            catch (IndexOutOfBoundsException | InputMismatchException e)
            {}
        }

        coolCookies.forEach(System.out::println); //список печеньев


        boxExit = "y";
        while (boxExit.equals("y")) {
            try {

                System.out.println("Введите id печенья, которое хотите добавить в подарок");
                boxGift.add(coolCookies.get(inputCandies.nextInt()));
                System.out.println("Добавить ещё печенье? ('y' - да, остальные значения - нет)");
                inputCandies.nextLine();
                boxExit = inputCandies.nextLine();
            }
            catch (IndexOutOfBoundsException | InputMismatchException e)
            {}
        }

        double sumGift;
        double sumWeiGift;
        System.out.println("Список всех сладостей в новогоднем подарке:");
        boxGift.forEach(System.out::println);
        sumGift = boxGift.stream().map(Gift::getPrice).reduce((double) 0, Double::sum);
        System.out.println("Суммарная цена за все сладости равна: "+sumGift);
        sumWeiGift = boxGift.stream().map(Gift::getWeight).reduce((double) 0, Double::sum);
        System.out.println("Суммарная цена за все сладости равна: "+sumWeiGift);






    }

    public static List<Candy> addCandies(Scanner inputCandies)
    {
        List<Candy> candies = new ArrayList<>();
        String exit = "y";
        int i = 0;
        while (exit.equals("y"))
        {

            try {
                System.out.println("Введите наименование конфеты, \nвес, \nкаллории, \nсрок годности в днях");
                candies.add(new Candy(i++,
                        inputCandies.nextLine(),
                        inputCandies.nextDouble(),
                        inputCandies.nextDouble(),
                        inputCandies.nextInt()));
                System.out.println("Добавить ещё конфету? ('y' - да, остальные значения - нет)");
                inputCandies.nextLine();
                exit = inputCandies.nextLine();
            }
            catch (InputMismatchException | NullPointerException e)
            {
                System.out.println("Вы ввели одно из значений " +
                        "неправильно.\n " +
                        "Добавить заного конфету? ('y' - да, остальные значения - нет)");
                inputCandies.nextLine();
                exit = inputCandies.nextLine();
            }

        }
        return candies;

    }

    public static List<Cookies> addCookies(Scanner inputCandies)
    {
        List<Cookies> niceCookies = new ArrayList<>();
        String exit = "y";
        int i = 0;
        while (exit.equals("y"))
        {
            try {
                System.out.println("Введите наименование печенья, \nвес, " +
                        "\nкаллории, \nстрану производства печенья");
                niceCookies.add(new Cookies(
                        i++,
                        inputCandies.nextLine(),
                        inputCandies.nextDouble(),
                        inputCandies.nextDouble(),
                        inputCandies.next()));
                System.out.println("Добавить ещё печенье? ('y' - да, остальные значения - нет)");
                inputCandies.nextLine();
                exit = inputCandies.nextLine();
            }
            catch (InputMismatchException | NullPointerException e)
            {
                System.out.println("Вы ввели одно из значений " +
                        "неправильно.\n " +
                        "Добавить заного печенье? ('y' - да, остальные значения - нет)");
                inputCandies.nextLine();
                exit = inputCandies.nextLine();
            }

        }
        return niceCookies;

    }


}
