package nz.ac.auckland.se281;

public class Operator {
 private String operatorName; 
 private Types.Location location;
 private String opID;

  public Operator(String operatorName, Types.Location location, String opID){ 
    this.operatorName = operatorName;
    this.location = location;
    this.opID = opID;

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
}
