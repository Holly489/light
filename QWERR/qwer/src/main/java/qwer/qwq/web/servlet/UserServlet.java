package qwer.qwq.web.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import qwer.qwq.domain.History;
import qwer.qwq.domain.ResultInfo;
import qwer.qwq.domain.User;
import qwer.qwq.service.UserService;
import qwer.qwq.service.impl.UserServiceImpl;
import qwer.qwq.util.Insertion_Image_QRCodeUtil;
import qwer.qwq.util.MailUtils;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
	private UserService userService = new UserServiceImpl();
	
	
	
	/**
	 * 获取二维码
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws IOException
	 */
	public void qrCode(HttpServletRequest request,HttpServletResponse response) throws IOException, IOException {
		User user=(User)request.getSession().getAttribute("User");
		String code=user.getCode();
		//BufferedImage buffImg = ImageIO.read(new FileInputStream("D:\\Qwer\\qwer\\WebContent\\img\\QR.jpg"));
		BufferedImage buffImg = ImageIO.read(new FileInputStream("C:\\QWERR\\qwer\\WebContent\\img\\"+user.getCode()+".jpg"));
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
		ServletOutputStream sos = response.getOutputStream();
		ImageIO.write(buffImg, "jpeg", sos);
        sos.close();
	}
	
	
	/**
	 * 注册成功后判断是否激活，如果没有激活就保持在注册成功页面
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	public void regist_OK(HttpServletRequest request,HttpServletResponse response) throws IOException {
		//String active=(String)request.getSession().getAttribute("ACTIVE");
		User user=(User)request.getSession().getAttribute("User");
		System.out.println(user);
		User u=userService.findByUsername(user.getUsername());
		System.out.println(u);
		ResultInfo info=new ResultInfo();
		if("Y".equals(u.getStatus())) {
			info.setFlag(true);
			writeValue(info, response);
		}
		else {
			info.setFlag(false);
			writeValue(info, response);
		}
	}
	
	/**
	 * 保存用户历史记录
	 * @param request
	 * @param response
	 */
	public void saveHistory(HttpServletRequest request,HttpServletResponse response) {
		User user=(User)request.getSession().getAttribute("user");
		String history_article=request.getParameter("article");
		String history_uri=request.getParameter("uri");
		int uid=user.getUid();
		userService.savHistory(history_article, history_uri, uid);
	}
	
	
	/**
	 * 获取用户历史记录
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void history(HttpServletRequest request,HttpServletResponse response) throws IOException {
		User user=(User)request.getSession().getAttribute("user");
		if(user!=null) {
			List<History> hs=userService.getHistory(user.getUid());
			writeValue(hs,response);
		}
		else {
			ResultInfo info = new ResultInfo();
			info.setErrorMsg("没有历史浏览记录");
			info.setFlag(false);
			info.setData(null);
			writeValue(info,response);
		}
	}
	
	
	/**
	 * 退出功能
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.销毁session
        request.getSession().invalidate();
        //2.跳转登录页面
        response.sendRedirect(request.getContextPath()+"/index.html");
    }
	
	
	/**
	 * 激活码功能
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void activeCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取激活码
        String code = request.getParameter("code");
        if(code != null){
            //2.调用service完成激活
            UserService service = new UserServiceImpl();
            boolean flag = service.active(code);
            //3.判断标记
            String msg = null;
            if(flag){
                //激活成功
                msg = "激活成功，请<a href=http://106.15.94.131/qwer/html/login.html>登录</a>";
                response.sendRedirect(request.getContextPath()+"/html/login.html");
            }else{
                //激活失败
                msg = "激活失败，请联系管理员!";
            }
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(msg);
        }
    }
	
	
	/**
	 * 验证码功能
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
    public void checkCode(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//服务器通知浏览器不要缓存
		response.setHeader("pragma","no-cache");
		response.setHeader("cache-control","no-cache");
		response.setHeader("expires","0");
		//在内存中创建一个长80，宽30的图片，默认黑色背景
		//参数一：长
		//参数二：宽
		//参数三：颜色
		int width = 80;
		int height = 30;
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		//获取画笔
		Graphics g = image.getGraphics();
		//设置画笔颜色为灰色
		g.setColor(new Color(68, 68, 68));
		//填充图片
		g.fillRect(0,0, width,height);
		//产生4个随机验证码，12Ey
		String checkCode = getCheckCode();
		//将验证码放入HttpSession中
		request.getSession().setAttribute("CHECKCODE_SERVER",checkCode);
		//设置画笔颜色为黄色
		g.setColor(Color.white);
		//设置字体的小大
		g.setFont(new Font("黑体",Font.BOLD,24));
		//向图片上写入验证码
		g.drawString(checkCode,15,25);
		//将内存中的图片输出到浏览器
		//参数一：图片对象
		//参数二：图片的格式，如PNG,JPG,GIF
		//参数三：图片输出到哪里去
		ImageIO.write(image,"PNG",response.getOutputStream());
	}
	/**
	 * 产生4位随机字符串 
	 */
	private String getCheckCode() {
		String base = "0123456789ABCDEFGHIJKRMNOPQRSTUVWXYZabcdefghijkrmnopqrstuvwxyz";
		int size = base.length();
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i=1;i<=4;i++){
			//产生0到size-1的随机值
			int index = r.nextInt(size);
			//在base字符串中获取下标为index的字符
			char c = base.charAt(index);
			//将c放入到StringBuffer中去
			sb.append(c);
		}
		return sb.toString();
	}
	
	
	/**
	 * 登录功能
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//验证校验
		ResultInfo info=new ResultInfo();
    	String check=request.getParameter("checkCode");
    	//从session中获取验证码
    	HttpSession session=request.getSession();
    	String checkcode_server=(String)session.getAttribute("CHECKCODE_SERVER");
    	session.removeAttribute("CHECKCODE_SERVER");
    	//比较验证码
    	if(checkcode_server==null||!checkcode_server.equalsIgnoreCase(check)) {
    		//验证码错误
    		//注册失败提示信息
    		info.setFlag(false);
    		info.setErrorMsg("验证码错误!");
    		writeValue(info, response);
    		return;
    	}
    	Map<String, String[]> map = request.getParameterMap();
        //2.封装User对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user);
        //3.调用Service查询
        User u  = userService.login(user);
        //4.判断用户对象是否为null
        if(u == null){
            //用户名密码或错误
            info.setFlag(false);
            info.setErrorMsg("用户名密码或错误");
        }
        //5.判断用户是否激活
        if(u != null && !"Y".equals(u.getStatus())){
            //用户尚未激活
            info.setFlag(false);
            info.setErrorMsg("您尚未激活，请激活");
        }
        //6.判断登录成功
        if(u != null && "Y".equals(u.getStatus())){
            request.getSession().setAttribute("user",u);//登录成功标记
            //登录成功
            info.setFlag(true);
        }
        //响应数据
        writeValue(info, response);
    }
	
	
	/**
	 * 注册功能
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
    public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//验证校验
    	ResultInfo info=new ResultInfo();
    	String check=request.getParameter("checkCode");
    	System.out.println(check);
    	//从session中获取验证码
    	HttpSession session=request.getSession();
    	String checkcode_server=(String)session.getAttribute("CHECKCODE_SERVER");
    	System.out.println(checkcode_server);
    	session.removeAttribute("CHECKCODE_SERVER");
    	//比较验证码
    	if(checkcode_server==null||!checkcode_server.equalsIgnoreCase(check)) {
    		//验证码错误
    		//注册失败提示信息
    		info.setFlag(false);
    		info.setErrorMsg("验证码错误!");
    		writeValue(info, response);
    		return;
    	}
        //1.获取数据
        Map<String, String[]> map = request.getParameterMap();
        //2.封装对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user);
        //3.调用service完成注册
        UserService service = new UserServiceImpl();
        boolean flag = service.regist(user);
        request.getSession().setAttribute("User", user);
        System.out.print(flag);
        //4.响应结果
        if(flag){
            //注册成功
            info.setFlag(true);
            /*String content="<a href='https://106.15.94.131/qwer/user/activeUser?code="+user.getCode()+"'>点击激活【Light】</a>";
            MailUtils.sendMail(user.getEmail(),content,"Light激活邮件");*/
            // 存放在二维码中的内容
            String text = "http://106.15.94.131/qwer/user/activeCode?code="+user.getCode();
            // 嵌入二维码的图片路径
            String imgPath = "C:\\QWERR\\qwer\\WebContent\\img\\qwer.jpg";
            // 生成的二维码的路径及名称
            String destPath = "C:\\QWERR\\qwer\\WebContent\\img\\"+user.getCode()+".jpg";
            //生成二维码
    		try {
    			Insertion_Image_QRCodeUtil.encode(text, imgPath, destPath, true);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
        }else{
            //注册失败
            info.setFlag(false);
            info.setErrorMsg("注册失败!");
        }
        writeValue(info, response);
    }
}
