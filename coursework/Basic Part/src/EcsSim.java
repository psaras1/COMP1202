import facilities.Facility;
import facilities.buildings.Building;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import university.HumanResource;
import university.Staff;
import university.University;

class EcsSim { // Electronics and computer science department simulation
  private University university;
  private ArrayList<Staff> staffMarket;
  private HumanResource hiredStaff;
  private int numLabs = 0;
  private int numTheatres = 0;
  private int numHalls = 0;
  private int year = 1;
  private boolean moveToNextYear = false;
  private boolean upgrade = false;
  private float averageLevel;

  /**
   * Constructor for EcsSim objects.
   *
   * @param funding is taken as a parameter.
   * @throws Exception from the upgrade method
   */
  public EcsSim(int funding) throws Exception {
    this.university =
        new University(funding); // initialise new university object with passed funding
    this.staffMarket = new ArrayList<>(); // initialise a new array list to store staff market
    this.hiredStaff =
        new HumanResource(); // initialise new human resource object to store hired staff
  }

  /**
   * Function is called whenever the university is in a position to build
   * Based on the current budget, number of each type of buildings
   * and costs associated with maintenance and staff the method will decide
   * what and how much of it to build.
   */
  public void
      chooseBuild() { // method that's called during simulation while upgrade variable isn't true
    if (this.year
        == 1) { // ensures that one of each building is built so that students can attend the
      // university if budget is enough
      if (this.university.getBudget() >= 600) {
        String name = "Lab" + numLabs;
        this.university.build("Lab", name);
        this.numLabs++;
        String name1 = "Theatre" + numTheatres;
        this.university.build("Theatre", name1);
        this.numTheatres++;
        String name2 = "Hall" + numHalls;
        this.university.build("Hall", name2);
        this.numHalls++;
      }
    }
    if (this.university.getBudget()
            >= 300 // check that given the current budget, the university can build a lab while
                // paying for current maintenance costs
                + this.university
                    .getEstateObject()
                    .getMaintenanceCost() // the way the university is building, it'll have an even
        // number of labs, halls and theatres
        && this.numLabs
            < 0.5 // at most 1 lab being built every 2 years
                * this.year) { // if the budget of the university is greater than 300 and number of
      // current labs is less than the corresponding 0.5*year
      String name = "Lab" + numLabs;
      this.university.build(
          "Lab", name); // call build method from university class, which manages both budget and
      // reputation
      this.numLabs++; // increment number of labs
      System.out.println("Built a lab, current number of labs: " + this.numLabs);
    } else if (this.university.getBudget()
            >= 200 // check that given the current budget, the university can build a theatre while
                // paying for current maintenance costs
                + this.university
                    .getEstateObject()
                    .getMaintenanceCost() // if lab wasn't built, try building theatre based on
        // given conditions
        && this.numTheatres < 0.3 * this.year) { // build a maximum of 0.3*years theatres
      String name = "Theatre" + numTheatres;
      this.university.build("Theatre", name); // calling build method from university class
      System.out.println("Built a Theatre, current number of labs: " + this.numTheatres);
      this.numTheatres++; // increment number of theatres
    } else if (this.university.getBudget()
            >= 100 // check that given the current budget, the university can build a hall while
                // paying for current maintenance costs
                + this.university
                    .getEstateObject()
                    .getMaintenanceCost() // if theatre wasn't built, try building hall based on
        // given conditions
        && this.numHalls < 0.3 * this.year) { // maximum of 0.3*year halls
      String name = "Hall" + numHalls;
      this.university.build("Hall", name); // calling build method from university class
      System.out.println("Built a Hall, current number of labs: " + this.numHalls);
      this.numHalls++; // increment stored number of halls
    } else {
      // If nothing was built, make
      // upgrade true so that
      // chooseUpgrade method is called
      this.upgrade = true;
    }
  }

