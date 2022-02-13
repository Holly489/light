package qwer.qwq.web.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qwer.qwq.domain.Article;
import qwer.qwq.domain.Book;
import qwer.qwq.service.ArticleService;
import qwer.qwq.service.BookService;
import qwer.qwq.service.impl.ArticleServiceImpl;
import qwer.qwq.service.impl.BookServiceImpl;


@WebServlet("/article/*")
public class ArticleServlet extends BaseServlet {
	ArticleService articleService=new ArticleServiceImpl();
	public void getArticle(HttpServletRequest request, HttpServletResponse response) {
		List<Article> list=articleService.getArticle();
		try {
			writeValue(list, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void saveArticle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String data = request.getParameter("data");
		String article_title=request.getParameter("book_title");
		String article_img_uri=request.getParameter("book_img_uri");
		String article_content=request.getParameter("book_content");
		String article_author=request.getParameter("book_author");
        System.out.println(data);
        String savePath = "C:/upload";  //存储路径
        File file = new File(savePath);
        if(!file.exists()){
            file.mkdirs();
        }
        FileWriter out = new FileWriter(savePath+"/"+article_title+".md");
        out.write(data);
        out.flush();
        out.close();
/*        Book book=new Book();
        book.setBook_author(book_author);
        book.setBook_content(book_content);
        book.setBook_img_uri(book_img_uri);
        book.setBook_title(book_title);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		book.setBook_date(date);
		bookService.saveBook(book);*/
        Article article=new Article();
        article.setArticle_author(article_author);
        article.setArticle_content(article_content);
        article.setArticle_img_uri(article_img_uri);
        article.setArticle_title(article_title);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		article.setArticle_date(date);
		articleService.saveArticle(article);
        response.getWriter().write("success");
	}
	public void getMarkdown(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String book_title=request.getParameter("book_title");
		System.out.println(book_title);
		Reader reader=new FileReader("C:/upload/"+book_title+".md");  
	    //构建高效流对象  
		BufferedReader buffReader=new BufferedReader(reader);  
		//2、读取一行字符串  
		String line=buffReader.readLine();  
		StringBuffer buffer=new StringBuffer();  
		while(line!=null){  
			buffer.append(line);  
			line=buffReader.readLine();  
		}  
		//3、关闭流  
		buffReader.close();  
		reader.close(); 
		writeValue(buffer, response);
	}
}
