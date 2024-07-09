package university;

import facilities.Facility;
import facilities.buildings.Building;
import facilities.buildings.Hall;
import facilities.buildings.Lab;
import facilities.buildings.Theatre;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * An estate is an object that has many facilities within it.
 * Belongs to an instance of university.
 * facilities stores all buildings within the estate in an array list.
 */
public class Estate implements Serializable {
  private ArrayList<Facility>
      facilities; // instance variable of ArrayList to store all the facilities in the estate
  private int count;

  /**
   * Constructor for the estate class.
   * Initializes a new Array List and assigns it to the facilities variable.
   */
  public Estate() {
    this.facilities =
        new ArrayList<
            Facility>(); // the constructor of the Estate class initializes an empty ArrayList of
    // type Facility
  }


  /**
   * Iterates through facilities object.
   *
   * @return an array with all facilities within this instance of estate
   */
  public Facility[] getFacilities() {
    int n = facilities.size(); // returns the magnitude of the facilities ArrayList
    Facility[] facilitiesArray =
        new Facility[n]; // creates an array based on the magnitude calculated on previous line
    for (int i = 0; i < n; i++) { // iterates through indexes of facilitiesArray
      facilitiesArray[i] = facilities.get(i); // stores corresponding values from ArrayList
    }
    return facilitiesArray; // returns the newly created array
  }

  /**
   * Called to add facilities to the estate.
   *
   * @param type determines what type of building the facility is
   * @param name gives the name of the facility
   * @return returns the new facility object
   */
  public Facility addFacility(String type, String name) {
    switch (type) { // depending on the type passed as parameter, different code is executed
      case "Hall": {
        Hall newFacility = new Hall(name); // Stores an instance of Hall
        facilities.add(newFacility);
        return newFacility; // returns the added facility
      }
      case "Lab": {
        Lab newFacility = new Lab(name); // Stores an instance of Lab
        facilities.add(newFacility);
        return newFacility; // returns the added facility
      }
      case "Theatre": {
        Theatre newFacility = new Theatre(name); // Stores an instance of Theatre
        facilities.add(newFacility);
        return newFacility; // returns the added facility
      }
      default: {
        return null; // returns null if the parameter passed as type is not Hall, Lab or Theatre
      }
    }
  }

  /**
   * calculates maintenance costs of all buildings in the estate.
   *
   * @return returns the calculated total maintenance costs.
   */
  public float getMaintenanceCost() {
    float totalMaintenanceCost = 0; // defined a float for the total and initializes it to 0
    for (Facility i : facilities) { // iterates through the ArrayList
      Building building = (Building) i; //states that Facilities are buildings(so that building
      //methods work)
      float maintenanceCost = (float) (building.getCapacity() * 0.1); //given formula for
      //calculating maintenance costs
      totalMaintenanceCost += (float) (((Building) i).getCapacity() * 0.1); // adds value to total
    }
    return totalMaintenanceCost; // after iterating through all objects, it returns the total
    // maintenance costs
  }

  /**
   * Calculates the minimal capacity of all buildings within the estate.
   *
   * @return returns the capacity of all building of a given type of minimal capacity.
   */
  public int getNumberOfStudents() {
    int totalHall = 0; // initialises capacity of halls, labs and theatres to 0
    int totalLab = 0;
    int totalTheatre = 0;
    for (Facility j : facilities) { // iterates through the facilities ArrayList
      if (j
          instanceof
          Hall) { // adds corresponding value to totals, depending on the type of the facility
        totalHall += ((Hall) j).getCapacity();
      } else if (j instanceof Lab) {
        totalLab += ((Lab) j).getCapacity();
      } else if (j instanceof Theatre) {
        totalTheatre += ((Theatre) j).getCapacity();
      }
    }
    return Math.min(
        totalHall,
        Math.min(totalLab, totalTheatre)); // returns the type of building with the minimal capacity
  }
}
