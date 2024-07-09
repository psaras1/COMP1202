package lab5part2;

import java.util.HashMap;
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

    public HashSet<String> getWordSet(WordGroup newWords){
        HashSet<String> newHash = new HashSet<String>();
        String[] toUse = newWords.getWordArray();
        String[] toUse2 = this.getWordArray();
        for(String x : toUse){
            newHash.add(x);
        }
        for(String y: toUse2){
            newHash.add(y);
        }
        return newHash;
    }

    public HashMap<String,Integer> getWordCounts(){
        HashMap<String,Integer> hashM = new HashMap<>();
        String [] wArray = this.getWordArray();
        for(String x:wArray){
            String searching = x;
            int count = 0;
            for(String y:wArray){
                if(searching.equals(y)){
                    count++;
                }
            }
            hashM.put(searching,count);
        }

        return hashM;
    }


}
