package Moderate;

import java.util.HashMap;

public class WordFrequency {

    public static void main(String[] args) {
        System.out.println(countOccurrencies("hello this is Sakina hello Hey bye ", "a"));
    }

    public static int countOccurrencies(String passage, String word){
        String[] wordsArray = new String[passage.length()];
        wordsArray = passage.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        int count=0;

        for(String s : wordsArray){
            if(map.containsKey(s)){
                count = map.get(s) + 1;
                map.put(s,count);

            }
            else {

                map.put(s,1);
            }
        }
        if(map.get(word) == null ){
            return 0;
        }

        return map.get(word);


    }
}
