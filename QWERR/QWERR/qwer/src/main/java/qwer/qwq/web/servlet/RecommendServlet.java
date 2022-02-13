package qwer.qwq.web.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qwer.qwq.dao.RecommendDao;
import qwer.qwq.dao.impl.RecommendDaoImpl;
import qwer.qwq.domain.Recommend;
import qwer.qwq.service.RecommendService;
import qwer.qwq.service.impl.RecommendServiceImpl;

@WebServlet("/recommend/*")
public class RecommendServlet extends BaseServlet {
	RecommendService recommendService=new RecommendServiceImpl();
	public void findRecommend(HttpServletRequest request,HttpServletResponse response) throws IOException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		System.out.print(sdf.format(date));
		List<Recommend> list=recommendService.getRecommend(sdf.format(date));
		writeValue(list, response);
	}
	public void getHistoryRecommend(HttpServletRequest request,HttpServletResponse response) throws IOException {
		List<Recommend> list=recommendService.getHistoryRecommend();
		writeValue(list, response);
	}
	public void getFourRecommend(HttpServletRequest request,HttpServletResponse response) throws IOException {
		List<Recommend> list=recommendService.getFourRecommend();
		writeValue(list, response);
	}
}
