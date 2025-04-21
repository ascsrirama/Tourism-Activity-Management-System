package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Activity {
  private String name;
  private Types.ActivityType Type;
  private String activityID;
  private ArrayList<Review> reviews = new ArrayList<Review>();

  public Activity(String name, Types.ActivityType Type, String activityID) {
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

  public ArrayList<Review> getReviews() {
    return reviews;
  }

  public void addReview(Review review) {
    reviews.add(review);
  }

  @Override
  public String toString() {
    return name;
  }
}
