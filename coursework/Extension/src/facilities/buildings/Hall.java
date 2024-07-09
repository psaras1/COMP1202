package facilities.buildings;

import facilities.Facility;
import java.io.Serializable;

/**
 * A hall is a type of facility, which also implements the building interface.
 */
public class Hall extends Facility implements Building, Serializable {
  private int
      level; // instance variables, all halls have a level, a base cost a base capacity and a
  // maximum level
  private int baseCost = 100;
  private int baseCapacity = 6;
  private int maxLevel = 4;

  public Hall(String name) { // constructor, name passed as parameter, level always initialized to 1
    super(name);
    this.level = 1;
  }

  public int getLevel() { // returns level of hall
    return level;
  }

  /**
   * Increments level of hall.
   */
  public void increaseLevel() { // Increments hall's level
    this.level++;
  }

  /**
   * Calculates costs of upgrading given Hall.
   *
   * @return returns upgrade costs based on current level.
   */
  public int getUpgradeCost() {
    int cost; // declares a new integer
    if (this.getLevel() == maxLevel) { // checks if hall is at max level
      // if it is, prints appropriate message
      return -1; // and returns -1
    } else {
      cost =
          baseCost
              * (this.getLevel()
                  + 1); // if it's not at max level, it uses given formula to calculate cost of
      // upgrading
      return cost; // returns cost of upgrading
    }
  }

  /**
   * Calculates capacity of given Hall object from the formula.
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
    return capacity; // returns converted integer
  }
}
