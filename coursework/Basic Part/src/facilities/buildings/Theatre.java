package facilities.buildings;

import facilities.Facility;
import java.lang.Math;
/**
 * A Theatre is a type of facility, which also implements the building interface.
 */

public class Theatre extends Facility implements Building {
  private int
      level; // instance variables, all Theatres have a level, a base cost a base capacity and a
  // maximum level
  private int baseCost = 200;
  private int baseCapacity = 10;
  private int maxLevel = 6;

  public Theatre(
      String name) { // constructor, name passed as parameter, level always initialized to 1
    super(name);
    this.level = 1;
  }

  public int getLevel() { // returns level of Theatre
    return level;
  }

  public void increaseLevel() { // Increments theatre's level
    this.level++;
  }

  /**
   * Calculates costs of upgrading given Theatre.
   *
   * @return returns upgrade costs based on current level.
   */
  public int getUpgradeCost() {
    int cost; // declares a new integer
    if (this.getLevel() == maxLevel) { // checks if theatre is at max level
      // if it is, prints appropriate message
      return -1; // and returns -1
    } else {
      cost =
          baseCost
              * (this.getLevel()
                  + 1); // if it's not at max level, it uses given formula to calculate cost of
      // upgrading
    }
    return cost; // returns cost of upgrading
  }

  /**
   * Calculates capacity of given Theatre object from the formula.
   *
   * @return Returns the calculated capacity.
   */
  public int getCapacity() {
    double data =
        baseCapacity
            * Math.pow(
                2,
                this.getLevel()
                    - 1); // uses given formula to calculate capacity based on building's level
    int capacity = (int) data; // converts double back to int and stores it in capacity
    return capacity; // returns converted value
  }
}
