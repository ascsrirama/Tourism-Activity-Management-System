package nz.ac.auckland.se281;

public class PublicReview extends Review {
  private boolean isAnonymous;
  private boolean isEndorsed;

  public PublicReview(
      String author,
      String reviewId,
      int rating,
      String reviewText,
      boolean isAnonymous,
      boolean isEndorsed) {

    super(author, reviewId, reviewText, rating);
    this.isAnonymous = isAnonymous;
    this.isEndorsed = false;
  }

  public boolean isAnonymous() {
    return isAnonymous;
  }

  public void setAnonymous(boolean isAnonymous) {
    this.isAnonymous = isAnonymous;
  }

  public boolean isEndorsed() {
    return isEndorsed;
  }

  public void setEndorsed(boolean isEndorsed) {
    this.isEndorsed = isEndorsed;
  }

  @Override
  public void displayReview() {
    MessageCli.REVIEW_ENTRY_HEADER.printMessage(String.valueOf(rating),"5", "Public", reviewId, author);
    MessageCli.REVIEW_ENTRY_REVIEW_TEXT.printMessage(reviewText);
  }
}
