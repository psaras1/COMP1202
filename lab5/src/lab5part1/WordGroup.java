package lab5part1;

import java.util.HashSet;

public class WordGroup {
    private String words;

    public WordGroup(String words){
        this.words=words.toLowerCase();
    }
    public String[] getWordArray(){
        String[] splitWord = words.split(" ");
        return splitWord;
    }





}
