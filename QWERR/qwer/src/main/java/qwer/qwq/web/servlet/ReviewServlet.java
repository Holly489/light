package qwer.qwq.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qwer.qwq.domain.Review;
import qwer.qwq.service.ReviewService;
import qwer.qwq.service.impl.ReviewServiceImpl;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/review/*")
public class ReviewServlet extends BaseServlet {
	private ReviewService reviewService=new ReviewServiceImpl();
/*	static String string2Json(String s) {     
	    StringBuffer sb = new StringBuffer ();     
	    for (int i=0; i<s.length(); i++) {     
	   
	        char c = s.charAt(i);     
	        switch (c) {     
	        case '\"':     
	            sb.append("\\\"");     
	            break;     
	        case '\\':     
	            sb.append("\\\\");     
	            break;     
	        case '/':     
	            sb.append("\\/");     
	            break;     
	        case '\b':     
	            sb.append("\\b");     
	            break;     
	        case '\f':     
	            sb.append("\\f");     
	            break;     
	        case '\n':     
	            sb.append("\\n");     
	            break;     
	        case '\r':     
	            sb.append("\\r");     
	            break;     
	        case '\t':     
	            sb.append("\\t");     
	            break;     
	        default:     
	            sb.append(c);     
	    }     
	 }
	 return sb.toString();
  }*/
	public void getReview(HttpServletRequest request,HttpServletResponse response){
		Review review=reviewService.getOneReviewByRandom();
		try {
			writeValue(review, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
