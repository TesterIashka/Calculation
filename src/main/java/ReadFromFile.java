import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ReadFromFile {

    public static void main(String[] args) {

        String fileName = "D:\\theText.txt";
        List<String> collectWords = getCollectionWords(fileName);
        if (collectWords!= null && collectWords.size() > 0) {
            List<String> sortedCollection = getSortCollection(collectWords);
            findMaxRepeat(sortedCollection);
        }
        else {System.out.println("Ошибка, файл не найден или в файле нет слов");}

    }

    public static List<String> getCollectionWords(String pathFile) {
        List<String> collectWords = new ArrayList<>();
        File stringFile = new File(pathFile);
        try (Scanner readLine = new Scanner(stringFile)) {
            String line;
            while (readLine.hasNextLine()) {
                try {
                    line = readLine.next();
                    collectWords.add(line);
                } catch (NoSuchElementException e) {
                }
            }
            return collectWords;
        } catch (IOException e) {
            return null;
        }

    }

    public static List<String> getSortCollection(List<String> notSortCollection) {
        System.out.println("\nВывод всех слов: ");
        notSortCollection.forEach(elem -> System.out.print(elem + " "));
        notSortCollection.sort(String::compareToIgnoreCase);
        System.out.println("\nСортировка по алфавиту: ");
        notSortCollection.forEach(System.out::println);
        return notSortCollection;
    }

    public static List<Map.Entry<String, Integer>> findMaxRepeat(List<String> sortCollection) {
        Map<String, Integer> repeatWords = new HashMap<>();
        for (String i : sortCollection) {
            repeatWords.put(i, repeatWords.getOrDefault(i, 0) + 1);
        }
        System.out.println("\nВывод слов по количеству повторений: ");

        List<Map.Entry<String, Integer>> keysFromMap = repeatWords.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());
        keysFromMap.forEach(System.out::println); //Вывод отсортированной коллекции по количеству повторений

        int maxCount = (Collections.max(repeatWords.values())); //Получение максимального количества повторений

        System.out.println("Самые повторяющиеся слова: ");
        //Вывод всех слов, количество повторений которых равно максимальному количеству повторений
        for (Map.Entry<String, Integer> entry : repeatWords.entrySet()) {
            if (entry.getValue() == maxCount) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
        return keysFromMap;
    }
}
