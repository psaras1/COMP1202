package lab5part1;

import java.util.HashSet;

public class Main {
    public static void main(String[]args){
        WordGroup plato  = new WordGroup("You can discover more about a person in an hour of play than in a year of conversation");
        WordGroup roosevelt = new WordGroup("When you play play hard when you work dont play at all");
        String[] platoArray = plato.getWordArray();
        String[] rooseveltArray = roosevelt.getWordArray();
        for(String x:platoArray){
            System.out.println(x);
        }
        System.out.println();
        for(String y:rooseveltArray){
            System.out.println(y);
        }


    }
}
