package lab9part3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import javax.tools.Tool;

public class Quiz {
  private ArrayList<FlashCard> flashCards = new ArrayList<FlashCard>();
  private int score = 0;
  Toolbox myToolBox = new Toolbox();
  ArrayList<String> answers = new ArrayList<String>();
  ArrayList<String> questions = new ArrayList<String>();
  ArrayList<String> outcome = new ArrayList<String>();

  public Quiz(String filename) throws FileNotFoundException {
    FlashCardReader reader = new FlashCardReader(filename);
    for (FlashCard i : reader.getFlashCards()) {
      flashCards.add(i);
    }
    play();
  }

  public void play() {
    System.out.println("Would you like to save your results? (Y/N)");
    String toSave = myToolBox.readStringFromCmd();

    for (FlashCard i : flashCards) {
      System.out.println(i.getQuestion());
      questions.add(i.getQuestion());
      String answer = myToolBox.readStringFromCmd();
      answers.add(answer);
      if (answer.equals(i.getAnswer())) {
        System.out.println("right");
        outcome.add("right");
        System.out.println();
        score++;
      } else {
        System.out.println("wrong");
        outcome.add("wrong");
        System.out.println(i.getAnswer());
        System.out.println();
      }
    }
    if (toSave.equals("Y")) {
      save();
    }
  }

  public void save() {
    try {
      PrintStream save = new PrintStream("save.txt");

      for (int i = 0; i < questions.size(); i++) {
        save.println(questions.get(i) + ", " + answers.get(i) + ", " + outcome.get(i));
      }

      float percentage = score * 100 / questions.size();
      save.println(score + ", " + questions.size() + ", " + percentage);
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    Quiz newQuiz = new Quiz("Questions.txt");
  }
}
