public class SearchMinMaxValue {
    public static void main(String[] args) {
        int[] randomMassive = new int[20];
        int min = 0;
        int max = 0;
        int minMax;
        for (int i = 0; i < randomMassive.length; i++) {
            randomMassive[i] = (int) (Math.random()*(20+1)) - 10;
        }
        for (int i = 0; i < randomMassive.length; i++){
            System.out.println(randomMassive[i]);
            if (i < randomMassive.length-1){
            if (randomMassive[min] > randomMassive[i+1])
            {min = i+1;} else {
                if (randomMassive[max] < randomMassive[i + 1]) {
                    max = i + 1;
                }
            }
        }
        }
        System.out.println("--------------------------");
        minMax = randomMassive[min];
        randomMassive[min] = randomMassive[max];
        randomMassive[max] = minMax;
        for (int value : randomMassive) {
            System.out.println(value);
        }

    }


}
