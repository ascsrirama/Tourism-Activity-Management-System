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

    // If follow-up is not requested, set operatorResponse to "-". Otherwise, set it to null.
    if (!isFollowUpRequested) {
      this.operatorResponse = "-";
    } else {
      this.operatorResponse = null;
    }
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
  public void displayReview() {

    MessageCli.REVIEW_ENTRY_HEADER.printMessage(
        String.valueOf(rating), "5", "Private", reviewId, author);
    MessageCli.REVIEW_ENTRY_REVIEW_TEXT.printMessage(reviewText);

    // If follow-up is requested and no response, display email.
    if (isFollowUpRequested && (operatorResponse == null || operatorResponse.isEmpty())) {
      MessageCli.REVIEW_ENTRY_FOLLOW_UP.printMessage(email);
    }
    // If there's an operator response or if it's been marked as resolved (operatorResponse = "-")
    else {
      MessageCli.REVIEW_RESOLVED.printMessage("Resolved: \"" + operatorResponse + "\"");
    }
  }
}
