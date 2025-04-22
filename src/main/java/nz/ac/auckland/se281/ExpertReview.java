package nz.ac.auckland.se281;

import java.util.ArrayList;

public class ExpertReview extends Review {
  private boolean isRecommended;

  private ArrayList<String> images;

  public ExpertReview(
      String author, String reviewId, int rating, String reviewText, boolean isRecommended) {
    super(author, reviewId, reviewText, rating);
    this.isRecommended = isRecommended;
     this.images = new ArrayList<String>();
  }

  public void addImage(String imageName) {
    this.images.add(imageName);
  }

  public ArrayList<String> getImages() {
    return this.images;
  }

  public boolean isRecommended() {
    return isRecommended;
  }

  public void setRecommended(boolean isRecommended) {
    this.isRecommended = isRecommended;
  }

  @Override
  public void displayReview() {
    MessageCli.REVIEW_ENTRY_HEADER.printMessage(
        String.valueOf(rating), "5", "Expert", reviewId, author);
    MessageCli.REVIEW_ENTRY_REVIEW_TEXT.printMessage(reviewText);
    if (isRecommended) {
      MessageCli.REVIEW_ENTRY_RECOMMENDED.printMessage("Recommended");
    }
  }
}