  /**
   * Method called whenever the university is in a position to upgrade.
   * An array list of all facilities is created, and the method loops through all of them,
   * based on the budget, expenses and current year it decided whether to upgrade each building.
   * In case for any reason a building is not upgraded, the boolean moveToNextYear
   * is triggered, which allows the program to loop through the rest of the buildings
   * and then exit.
   *
   * @throws Exception IOException
   */
  public void chooseUpgrade() throws Exception {
    int size = this.university.getEstateAL().size();
    ArrayList<Facility> fac =
        university.getEstateAL(); // initialise an array list to store all current buildings in
    // university's estate and iterate through them to upgrade

    for (Facility k :
        fac) { // loop through all buildings AT LEAST once every year and TRY upgrading each one
      Building building =
          (Building)
              k; // declare each facility as a building object, to get corresponding costs for
      // upgrading
      if (this.university.getBudget()
              >= building.getUpgradeCost()
                  + this.university
                      .getEstateObject()
                      .getMaintenanceCost() // check that current budget can cover upgrade costs
          // while also paying
          // current maintenance costs
          && building.getUpgradeCost() != -1 // check that the building isn't at the max level
          && building.getLevel()
              < this.year
                  - 5) { // only upgrade if the current level of the building is less than the
        // current year-5
        // this moderates upgrading, so upgrades don't consume too much of university's budget/ go
        // out of control
        this.university.upgrade(building); // call upgrade method from university class
        System.out.println("Upgraded: " + k.getName() + ", Current level: " + building.getLevel());

      } else {
        this.moveToNextYear = true;
        // if the budget wasn't enough or a building was at its maximum level, move to next
        // year is set to true and the program moves to the next year after it iterates through all
        // existing buildings
      }
    }
  }

  /**
   * Construction method is called in the simulation, and
   * it calls either chooseBuild or chooseUpgrade based on the
   * state of the booleans.
   *
   * @throws Exception from chooseUpgrade method.
   */
  public void construction() throws Exception {
    while (!this.upgrade) { // while buildings can still be built based on current budget
      chooseBuild(); // call method to build
    }

    while (!this.moveToNextYear
        && this.year != 1) { // while upgrades can still be carried out and it isn't the first year
      chooseUpgrade(); // call method to upgrade
    }
  }

  /**
   * manageStaff is called at the end of each year.
   * It iterated through all hired staff and fires them if they have more than
   * 30 years at the university, or their stamina is depleted or if based
   * on a random chance they are chosen to leave.
   * In case a member does not leave the university, their stamina is replenished.
   */
  public void manageStaff() {
    if (this.year
        <= 1) { // If it's the first year, no need for staff to leave, therefore just replenish
      // their stamina
      Iterator<Staff> staffIterator = hiredStaff.getStaff();
      while (staffIterator.hasNext()) {
        Staff member = staffIterator.next();
        member.replenishStamina();
      }
      return;
    }
    ArrayList<Staff> toRemove = new ArrayList<>();
    Iterator<Staff> staff = hiredStaff.getStaff();
    double chanceToLeave = Math.random(); // generate a random number between 0-1
    while (staff.hasNext()) {
      Staff member = staff.next();
      member.increaseYearsOfTeaching();
      if (member.getYearsOfTeaching() > 30
          || member.getStamina() <= 20 && chanceToLeave > 0.2
          || member.getStamina() <= 0) {
        toRemove.add(
            member); // A member of staff retires at 30 years of teaching, has a random chance of
        // leaving if their stamina falls below or equal to 20 and is fired when they
        // run out of stamina
        staff.remove();
      } else {
        member.replenishStamina(); // if at the end of the year a member does not leave the
        // university, replenish their stamina
      }
    }
    System.out.println();
    System.out.println("The following members had to leave: ");
    System.out.println();
    for (Staff k : toRemove) {
      System.out.println(
          k.getName()
              + " Had to leave the university"); // iterate through toRemove arraylist to actually
      // remove the staff from the human resource object
      hiredStaff.removeStaff(k);
    }
  }

