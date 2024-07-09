package facilities.buildings;

import facilities.Facility;
import java.io.Serializable;

/**
 * A lab is a type of facility, which also implements the building interface.
 */
public class Lab extends Facility implements Building, Serializable {
  private int
      level; // instance variables, all Labs have a level, a base cost a base capacity and a maximum
  // level
  private int baseCost = 300;
  private int baseCapacity = 5;
  private int maxLevel = 5;

  public Lab(String name) { // constructor, name passed as parameter, level always initialized to 1
    super(name);
    this.level = 1;
  }

  public int getLevel() { // returns level of Lab
    return level;
  }

  /**
   * Increments level of current instance of Lab.
   */
  public void increaseLevel() { // Increments lab's level
    this.level++;
  }

  /**
   * Calculates cost of upgrading current instance of Lab.
   *
   * @return returns calculated cost based on current level.
   */
  public int getUpgradeCost() {
    int cost; // declares a new integer
    if (this.getLevel() == maxLevel) { // checks if lab is at max level
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
   * Calculates capacity of given lab based on formula.
   *
   * @return Returns calculated capacity.
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
