package facilities.buildings;



/**
 * interface implemented by Hall, Lab and Theatre.
 */
public interface Building {

  public int getLevel(); //all 3 classes implementing the interface have to define the
  //following methods, acts as a contract for all classes implementing it

  public void increaseLevel();

  public int getUpgradeCost();

  public int getCapacity();
}