  /**
   * hire method first sorts all members in the staff market based on their skill.
   * It then hires staff with the highest skill while it has a positive budget,
   * the staff market is not empty, and it has less than 1 staff per 10 students or it
   * has less than 2 staff in general.
   */
  public void hire() {
    Collections.sort(
        staffMarket); // declared a compareTo method in Staff class, which sorts staff based on
    // their skill. This way, staff with the highest skill are hired first
    int i = 0; // index
    while ((this.university
                    .getBudget() // while the staffMarket isn't empty and there isn't at least one
                // staff per 10 students OR there's less than 2 staff, hire
                >= 0
            && !staffMarket.isEmpty()
            && (this.university.getEstateObject().getNumberOfStudents()) / 10
                > this.hiredStaff.getSize())
        || (hiredStaff.getSize() < 2)) {

      if (i < staffMarket.size()) { // use index to iterate through staff market
        if (staffMarket.get(i).getSalary() + this.university.getEstateObject().getMaintenanceCost()
            <= this.university.getBudget()) { // check that budget is enough to hire specific staff
          hiredStaff.addStaff(staffMarket.get(i)); // add Staff object to hiredStaff
          System.out.println(
              "Professor: " + staffMarket.get(i).getName() + " Just joined the university!");
          staffMarket.remove(i); // get object removed from the market
          i++;
        } else {
          break;
        }
      } else {
        break;
      }
    }
  }

  /**
   * The allocation method takes the number of students and
   * divides it with the number of staff.
   * It then allocates students to each staff and the staff's
   * stamina and skill are adjusted accordingly.
   * For every uninstructed student, the university looses 1 reputation point.
   *
   * @param numOfStudents takes number of students in integer form as a parameter.
   * @return number of uninstructed students is returned.
   */
  public int allocation(int numOfStudents) { // allocated students to staff
    int numOfTeachers = hiredStaff.getStaffKeys().size(); // get number of staff
    int groupSize = 0;
    int noTeacher;
    if (numOfTeachers > 0) { // prevent division by 0 error
      groupSize = numOfStudents / numOfTeachers; // determine group sizes
    }

    this.university.setReputation(
        this.university.getReputation() + groupSize); // university gains reputation points
    if (numOfTeachers > 0) { // prevent division by 0 error
      noTeacher = numOfStudents % numOfTeachers; // store the number of uninstructed students
    } else {
      noTeacher = numOfStudents; // if there are 0 staff, all students are uninstructed
    }

    for (Staff j : hiredStaff.getStaffKeys()) {
      this.university.setReputation(this.university.getReputation() + j.instruct(groupSize));
      //Call instruct method, based on the calculated group sizes.
      //Subtract equivalent stamina and add reputation to university.

    }
    return noTeacher;
  }

  /**
   * Pay all costs is called at the end of each year.
   * It sums up maintenance costs and salary costs and
   * subtracts them from the university's budget.
   */
  public void payAllCosts() { // method to manage university's logistics
    float currentBudget = this.university.getBudget(); // store current budget
    float costs =
        this.university.getEstateObject().getMaintenanceCost()
            + this.hiredStaff
                .getTotalSalary(); // add maintenance costs and total salary of staff to costs
    // variable

    this.university.setBudget(currentBudget - costs); // Adjust the university's budget
  }

