package nz.ac.auckland.se281;

public class PublicReview extends Review {
  private boolean isAnonymous;
  private boolean isEndorsed;

  public PublicReview(
      String author,
      String reviewId,
      int rating,
      String comment,
      boolean isAnonymous,
      String isEndorsed) {

    super(author, reviewId, comment, rating);
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
  public void displayReview() {}
}
