package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.Location;

public class OperatorManagementSystem {

  // Do not change the parameters of the constructor
  public OperatorManagementSystem() {}

  public void searchOperators(String keyword) {
    // TODO implement
    System.out.println("There are no matching operators found.");
  }

  public void createOperator(String operatorName, String location) {
    // TODO implement
    Location locationFound = Location.fromString(location);
    String locationAsString = locationFound.getFullName();

    Operator op = new Operator(operatorName, locationFound);
 
    String[] words = operatorName.split(" ");

    String output = "";

    String initials = "";

    for(String word : words) { 
      initials += word.charAt(0);
    }
    //String listOfLocations = operatorName;
    // for (String place : listOfLocations) { 
    //   if (place == ) { 
    //     int number = 001; 
    //   }

    // }
    
    String number = "001";

    output += initials;

    output += "-" + locationFound.getLocationAbbreviation() + "-" + number;



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
