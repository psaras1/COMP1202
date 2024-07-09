package university;

import java.io.Serializable;
import java.util.Random;

/**
 * Staff creates objects of university staff.
 * All objects have a name, skill, years of teaching and stamina as instance variables.
 */
public class Staff extends HumanResource implements Comparable<Staff>, Serializable {
  private String name;
  private int skill; // between 0 and 100
  private int yearsOfTeaching;
  private int stamina; // between 0 and 100

  /**
   * Constructor for Staff objects.
   * Initializes years of teaching to 0 and stamina to 100
   *
   * @param name Takes a name as a parameter.
   * @param skill Takes a skill value as a parameter.
   */
  public Staff(
      String name, int skill) { // constructor, initializes yearsOf Teaching to 0 and stamina to 100
    this.name = name;
    this.skill = skill;
    this.yearsOfTeaching = 0;
    this.stamina = 100;
  }

  /**
   * Instruct allocates a number of students to be instructed.
   * Increases skill of instructor, decreases their stamina.
   * Increases the university's reputation.
   *
   * @param numberOfStudents Takes an integer as a parameter.
   * @return returns reputation gained.
   */
  public int instruct(int numberOfStudents) {
    int reputation = (100 * this.skill) / (100 + numberOfStudents); // given formula for reputation
    if (this.skill < 100) { // checks if skill of this instance of Staff is less than 100
      this.skill += 1; // it it is, increments it by 1
    }
    this.stamina =
        (int)
            (this.stamina
                - Math.ceil((double) numberOfStudents / (20 + this.skill))
                    * 20); // given formula for stamina cost
    return reputation; // returns reputation for the university
  }

  /**
   * Called to get salary of Staff object.
   *
   * @return Calculates salary of this instance of Staff, based on given formula.
   */
  public float getSalary() {
    Random ran = new Random();
    float salary = (float) (this.getSkill() * Math.random() * (0.105 - 0.0905 + 1) + 0.0905);
    // return this.getSkill()*((float) (0.095+ran.nextFloat()*(0.105-0.0955)));
    return salary;
  }

  /**
   * Adds 20 stamina to Staff object, unless their stamina is greater than 80,
   * in which case, it sets stamina to 100
   * Called at the end of each year.
   */
  public void replenishStamina() { // checks if stamina is below 80
    if (this.stamina <= 80) {
      this.stamina += 20; // If it is, adds 20 to stamina of this occurrence of Staff
    } else {
      this.stamina = 100; // If it is not, it just sets stamina to 100, since it can't be >100
    }
  }

  public void increaseYearsOfTeaching() {
    this.yearsOfTeaching += 1; // increments years of teaching of this instance of Staff by 1
  }

  public int getSkill() {
    return this.skill; // returns skill of this instance of Staff
  }

  public int getStamina() {
    return this.stamina; // returns skill of this instance of Staff
  }

  /**
   * Called to get experience of Staff object.
   *
   * @return Returns years of teaching this Staff object has.
   */
  public int getYearsOfTeaching() {
    return this.yearsOfTeaching;
  }

  /**
   * Name variable.
   *
   * @return Returns name of current Staff object.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Comparable.
   *
   * @param i the object to be compared.
   * @return Returns 0 if skills are equal,
   *     returns 1 when object parameter's skill is greater than instance,
   *     returns -1 if current instance's skill is greater than the parameter's.
   */
  public int compareTo(Staff i) {
    if (this.getSkill() == i.getSkill()) {
      return 0;
    } else if (this.getSkill() < i.getSkill()) {
      return 1;
    } else {
      return -1;
    }
  }
}
