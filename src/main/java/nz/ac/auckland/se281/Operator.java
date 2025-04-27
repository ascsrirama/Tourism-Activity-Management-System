package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Operator {
  private String operatorName;
  private Types.Location location;
  private String opId;
  private ArrayList<Activity> activities;

  public Operator(String operatorName, Types.Location location, String opId) {
    this.operatorName = operatorName;
    this.location = location;
    this.opId = opId;
    this.activities = new ArrayList<>();
  }

  public String returnOperator() {
    return this.operatorName;
  }

  public String getopId() {
    return this.opId;
  }

  public Types.Location getLocation() {
    return this.location;
  }

  public void addActivity(Activity activity) {
    activities.add(activity);
  }

  public ArrayList<Activity> getActivities() {
    return activities;
  }
}
