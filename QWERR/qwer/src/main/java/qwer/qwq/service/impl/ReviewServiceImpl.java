package qwer.qwq.service.impl;

import qwer.qwq.dao.ReviewDao;
import qwer.qwq.dao.impl.ReviewDaoImpl;
import qwer.qwq.domain.Review;
import qwer.qwq.service.ReviewService;

public class ReviewServiceImpl implements ReviewService{
	ReviewDao rd=new ReviewDaoImpl();
	@Override
	public Review getOneReviewByRandom() {
		return rd.getOneReview();
	}

}
