package facilities.buildings;

import facilities.Facility;
import java.io.Serializable;

/** A research facility gains revenue and reputation for the University. */
public class Research implements Serializable {
  private int level;
  private String name;
  private final int baseCost = 1000;
  private final int baseCapacity = 0;
  private final int maxLevel = 1;
  private final int earnings = 1000;
  private final int reputationGains = 800;

  public Research(String name) {
    this.name = name;
    this.level = 1;
  }

  public int getReputationGains() {
    return this.reputationGains;
  }

  public int getEarnings() {
    return this.earnings;
  }

  public String getName() {
    return this.name;
  }
}
