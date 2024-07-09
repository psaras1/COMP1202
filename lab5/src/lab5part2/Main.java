package lab5part2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[]args){
        WordGroup plato  = new WordGroup("You can discover more about a person in an hour of play than in a year of conversation");
        WordGroup roosevelt = new WordGroup("When you play play hard when you work dont play at all");

        HashSet<String> testHash =roosevelt.getWordSet(plato);
        for(String x:testHash){
            System.out.println(x);
        }

        }

}
