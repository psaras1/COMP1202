package lab5part3;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[]args){
        WordGroup plato  = new WordGroup("You can discover more about a person in an hour of play than in a year of conversation");
        WordGroup roosevelt = new WordGroup("When you play play hard when you work dont play at all");


        Set<String> values = roosevelt.getWordCounts().keySet();
        for (String key:values){
            int count = roosevelt.getWordCounts().get(key);
            System.out.println(key+": "+count);
        }
        System.out.println();
        Set<String> values1 = plato.getWordCounts().keySet();
        for (String key1:values1){
            int count1 = plato.getWordCounts().get(key1);
            System.out.println(key1+": "+count1);
        }

        System.out.println();

        HashSet<String> first = roosevelt.getWordSet(plato);
        for(String z:first){
            int times;
            if(values1.contains(z)){
                times = plato.getWordCounts().get(z);
                if(values.contains(z)){
                    times += roosevelt.getWordCounts().get(z);
                }
                System.out.println(z+":"+times);
            }


        }







    }
}
