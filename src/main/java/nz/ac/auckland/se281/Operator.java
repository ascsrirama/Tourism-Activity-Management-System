package nz.ac.auckland.se281;


import java.util.ArrayList;


public class Operator {
 private String operatorName; 
 private Types.Location location;
 private String opID;
 private ArrayList<String> activities;
 

  public Operator(String operatorName, Types.Location location, String opID){ 
    this.operatorName = operatorName;
    this.location = location;
    this.opID = opID;
    this.activities = new ArrayList<>();

  }

  public String returnOperator(){
      return this.operatorName;
  }

  public String getOpID() {
    return this.opID;
  }

  public Types.Location getLocation() {
    return this.location;
  } 
  
  
  public void addActivity(String activity) {
    activities.add(activity);
  }
  
  
  public ArrayList<String> getActivities() {
    return activities;
  }

 
}
