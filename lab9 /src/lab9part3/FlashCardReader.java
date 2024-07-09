package lab9part3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FlashCardReader {

  private BufferedReader reader;

  public FlashCardReader(String filename) {
    try {
      FileReader fr = new FileReader(filename);
      this.reader = new BufferedReader(fr);
    } catch (FileNotFoundException e) {
      System.err.println(e);
    }
  }

  public String getLine() {
    try {
      return this.reader.readLine();
    } catch (IOException exception) {
      System.err.println("Exception");
    }
    return null;
  }

  public boolean fileIsReady() {
    try {
      return reader != null && this.reader.ready();
    } catch (IOException e) {
      System.out.println("exception");
    }
    return false;
  }

  public ArrayList<FlashCard> getFlashCards() {
    try {
      String newLine;
      ArrayList<FlashCard> flashCards = new ArrayList<>();
      while (this.fileIsReady()) {
        newLine = this.reader.readLine();
        String[] newLineArray = newLine.split(":");
        flashCards.add(new FlashCard(newLineArray[0], newLineArray[1]));
      }
      return flashCards;
    } catch (IOException e) {
      System.out.println("Exception");
    }
    return null;
  }
}
