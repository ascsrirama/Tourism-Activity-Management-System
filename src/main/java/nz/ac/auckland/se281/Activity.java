package nz.ac.auckland.se281;



public class Activity {
  private String name;
  private Types.ActivityType Type; 
  private String activityID;


  public Activity (String name,  Types.ActivityType Type, String activityID) {
    this.name = name;
    this.Type = Type; 
    this.activityID = activityID;
    

  }

  public String getName() {
    return name;
  }

  public Types.ActivityType getType() {
    return Type;
  }

  public String getActivityID() {
    return activityID;
  }

  
}
