package facilities;

import java.io.Serializable;

/**
 * All facilities must have a name and a get name method
 * Hall, Theatre and Lab classes extend Facility class.(Acts as a parent class)
 */
public class Facility implements Serializable {
  private String name; // instance variable, all facilities have a name

  public Facility(String name) { // constructor
    this.name = name;
  }

  public String getName() { // returns the name of particular instance of facility
    return name;
  }
}
