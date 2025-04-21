package nz.ac.auckland.se281;

import java.util.List;

public class ExpertReview extends Review {
  private boolean isRecommended;
  private List<String> images;

  public ExpertReview(
      String author,
      String reviewId,
      int rating,
      String reviewText,
      boolean isRecommended,
      List<String> images) {
    super(author, reviewId, reviewText, rating);
    this.isRecommended = isRecommended;
    this.images = images;
  }

  public boolean isRecommended() {
    return isRecommended;
  }

  public void setRecommended(boolean isRecommended) {
    this.isRecommended = isRecommended;
  }

  public List<String> getImages() {
    return images;
  }

  public void setImages(List<String> images) {
    this.images = images;
  }

  @Override
  public void displayReview() {}
}
