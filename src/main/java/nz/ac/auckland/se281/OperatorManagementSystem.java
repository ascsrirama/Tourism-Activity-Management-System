package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.HashMap;
import nz.ac.auckland.se281.Types.ActivityType;
import nz.ac.auckland.se281.Types.Location;

public class OperatorManagementSystem {
  private ArrayList<Operator> operators = new ArrayList<>();

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

      for (Operator op : operators) {
        String operatorName = op.returnOperator().toLowerCase();
        String locationEnglish = op.getLocation().getNameEnglish().toLowerCase();
        String locationTeReo = op.getLocation().getNameTeReo().toLowerCase();
        String locationAbbr = op.getLocation().getLocationAbbreviation().toLowerCase();

        // Check if the keyword matches the location
        if (locationEnglish.contains(keyword.toLowerCase().trim())
            || locationTeReo.contains(keyword.toLowerCase().trim())
            || locationAbbr.contains(keyword.toLowerCase().trim())
            || operatorName.contains(keyword.toLowerCase().trim())) {
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
        String ending = (matchingCount == 0) ? "." : ":";
        MessageCli.OPERATORS_FOUND.printMessage(
            verb, String.valueOf(matchingCount), plural, ending);
        for (Operator op : MATCHING) {
          printOperator(op, op_per_location);
        }
      }
    }
  }

  // END OF SEARCH OPERATORS//

  // This method will make life easier
  private void printOperator(Operator op, HashMap<String, Integer> op_per_location) {
    String location = op.getLocation().getFullName();
    String operatorName = op.returnOperator();
    // String locationAbbr = op.getLocation().getLocationAbbreviation();
    System.out.println(
        "  * " + operatorName + " ('" + op.getOpID() + "' located in '" + location + "')");
  }

  // CREATE OPERATOR STARTS HERE
  public void createOperator(String operatorName, String location) {

    Location locationFound = Location.fromString(location);

    if (locationFound == null) {
      MessageCli.OPERATOR_NOT_CREATED_INVALID_LOCATION.printMessage(location);
      return;
    }

    if (operatorName.trim().length() >= 3) {
      String locationAsString = locationFound.getFullName();

      // This thing is to check for duplicates of operators
      for (Operator existing : operators) {
        if (existing.returnOperator().equals(operatorName)
            && existing.getLocation().equals(locationFound)) {
          MessageCli.OPERATOR_NOT_CREATED_ALREADY_EXISTS_SAME_LOCATION.printMessage(
              operatorName, locationAsString);
          return;
        }
      }
      // This will make that id thing that has intials of operator and location and the 3dig no.
      String[] words = operatorName.split(" ");
      String output = "";
      String initials = "";
      for (String word : words) {
        initials += word.charAt(0);
      }
      output += initials; // takes the initials and moves them into the print out

      // ===== 3digit number maker =====
      int count = 1;
      for (Operator op_existing : operators) {
        if (op_existing.getLocation().equals(locationFound)) {
          count++;
        }
      }
      String operatorID =
          initials
              + "-"
              + locationFound.getLocationAbbreviation()
              + "-"
              + String.format("%03d", count);
      Operator op = new Operator(operatorName, locationFound, operatorID);
      operators.add(op);

      MessageCli.OPERATOR_CREATED.printMessage(operatorName, operatorID, locationAsString);
    } else {
      MessageCli.OPERATOR_NOT_CREATED_INVALID_OPERATOR_NAME.printMessage(operatorName);
    }
  }

  // CREATE OPERATOR ENDS HERE

  // VIEW ACTIVITIES BEGINS HERE============================
  public void viewActivities(String operatorId) {
    for (Operator op : operators) {

      if (op.getOpID().equals(operatorId)) {
        ArrayList<Activity> activities = op.getActivities();

        if (activities.isEmpty()) {
          MessageCli.ACTIVITIES_FOUND.printMessage("are", "no", "ies", ".");

        } else {

          int counter = activities.size();
          String verb = (counter == 1) ? "is" : "are";
          String plural = (counter == 1) ? "y" : "ies";
          String ending = ":";
          MessageCli.ACTIVITIES_FOUND.printMessage(verb, String.valueOf(counter), plural, ending);

          // add the stars at the front
          for (Activity activity : activities) {
            // we  need the activity id
            ActivityType type = activity.getType();
            String activityID = activity.getActivityID();
            MessageCli.ACTIVITY_ENTRY.printMessage(
                activity.getName(), activityID, type.toString(), op.returnOperator());
          }
        }
        return;
      }
    }

    MessageCli.OPERATOR_NOT_FOUND.printMessage(operatorId);
  }

  // VIEW ACTIVITES ENDS HERE ===========================

  public void createActivity(String activityName, String activityType, String operatorId) {

    if (activityName.trim().length() < 3) {
      MessageCli.ACTIVITY_NOT_CREATED_INVALID_ACTIVITY_NAME.printMessage(activityName);
      return;
    } else {

      Types.ActivityType type = Types.ActivityType.fromString(activityType);

      for (Operator op : operators) {
        if (op.getOpID().equals(operatorId)) {
          // need to make Activity id
          int activityCount = op.getActivities().size() + 1;
          String activityID = op.getOpID() + "-" + String.format("%03d", activityCount);

          Activity newActivity = new Activity(activityName, type, activityID);
          op.addActivity(newActivity);

          MessageCli.ACTIVITY_CREATED.printMessage(
              activityName, activityID, type.toString(), op.returnOperator());
          return;
        }
      }
      MessageCli.ACTIVITY_NOT_CREATED_INVALID_OPERATOR_ID.printMessage(operatorId);
    }
  }

  // SEARCH ACTIVITES STRARTS HERE ==========================
  public void searchActivities(String keyword) {

    // if the keyword is * we need to show all the activities
    if (keyword.trim().equals("*")) {
      int totalCount = 0; // This is to count how many there are to tell us 1,2,3 etc matching ....

      for (Operator op : operators) {
        ArrayList<Activity> activities = op.getActivities();
        totalCount += activities.size();
      }

      if (totalCount == 0) {
        MessageCli.ACTIVITIES_FOUND.printMessage("are", "no", "ies", ".");
      } else {
        String verb = (totalCount == 1) ? "is" : "are";
        String plural = (totalCount == 1) ? "" : "ies";
        MessageCli.ACTIVITIES_FOUND.printMessage(verb, String.valueOf(totalCount), plural, ":");

        // THIS WILL PRINT OUT THE ACTIVITIES
        for (Operator op : operators) {
          ArrayList<Activity> activities = op.getActivities();
          for (Activity activity : activities) {
            String activityID = activity.getActivityID();
            String type = activity.getType().toString();
            String operatorName = op.returnOperator();

            // Print out the message with activity name, id, type and operator name
            MessageCli.ACTIVITY_ENTRY.printMessage(
                activity.getName(), activityID, type, operatorName);
          }
        }
      }

    } else {
      // This is for when keyword is not * , so we must look at name/type/op location
      int totalCount = 0;
      for (Operator op : operators) {

        ArrayList<Activity> activities = op.getActivities();
        // lets go thru the activities within the arraylist and get their info
        for (Activity activity : activities) {
          String activityName = activity.getName().toLowerCase();
          String activityType = activity.getType().toString().toLowerCase();
          String opLocation = op.getLocation().getFullName().toLowerCase();

          if (activityName.contains(keyword.toLowerCase().trim())
              || activityType.contains(keyword.toLowerCase().trim())
              || opLocation.contains(keyword.toLowerCase().trim())) {
            totalCount++;
          }
        }
      }
      // if there is nothing so , total count = 0
      if (totalCount == 0) {
        MessageCli.ACTIVITIES_FOUND.printMessage("are", "no", "ies", ".");
      } else {

        String verb = (totalCount == 1) ? "is" : "are";
        String plural = (totalCount == 1) ? "y" : "ies";
        MessageCli.ACTIVITIES_FOUND.printMessage(verb, String.valueOf(totalCount), plural, ":");

        // THIS WILL PRINT OUT THE ACTIVITIES
        for (Operator op : operators) {
          ArrayList<Activity> activities = op.getActivities();
          for (Activity activity : activities) {
            String activityName = activity.getName().toLowerCase();
            String activityType = activity.getType().toString().toLowerCase();
            String opLocation = op.getLocation().getFullName().toLowerCase();

            if (activityName.contains(keyword.toLowerCase().trim())
                || activityType.contains(keyword.toLowerCase().trim())
                || opLocation.contains(keyword.toLowerCase().trim())) {
              String activityID = activity.getActivityID();
              String type = activity.getType().toString();
              String operatorName = op.returnOperator();
              MessageCli.ACTIVITY_ENTRY.printMessage(
                  activity.getName(), activityID, type, operatorName);
            }
          }
        }
      }
    }
  }

  // SEARCH ACTIVITES ENDS HERE ==========================

  public void addPublicReview(String activityId, String[] options) {
    for (Operator op : operators) {
      for (Activity activity : op.getActivities()) {
        // check if the activity id is the same as the one we are looking for
        if (activity.getActivityID().equals(activityId)) {
          // if it is the same we need to add the review
          String author = options[0];
          boolean isAnonymous =
              options[1].equalsIgnoreCase("y") || options[1].equalsIgnoreCase("n");
          int rating = Integer.parseInt(options[2]);
          String reviewText = options[3];

          // adjust the ratings
          if (rating < 1) rating = 1;
          if (rating > 5) rating = 5;

          // generate reviewId
          int reviewNumber = activity.getReviews().size() + 1;
          String reviewId = activityId + "-R" + reviewNumber;

          // create the review and add it
          PublicReview review =
              new PublicReview(author, reviewId, rating, reviewText, isAnonymous, false);
          activity.addReview(review);

          // message REVIEW_ADDED("%s review '%s' added successfully for activity '%s'."),
          MessageCli.REVIEW_ADDED.printMessage(
              "Public", reviewId, activity.getName(), activity.getActivityID());
          return;
        }
      }
    }
    // if the id is not found
    MessageCli.REVIEW_NOT_ADDED_INVALID_ACTIVITY_ID.printMessage(activityId);
  }

  public void addPrivateReview(String activityId, String[] options) {
    for (Operator op : operators) {
      for (Activity activity : op.getActivities()) {
        if (activity.getActivityID().equals(activityId)) {
          // if it is the same we need to add the review
          String author = options[0];
          String email = options[1];
          int rating = Integer.parseInt(options[2]);
          String reviewtText = options[3];
          boolean isFollowUpRequested =
              options[4].equalsIgnoreCase("y") || options[4].equalsIgnoreCase("n");

          // adjust the ratings
          if (rating < 1) rating = 1;
          if (rating > 5) rating = 5;
          // generate reviewId
          int reviewNumber = activity.getReviews().size() + 1;
          String reviewId = activityId + "-R" + reviewNumber;

          // create the review and add it
          PrivateReview review =
              new PrivateReview(author, reviewId, rating, reviewtText, email, isFollowUpRequested);
          activity.addReview(review);

          // print out the message
          MessageCli.REVIEW_ADDED.printMessage(
              "Private", reviewId, activity.getName(), activity.getActivityID());
          return;
        }
      }
    }
    MessageCli.REVIEW_NOT_ADDED_INVALID_ACTIVITY_ID.printMessage(activityId);
  }

  public void addExpertReview(String activityId, String[] options) {
    for (Operator op : operators) {
      for (Activity activity : op.getActivities()) {
        if (activity.getActivityID().equals(activityId)) {
          // if it is the same we need to add the review
          String author = options[0];
          int rating = Integer.parseInt(options[1]);
          String reviewText = options[2];
          boolean isRecommended =
              options[3].equalsIgnoreCase("y") || options[3].equalsIgnoreCase("n");

          // adjust the ratings
          if (rating < 1) rating = 1;
          if (rating > 5) rating = 5;

          // generate reviewId
          int reviewNumber = activity.getReviews().size() + 1;
          String reviewId = activityId + "-R" + reviewNumber;

          // create the review and add it
          ExpertReview review =
              new ExpertReview(author, reviewId, rating, reviewText, isRecommended);
          activity.addReview(review);

          // print out the message
          MessageCli.REVIEW_ADDED.printMessage(
              "Expert", reviewId, activity.getName(), activity.getActivityID());
          return;
        }
      }
    }
    MessageCli.REVIEW_NOT_ADDED_INVALID_ACTIVITY_ID.printMessage(activityId);
  }

  public void displayReviews(String activityId) {
    // lets go thru the operators and find the activity id

    for (Operator op : operators) {
      for (Activity activity : op.getActivities()) {
        // check if the activity id is the same as the one we are looking for
        if (activity.getActivityID().equals(activityId)) {
          // if it is the same we need to get the reviews
          ArrayList<Review> reviews = activity.getReviews();

          // if there are no reviews
          if (reviews.isEmpty()) {
            MessageCli.REVIEWS_FOUND.printMessage("are", "no", "s", activity.getName());

          } else {
            // if there are reviews
            String verb = (reviews.size() == 1) ? "is" : "are";
            String plural = (reviews.size() == 1) ? "" : "s";
            MessageCli.REVIEWS_FOUND.printMessage(
                verb, String.valueOf(reviews.size()), plural, activity.getName());

            // Print out the reviews
            for (Review review : reviews) {
              review.displayReview();
            }
          }
          return;
        }
      }
    }

    // if the id is not found
    MessageCli.ACTIVITY_NOT_FOUND.printMessage(activityId);
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
