package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.HashMap;

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
  HashMap<String, Integer> op_per_location = new HashMap<>();
  //int count = 0;
  // If keyword is "*", display all operators
  if (keyword.trim().equals("*")) {
      int totalCount = operators.size();
      String verb = (totalCount == 1) ? "is" : "are";
      String plural = (totalCount == 1) ? "" : "s";
      String ending = (totalCount == 0) ? "." : ":";

      MessageCli.OPERATORS_FOUND.printMessage(verb, String.valueOf(totalCount), plural, ending);

      // Print each operator's information
      for (Operator op : operators) {
          printOperator(op, op_per_location);
      }
  } else {
      // For non-"*" keyword searches
      ArrayList<Operator> MATCHING = new ArrayList<>();
      //int matchingCount = 0;  
      for (Operator op : operators) {
          String operatorName = op.returnOperator().toLowerCase();
          String locationEnglish = op.getLocation().getNameEnglish().toLowerCase();
          String locationTeReo = op.getLocation().getNameTeReo().toLowerCase();
          String locationAbbr = op.getLocation().getLocationAbbreviation().toLowerCase();

          // Check if the keyword matches the location (either English or Māori)
          if (locationEnglish.contains(keyword.toLowerCase().trim()) || locationTeReo.contains(keyword.toLowerCase().trim()) || locationAbbr.contains(keyword.toLowerCase().trim()) ||
          operatorName.contains(keyword.toLowerCase().trim())) {
              MATCHING.add(op);
          }
      }
      int matchingCount = MATCHING.size();
      if (matchingCount == 0) {
        MessageCli.OPERATORS_FOUND.printMessage("There are no matching operators found.");
      } else {

      // Print for matched operators
      String verb = (matchingCount == 1) ? "is" : "are";
      String plural = (matchingCount == 1) ? "" : "s";
      String ending = (matchingCount == 0) ? "." : ":" ;
      MessageCli.OPERATORS_FOUND.printMessage(verb, String.valueOf(matchingCount), plural, ending);
      for (Operator op: MATCHING){
        printOperator(op, op_per_location);
      }
  }
}
   
  }
    
  //END OF SEARCH OPERATORS//

  //This method will make life easier by allowing me to have the apt logic 
  private void printOperator(Operator op, HashMap<String, Integer> op_per_location) {
    String location = op.getLocation().getFullName();
    String operatorName = op.returnOperator();
    String locationAbbr = op.getLocation().getLocationAbbreviation();
    System.out.println("  * " + operatorName + " ('" + op.getOpID() + "' located in '" + location + "')");


    // // Get initials and formating the operator ID
    // String[] words = operatorName.split(" ");
    // String initials = "";
    // for (String word : words) {
    //     initials += word.charAt(0); // Get the initials
    // }

    // // Increment the count
    // int countID = op_per_location.getOrDefault(locationAbbr, 0) + 1;
    // op_per_location.put(locationAbbr, countID); // Store the updated count for the location

    // // Format operator ID 
    // String operatorIDFormatted = initials + "-" + locationAbbr + "-" + String.format("%03d", countID);

    // // Print the operator details with the formatted ID to the output
    // System.out.println("  * " + operatorName + " ('" + operatorIDFormatted + "' located in '" + location + "')");
}
 
// CREATE OPERATOR STARTS HERE
  public void createOperator(String operatorName, String location) {
     Location locationFound = Location.fromString(location); 
     if(locationFound == null) {
        MessageCli.OPERATOR_NOT_CREATED_INVALID_LOCATION.printMessage(location);
        return;
      }
      
     
    if ( operatorName.trim().length() >= 3) {
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
        
      
        // ===== 3digit number maker =====
        int count = 1; 
        for (Operator op_existing : operators) {
            if (op_existing.getLocation().equals(locationFound)) {
                count++;
            }
        }
        String operatorID = initials + "-" + locationFound.getLocationAbbreviation() + "-" + String.format("%03d", count);
        Operator op = new Operator(operatorName, locationFound, operatorID);  
        operators.add(op);

        MessageCli.OPERATOR_CREATED.printMessage(operatorName, operatorID, locationAsString); 
        // Operator op = new Operator(operatorName, locationFound, initials);  
        // operators.add(op);
        // output += "-" + locationFound.getLocationAbbreviation() + "-"+ "00"+count ;
        
        // MessageCli.OPERATOR_CREATED.printMessage(operatorName, output, locationAsString); 
      } 
  else {
    MessageCli.OPERATOR_NOT_CREATED_INVALID_OPERATOR_NAME.printMessage(operatorName);
  }

  }
  // CREATE OPERATOR ENDS HERE

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
