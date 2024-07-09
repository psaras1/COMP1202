package university;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Class that has a hashmap that stores Staff objects along with their salaries.
 * Total salary is its second instance variable, stores total salary from objects in HashMap.
 */
public class HumanResource implements Serializable {
  public HashMap<Staff, Float> staffSalary;
  private float totalSalary;

  /**
   * Constructor, initializes a new hashmap.
   * Initializes total salary to 0.
   */
  public HumanResource() {
    this.staffSalary = new HashMap<Staff, Float>();
    this.totalSalary = 0;
  }

  /**
   * Called to add new staff to HashMap.
   *
   * @param staff Takes the Staff object as a parameter.
   */
  public void addStaff(Staff staff) {
    Random ran = new Random();
    float randomPercentage =
        (float)
            (0.095
                + ran.nextFloat()
                    * (0.105
                        - 0.0955)); // assigns a random number from 9.55% to 10.5% to variable
    // randomPercentage

    float salary =
        staff.getSkill()
            * randomPercentage; // uses the stored random percentage and staff's skill to calculate
    // salary
    staffSalary.put(staff, salary);
  }

  /**
   * Creates an iterator object for the key set of the hashmap staffSalary.
   *
   * @return Returns the iterator object.
   */
  public Iterator<Staff> getStaff() {
    Iterator<Staff> staffIterator =
        this.staffSalary
            .keySet()
            .iterator();
    return staffIterator;
  }

  public Set<Staff> getStaffKeys() {
    return staffSalary.keySet();
  }

  /**
   * Calculates total salary from all values of staffSalary hashmap.
   *
   * @return Returns calculated float.
   */
  public float getTotalSalary() {
    totalSalary = 0;
    for (float i : staffSalary.values()) { // iterates through values of the hash map
      totalSalary += i;
      // adds each value to the totalSalary instance variable of HumanResource
    }
    return totalSalary; // returns the calculated total salary of all staff objects in the hashmap
  }

  public int getSize() {
    return this.staffSalary.size();
  }

  public void removeStaff(Staff staff) {
    staffSalary.remove(staff);
  }
}
