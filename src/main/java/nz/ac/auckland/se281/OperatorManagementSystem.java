package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Types.Location;

public class OperatorManagementSystem {
ArrayList<Operator> operators = new ArrayList<>();


  // Do not change the parameters of the constructor


  public OperatorManagementSystem() {
    this.operators = new ArrayList<>();
  }



  // SEARCH OPERATORS BEGINS HERE // 
  public void searchOperators(String keyword) {
    if (operators.isEmpty()) {
      System.out.println("There are no matching operators found.");
      return; 
  }

  if (keyword.equals("*")) {
      int count = operators.size();
      String verb = (count == 1) ? "is" : "are";
      String plural = (count == 1) ? "" : "s";
      String ending = (count == 0) ? "." : ":";

      // Print out the message for the number of operators found
      MessageCli.OPERATORS_FOUND.printMessage(verb, String.valueOf(count), plural, ending);

      // Loop through each operator and format the output
      for (Operator op : operators) {
          // Getting the operator's location and ID
          String location = op.getLocation().getFullName();
          String operatorName = op.returnOperator();
          String locationAbbr = op.getLocation().getLocationAbbreviation();

          String[] words = operatorName.split(" ");
          String initials = "";
          for (String word : words) {
              initials += word.charAt(0); // Get the initials
          }
          int countID = 1; // 
          String operatorIDFormatted = initials + "-" + locationAbbr + "-" + String.format("%03d", countID);

          // Printing out the formatted operator details
          System.out.println("  * " + operatorName + " ('" + operatorIDFormatted + "' located in '" + location + "')");
      }
  }
    }
    
  //END OF SEARCH OPERATORS//

  public void createOperator(String operatorName, String location) {
  
    Location locationFound = Location.fromString(location);
    String locationAsString = locationFound.getFullName();
    //This thing is to check for duplicates of operators
    for(Operator existing : operators) {
      if(existing.returnOperator().equals(operatorName) && existing.getLocation().equals(locationFound)) {
        MessageCli.OPERATOR_NOT_CREATED_ALREADY_EXISTS_SAME_LOCATION.printMessage(operatorName,locationAsString);
        return;
      }
    }

  
    // This will make that id thing that has intials of operator and location and the 3dig no.
    String[] words = operatorName.split(" ");
    String output = "";
    String initials = "";
    for(String word : words) { 
      initials += word.charAt(0);
    }  
    output += initials; //takes the initials and moves them into the print out    
  
    //This here makes the 3dig no.
    Operator op = new Operator(operatorName, locationFound, initials);  
    operators.add(op);
    
    int count=0;
    for (Operator place: operators){ 
      if(place.returnOperator().equals(operatorName))
        count++;
      }
      
    output += "-" + locationFound.getLocationAbbreviation() + "-"+ "00"+count ;
    
    MessageCli.OPERATOR_CREATED.printMessage(operatorName, output, locationAsString); 



  }

  public void viewActivities(String operatorId) {
    // TODO implement

    
  }

  public void createActivity(String activityName, String activityType, String operatorId) {
    // TODO implement
  }

  public void searchActivities(String keyword) {
    // TODO implement
  }

  public void addPublicReview(String activityId, String[] options) {
    // TODO implement
  }

  public void addPrivateReview(String activityId, String[] options) {
    // TODO implement
  }

  public void addExpertReview(String activityId, String[] options) {
    // TODO implement
  }

  public void displayReviews(String activityId) {
    // TODO implement
  }

  public void endorseReview(String reviewId) {
    // TODO implement
  }

  public void resolveReview(String reviewId, String response) {
    // TODO implement
  }

  public void uploadReviewImage(String reviewId, String imageName) {
    // TODO implement
  }

  public void displayTopActivities() {
    // TODO implement
  }
}
