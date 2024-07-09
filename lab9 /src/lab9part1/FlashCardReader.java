package lab9part1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FlashCardReader {

  BufferedReader reader;

  public FlashCardReader(String filename) {
    try {
      this.reader = new BufferedReader(new FileReader(filename));
    } catch (IOException e) {
      System.err.println(e);
    }
  }

  public String getLine() {
    try {
      return this.reader.readLine();
    } catch (IOException e) {
      System.out.println("exception");
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
}
