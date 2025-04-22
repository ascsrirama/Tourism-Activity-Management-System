package nz.ac.auckland.se281;

public abstract class Review {
  protected String author;
  protected String reviewId;
  protected String reviewText;
  protected int rating;

  public Review(String author, String reviewId, String reviewText, int rating) {
    this.author = author;
    this.reviewId = reviewId;
    this.reviewText = reviewText;
    this.rating = rating;
  }

  public String getReviewId() {
    return reviewId;
  }

  public int getRating() {
    return rating;
  }

  public abstract void displayReview();
}
