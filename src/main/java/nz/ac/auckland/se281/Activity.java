package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Activity {
  private String name;
  private Types.ActivityType type;
  private String activityId;
  private ArrayList<Review> reviews = new ArrayList<Review>();

  public Activity(String name, Types.ActivityType type, String activityId) {
    this.name = name;
    this.type = type;
    this.activityId = activityId;
  }

  public String getName() {
    return name;
  }

  public Types.ActivityType getType() {
    return type;
  }

  public String getactivityId() {
    return activityId;
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
