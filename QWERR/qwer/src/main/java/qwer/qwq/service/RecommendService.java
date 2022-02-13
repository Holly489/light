package qwer.qwq.service;

import java.util.Date;
import java.util.List;

import qwer.qwq.domain.Recommend;

public interface RecommendService {
	/**
	 * 获得每日推荐
	 * @return
	 */
	List<Recommend> getRecommend(String date);
	List<Recommend> getHistoryRecommend();
	List<Recommend> getFourRecommend();
}
