package qwer.qwq.dao;

import qwer.qwq.domain.Review;

public interface ReviewDao {
	/**
	 * 随机获取一条影评
	 * @return
	 */
	public Review getOneReview();
}