package nz.ac.auckland.se281;

public abstract class Review {
  protected String author;
  protected String reviewId;
  protected String comment;
  protected int rating;

  public Review(String author, String reviewId, String comment, int rating) {
    this.author = author;
    this.reviewId = reviewId;
    this.comment = comment;
    this.rating = rating;
  }

  public String getReviewId() {
    return reviewId;
  }

  public abstract void displayReview();
}
