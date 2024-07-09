package university;

import facilities.Facility;
import facilities.buildings.Building;
import facilities.buildings.Hall;
import facilities.buildings.Lab;
import facilities.buildings.Theatre;
import java.lang.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *A university object has a budget, an instance of estate,
 *reputation and an instance of HumanResource
 *as instance variables.
 */
public class University { // instance variables, all university objects should have a budget,
  // an instance of estate and a reputation
  private float budget;
  private Estate estate;
  private int reputation;
  private HumanResource humanResource;

  /**
   * Constructor for University objects sets funding to parameter,
   * initializes new estate object and new instance of human resource.
   *
   * @param funding Funding of the university is passed as a parameter.
   */
  public University(
      int funding) { // the constructor, takes funding as a parameter which represents the budget.
    this.budget = funding;
    this.estate = new Estate();
    this.humanResource = new HumanResource();
  }

  /**
   * Adds buildings to university's estate, adjusts budget and reputation accordingly.
   *
   * @param type Takes type of building as a parameter.
   * @param name Takes name of building as a parameter.
   * @return Returns newly constructed facility.
   */
  public Facility build(String type, String name) { // type and name taken as parameters
    Facility facility =
        estate.addFacility(
            type, name); // adds an instance of facility to the estate of the university
    if (facility
        instanceof
        Hall) { // depending on the type of the facility, different amounts are taken from budget
      this.budget -= 100; // 100 reputation points added regardless of the type of building
      this.reputation += 100;
    } else if (facility instanceof Lab) {
      this.budget -= 300;
      this.reputation += 100;
    } else if (facility instanceof Theatre) {
      this.budget -= 200;
      this.reputation += 100;
    } else {
      return null; // if the facility isn't an instance of hall, lab or theatre null is returned
    }
    return facility; // after adjusting the budget and reputation, newly build facility is returned
  }

  /**
   * Upgrades building within university's estate.
   *
   * @param building Takes the building to be upgraded as a parameter.
   * @throws Exception Throws an exception if the Building object is not in the university's estate.
   */
  public void upgrade(Building building) throws Exception { // takes a building as a parameter
    boolean exists = false; // declares a boolean variable and initializes it to false
    for (Facility i : this.estate.getFacilities()) { // loops through facilities in given estate
      if (i.equals(building)) {
        exists =
            true; // if the building passed as parameter is in the estate, boolean exists is set to
        // true
      }
    }
    if (exists) { // enters block of code if the facility is in the estate
      if (building.getUpgradeCost()
          == -1) { // getUpgradeCost returns -1 when the building is at its max level
        throw new Exception("Building at max level"); // relevant exception thrown
      } else if (this.budget
          >= building.getUpgradeCost()) { // checks if the budget is enough to upgrade
        this.budget -=
            building.getUpgradeCost(); // if it is, it subtracts the upgrade cost from the budget
        this.reputation += 50; // and adds 50 reputation points to the university
        building.increaseLevel(); // increases the level of the building
      }
    } else {
      throw new Exception(
          "Building not in university"); // throws relevant exception if building isn't in the given
          // estate
    }
  }

  public float getBudget() {
    return budget; // returns budget of university
  }

  public int getReputation() {
    return reputation; // returns reputation of university
  }

  public Facility[] getEstate() {
    return this.estate
        .getFacilities(); // returns an array of the facilities within the university's estate
  }

  public Estate getEstateObject() {
    return this.estate;
  }

  public ArrayList<Facility> getEstateAL() {
    return new ArrayList<>(Arrays.asList(this.estate.getFacilities()));
  }

  public void setBudget(float budgetNew) {
    this.budget = budgetNew;
  }

  public void setReputation(int reputationNew) {
    this.reputation = reputationNew;
  }
}
