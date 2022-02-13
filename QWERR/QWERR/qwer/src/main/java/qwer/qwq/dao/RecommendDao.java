package qwer.qwq.dao;

import java.util.Date;
import java.util.List;

import qwer.qwq.domain.Recommend;

public interface RecommendDao {
	/**
	 * 通过日期查询今天的每日推荐
	 * @return
	 */
	List<Recommend> findRecommendByDate(String string);
	/**
	 * 获取以往每日推荐
	 * @return
	 */
	List<Recommend> getHistoryRecommend();
	List<Recommend> getFourRecommend();
}