  /**
   * Simulate acts as a parent method to all methods in the class.
   * It is called at the beginning of each year and calls all other
   * methods to build, upgrade, hire staff etc.
   *
   * @throws Exception again, from the upgrade method
   */
  public void simulate() throws Exception {
    System.out.println();
    System.out.println();
    System.out.print("----------------Current Year :" + this.year + "----------------");
    System.out.println();
    System.out.println();
    this.construction(); // call the construction method, to build or upgrade building accordingly
    this.manageStaff(); // fire existing staff
    System.out.println();
    System.out.println("New Professors: ");
    System.out.println();
    this.hire(); // hire some staff members or fire existing ones
    while (!this.staffMarket
            .isEmpty() // prevents the university from reaching 0 stuff while having enough budget
        // and available teachers in the market
        && this.hiredStaff.getSize() < 1) {
      if (this.university.getBudget() > 0) {
        this.hire();
      } else {
        break;
      }
    }

    int numStudents =
        this.university
            .getEstateObject()
            .getNumberOfStudents(); // calculate number of students based on minimal capacity
    this.allocation(numStudents); // call allocation method using # of students as a parameter
    this.university.setBudget(
        this.university.getBudget()
            + (numStudents
                * 10)); // the university gains 10 coins for each student, adjust the budget
    // end of year
    this.payAllCosts(); // call method to subtract salary and maintenance costs

    this.university.setReputation(
        this.university.getReputation()
            - this.allocation(
                numStudents)); // subtract 1 reputation point for each uninstructed student
    // determine if staff stays
    System.out.println("----------" + "End of Year(" + this.year + ") Statistics: " + "----------");
    System.out.println("Budget: " + this.university.getBudget());
    System.out.println("Reputation: " + this.university.getReputation());
    System.out.println(
        "Number of staff: "
            + this.hiredStaff.getSize()
            + ", total salary for this year: "
            + this.hiredStaff.getTotalSalary());
    System.out.println(
        "Maintenance cost: " + this.university.getEstateObject().getMaintenanceCost());
    System.out.println(
        "Number of students: " + this.university.getEstateObject().getNumberOfStudents());
    System.out.println(
        "Halls :" + this.numHalls + ", Labs :" + this.numLabs + ", Theatres :" + this.numTheatres);
    System.out.println("Number of buildings: " + this.university.getEstate().length);
    for (Facility j : this.university.getEstateAL()) {
      Building k = (Building) j;
      this.averageLevel += k.getLevel();
    }
    this.averageLevel = this.averageLevel / this.university.getEstateAL().size();
    System.out.println("Average level of buildings: " + this.averageLevel);
    System.out.println("Staff market size: " + staffMarket.size());

    System.out.println("------------------------------------------------");
    this.upgrade = false;
    this.moveToNextYear = false;
  }

  /**
   * Calls simulate method as many times as the years passed as parameter.
   *
   * @param years years taken as an integer.
   * @throws Exception same as the simulation.
   */
  public void simulate(int years)
      throws Exception { // call simulate method for "years" number of years
    for (int i = 0; i < years; i++) {
      this.simulate();
      this.year++;
    }

    System.exit(0);
  }

  /**
   * Populate market is called when a new EcsSim object is created.
   * It uses a given text file to populate the staff market.
   *
   * @param filename filename taken as parameter.
   */
  public void populateMarket(String filename) { // get filename as parameter
    try {
      BufferedReader reader =
          new BufferedReader(
              new FileReader(filename)); // create a buffered reader object to read file
      String read;
      while ((read = reader.readLine()) != null) { // read through each line while it's not empty
        String[] parts =
            read.split(
                "\\s*\\(\\s*|\\s*\\)\\s*"); // split each line using the given regex to get name and
        // skill. Regex matches zero or more spaces, followed by an opening bracket with zero or
        // more spaces after it OR matches a closing bracket with zero or more spaces preceding it.
        staffMarket.add(
            new Staff(
                parts[0],
                Integer.valueOf(
                    parts[1]))); // uses the generated split array called parts, and matches each
        // element to the staffs name and skill accordingly
      }
    } catch (IOException e) { // in case the file doesn't exist
      System.err.println(
          e); // prints appropriate exception to console (java.io.FileNotFoundException: staffs1.txt
      // (No such file or directory)
      System.exit(1);
    }
  }

  /**
   * Main method takes 3 arguments.
   * The file name to use to populate the market,
   * The initial funding of the university and
   * the number of years for the simulation to run.
   *
   * @param args if less than 3 arguments are passed, program exits.
   * @throws Exception in case the file doesn't exist.
   */
  public static void main(String[] args) throws Exception {
    if (args.length
        != 3) { // if the arguments passed through the main method are not three (file name, funding
      // and number of years to simulate), exit the program with status 1
      System.exit(1);
    }
    String file = args[0]; // else, assign each argument to respective variable
    int funding = Integer.valueOf(args[1]);
    int years = Integer.valueOf(args[2]);

    EcsSim ecsSim = new EcsSim(funding); // create a new EcsSim object
    ecsSim.populateMarket(file); // populate staff market from the passed file
    ecsSim.simulate(years); // call the simulate method with passed years
  }
}
