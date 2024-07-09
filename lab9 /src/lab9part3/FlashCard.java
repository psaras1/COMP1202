package lab9part3;

public class FlashCard {
  private String answer;
  private String question;

  public FlashCard(String question, String answer) {
    this.question = question;
    this.answer = answer;
  }

  public String getAnswer() {
    return this.answer;
  }

  public String getQuestion() {
    return this.question;
  }
}
