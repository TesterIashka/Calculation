import java.util.Arrays;

public class SearchMinMaxValue {
    public static void main(String[] args) {
        int[] randomMassive = new int[20];
        int maxNegatValue = -10;
        int minPositValue = 10;
        int minMax;
        int min = 0;
        int max = 0;
        int mimin = 21;
        int maxmax = 21;

        for (int i = 0; i < randomMassive.length; i++) {
            randomMassive[i] = (int) (Math.random()*(20+1)) - 10;
        }

        for (int i = 0; i < randomMassive.length; i++){
            System.out.print(randomMassive[i] +" ");
            if (randomMassive[i] < minPositValue && randomMassive[i] >= 0)
            {
                minPositValue = randomMassive[i];
                mimin = i;
            }
            if (randomMassive[i] > maxNegatValue && randomMassive[i] < 0)
            {
                maxNegatValue = randomMassive[i];
                maxmax = i;
            }

        }

        try {
            System.out.println("\nИзмененный массив после перестановки:");
            System.out.println("Минимальное положительное число "+randomMassive[mimin] + "\n" +
                    "Максимальное отрицательное число " + randomMassive[maxmax]);
            minMax = randomMassive[mimin];
            randomMassive[mimin] = randomMassive[maxmax];
            randomMassive[maxmax] = minMax;
            for (int value : randomMassive) {
                System.out.print(value + " ");
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("В массиве не найдены либо положительные числа, либо отрицательные");
        }

    }


}