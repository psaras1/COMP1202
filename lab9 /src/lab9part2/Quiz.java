package lab9part2;

import java.io.IOException;
import java.util.ArrayList;
import javax.tools.Tool;

public class Quiz {
  ArrayList<FlashCard> flashCards = new ArrayList<FlashCard>();

  public Quiz(String filename) {

    FlashCardReader reader = new FlashCardReader(filename);
    for (FlashCard i : reader.getFlashCards()) {
      flashCards.add(i);
    }

    play();
  }

  public void play() {
    for (FlashCard i : flashCards) {
      Toolbox myToolBox = new Toolbox();
      System.out.println(i.getQuestion());
      String answer = myToolBox.readStringFromCmd();
      if (answer.equals(i.getAnswer())) {
        System.out.println("right");
        System.out.println();
      } else {
        System.out.println("wrong");
        System.out.println(i.getAnswer());
        System.out.println();
      }
    }
  }

  public static void main(String[] args) {
    Quiz newQuiz = new Quiz("Questions.txt");
  }
}
