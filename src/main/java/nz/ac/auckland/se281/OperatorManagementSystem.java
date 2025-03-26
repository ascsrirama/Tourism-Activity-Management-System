package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Types.Location;

public class OperatorManagementSystem {
ArrayList<String> operators = new ArrayList<>();
  // Do not change the parameters of the constructor
  public OperatorManagementSystem() {
    this.operators = new ArrayList<>();
  }

  public void searchOperators(String keyword) {
    // TODO implement
    System.out.println("There are no matching operators found.");
  }

  public void createOperator(String operatorName, String location) {
  
    Location locationFound = Location.fromString(location);
    String locationAsString = locationFound.getFullName();

  
    //Operator op = new Operator(operatorName, locationFound);

    String[] words = operatorName.split(" ");

    String output = "";

    String initials = "";

    for(String word : words) { 
      initials += word.charAt(0);
    }
    

    // if( ) { 
    //   int count = 0; 
    //   count++; 
    // }
    
    //String number = "00" + count;
    // int number = 0; 
    // for (String loc:operators) { 
    //   if( loc.equals(operators)) { 
    //     number++ ; 
    //   }
    // }

    output += initials; //takes the initials and moves them into the print out

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
