package nz.ac.auckland.se281;

public class PrivateReview extends Review {
  private String email;
  private boolean isFollowUpRequested;
  private String operatorResponse;

  public PrivateReview(
      String author,
      String reviewId,
      int rating,
      String reviewText,
      String email,
      boolean isFollowUpRequested) {
    super(author, reviewId, reviewText, rating);
    this.email = email;
    this.isFollowUpRequested = isFollowUpRequested;
    this.operatorResponse = "-";
  }

  // Getters and Setters
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean isFollowUpRequested() {
    return isFollowUpRequested;
  }

  public void setFollowUpRequested(boolean isFollowUpRequested) {
    this.isFollowUpRequested = isFollowUpRequested;
  }

  public String getOperatorResponse() {
    return operatorResponse;
  }

  public void setOperatorResponse(String operatorResponse) {
    this.operatorResponse = operatorResponse;
  }

  @Override
  public void displayReview() {}
}
