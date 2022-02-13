package qwer.qwq.service.impl;

import java.util.Date;
import java.util.List;

import qwer.qwq.dao.RecommendDao;
import qwer.qwq.dao.impl.RecommendDaoImpl;
import qwer.qwq.domain.Recommend;
import qwer.qwq.service.RecommendService;

public class RecommendServiceImpl implements RecommendService{
	
	RecommendDao recommendDao=new RecommendDaoImpl();
	
	@Override
	public List<Recommend> getRecommend(String date) {
		return recommendDao.findRecommendByDate(date);
	}

	@Override
	public List<Recommend> getHistoryRecommend() {
		// TODO Auto-generated method stub
		return recommendDao.getHistoryRecommend();
	}

	@Override
	public List<Recommend> getFourRecommend() {
		// TODO Auto-generated method stub
		return recommendDao.getFourRecommend();
	}

}
