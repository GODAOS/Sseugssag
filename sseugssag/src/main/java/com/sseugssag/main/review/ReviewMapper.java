package com.sseugssag.main.review;

import java.util.List;

public interface ReviewMapper {
	
	public abstract int writeReview(Review r);
	
	public abstract int getAllReviewCount();
	
	public abstract int getSearchRvCount(ReviewSelector rsel);
	
	public abstract List<Review> getRv(ReviewSelector rsel);
	
	public abstract int deleteRv(Review r);
	
	public abstract int updateRv(Review r);

	public abstract int checkStar(Review r);

	//public abstract int checkStar(String string);
}
