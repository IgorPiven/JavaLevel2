package Level2_L3;

import java.util.*;

public class WordList {

    public static void main(String[] args) {

        String[] words = {"Apple", "Banana", "Orange", "Apple", "Cucumber", "Watermelon", "Melon", "Banana",
                "Garlic", "Watermelon", "Apple"};

        List<String> wordsList = new ArrayList<>(Arrays.asList(words));

        System.out.println("Список слов в массиве: " + wordsList);

        List uniqueList = new ArrayList();
        Map mapList = new HashMap();

        for (int i = 0; i < words.length; i++) {

            int freq = Collections.frequency(wordsList, wordsList.get(i));

            if (freq == 1) uniqueList.add(wordsList.get(i));

            mapList.put(wordsList.get(i), freq + " раз");

        }

        System.out.println("Список уникальных слов: " + uniqueList);

        System.out.println("Сколько раз встречается каждое слово: " + mapList);


    }

}

