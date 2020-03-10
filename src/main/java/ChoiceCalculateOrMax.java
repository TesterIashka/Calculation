import java.util.*;
import java.util.stream.Collectors;

public class ChoiceCalculateOrMax {
    public static void main(String[] args) {
        byte selectCalculateMax;
        Scanner inputChoiceConsole = new Scanner(System.in);
        System.out.println(" Для переключения в режим калькулятора введите 1\n Для поиска максимальной " +
                "по длине строки введите 2");

        try {
            selectCalculateMax = inputChoiceConsole.nextByte();
        } catch (InputMismatchException | NullPointerException e) {
            System.out.println("Вы ввели не 1 или 2");
            selectCalculateMax = 0;
        }

        if (selectCalculateMax > 0 && selectCalculateMax < 3) {
            switch (selectCalculateMax) {
                case (1):
                    Calculation.getCalculations();
                    break;
                case (2):
                    getMaxLengthWord(inputChoiceConsole);
                    inputChoiceConsole.close();
                    break;
            }
        }
    }

    public static List<String> getMaxLengthWord(Scanner inputChoiceConsole){
        System.out.println("Введите размерность массива");
        List<String> listWords = new ArrayList<>();
        List<String> listMaxWords = new ArrayList<>();
        try {
            int sizeMassive = inputChoiceConsole.nextInt();
            int i;
            if (sizeMassive > 0) {
                for (i = 1; i < sizeMassive + 1; i++) {
                    System.out.println("Введите " + i + " элемент массива");
                    listWords.add(inputChoiceConsole.next());
                }
                listWords.sort((s1, s2) -> s2.length() - s1.length());
                listMaxWords = listWords.stream().filter(currentElement -> (currentElement.length() ==
                        listWords.get(0).length()))
                        .collect(Collectors.toList());

                if (listMaxWords.size() > 1 )
                {
                    System.out.println("В массиве несколько максимальных по длине строк: ");
                    listMaxWords.forEach(System.out::println);
                } else
                {
                    System.out.println("Самое длинное слово - "+ listMaxWords.get(0));}
            }
            else {System.out.println("Размерность массива должна быть больше 0!");}
        }
        catch (InputMismatchException e) {
            System.out.println("Вы ввели не число!");}

        return listMaxWords;
    }

}
