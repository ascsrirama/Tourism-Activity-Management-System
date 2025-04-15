package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.ActivityType;

public class Activity {
  private String name;
  private Types.ActivityType type; 
  private String activityID;
  private Operator operator;

  public Activity (String name,  Types.ActivityType type, String activityID, Operator operator) {
    this.name = name;
    this.type = type; 
    this.activityID = activityID;
    this.operator = operator;

  }

  public String getName() {
    return name;
  }

  public Types.ActivityType getType() {
    return type;
  }

  public String getActivityID() {
    return activityID;
  }

  public Operator getOperator() {
    return operator;
  }

  
}
