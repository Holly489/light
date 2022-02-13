package qwer.qwq.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import qwer.qwq.dao.UserDao;
import qwer.qwq.dao.impl.UserDaoImpl;
import qwer.qwq.domain.History;
import qwer.qwq.domain.User;
import qwer.qwq.service.UserService;
import qwer.qwq.util.Insertion_Image_QRCodeUtil;
import qwer.qwq.util.JedisUtil;
import qwer.qwq.util.MailUtils;
import qwer.qwq.util.SendMail;
import qwer.qwq.util.UuidUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;


public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    
    
    /**
     * 注册用户
     * @param user
     * @return
     */
    public boolean regist(User user) {
        //1.根据用户名查询用户对象
        User u = userDao.findByUsername(user.getUsername());
        //判断u是否为null
        if(u != null){
            //用户名存在，注册失败
            return false;
        }
        //2.保存用户信息
        //2.1设置激活码，唯一字符串
        user.setCode(UuidUtil.getUuid());
        //2.2设置激活状态
        user.setStatus("N");
        userDao.save(user);
        String content="<!DOCTYPE html>\r\n" + 
				"<html lang=\"en\">\r\n" + 
				"\r\n" + 
				"<head>\r\n" + 
				"    <meta charset=\"UTF-8\">\r\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n" + 
				"    <title>LIGHT</title>\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body>\r\n" + 
				"    <div style=\"width: 100%;background-color: rgb(240, 238, 231);padding: 30px 0;\">\r\n" + 
				"        <div style=\"width: 544px;padding: 28px;margin: 0 auto;background: #fff;\">\r\n" + 
				"            <div style=\" padding: 20px; margin-bottom: 20px; font-size: 26px; line-height: 34px; font-family: roboto, tahoma, sans-serif; text-align: left;\">网页版和手机客户端接近准备就绪，微信小程序也快了</div>\r\n" + 
				"            <div style=\"text-align: center;\"><img src=\"cid:a00000001\" alt=\"\" style=\" width: 250px;\"></div>\r\n" + 
				"            <div style=\"text-align: justify;font-size: 15px;padding: 23px;color: #919191;\">书是灯，读书照亮了前面的路；书是桥，读书接通了彼此的岸；书是帆，读书推动了人生的船。读书是一门人生的艺术，因为读书，人生才更精彩！</div>\r\n" + 
				"            <div style=\"margin: 10px;text-align: center;\">开始读书吧！</div>\r\n" + 
				"            <a href='\"+user.getCode()+\"'><div style=\"display: block;width: 95px;padding: 10px;margin: 0 auto;margin-bottom: 16px;background-color: #1e262d;color: white;font-size: 24px;text-align: center;\">LIGHT</div></a>\r\n" + 
				"            <div style=\"text-align: center;font-size: 12px;color: #b6b6b6;\">点击LIGHT即可激活</div>\r\n" + 
				"        </div>\r\n" + 
				"    </div>\r\n" + 
				"</body>\r\n" + 
				"\r\n" + 
				"</html>";
		
		Map<String,String> map=new HashMap<String,String>();
		
		//邮件服务器主机名(smtp服务器地址)
		//如：qq的smtp服务器地址：smtp.qq.com
		map.put("smtp", "smtp.qq.com");
		//邮件传输协议：如smtp
		map.put("protocol", "smtp");
		//登录邮箱的用户名
		map.put("username", "1031652416@qq.com");
		//登录邮箱的密码
		map.put("password", "ikwfkqleaqvlbdhg");
		//发送人的帐号
		map.put("from", "1031652416@qq.com");
		//接收人的帐号，多个以","号隔开
		map.put("to", user.getEmail());
		//邮件主题
		map.put("subject", "LIGHT 为乐趣而读书");
		//邮件内容
		map.put("body", content);
		
		//内嵌了多少张图片，如果没有，则new一个不带值的Map
		Map<String,String> image=new HashMap<String,String>();
		image.put("a00000001", "C:/QWERR/qwer/WebContent/img/LIGHT1.jpg");
		//image.put("a00000002", "C:/QWERR/qwer/WebContent/img/LIGHT2.jpg");
		
		//附件的绝对路径,不发附件则new一个不带值的List
		List<String> list=new ArrayList<String>();
		
		//创建实例
		SendMail sm=new SendMail(map,list,image);
		//执行发送
		try {
			sm.send();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return true;
    }

    
    /**
     * 激活用户
     * @param code
     * @return
     */
    public boolean active(String code) {
        //1.根据激活码查询用户对象
        User user = userDao.findByCode(code);
        if(user != null){
            //2.调用dao的修改激活状态的方法
            userDao.updateStatus(user);
            return true;
        }else{
            return false;
        }
    }

    
    /**
     * 用户登录
     */
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }


	/**
	 * 获得用户的历史记录
	 */
	public List<History> getHistory(int uid) {
		List<History> hs=userDao.findAllHistory(uid);
		return hs;
	}

	public static void main(String[] args) {
		UserService service=new UserServiceImpl();
		List<History> hs=service.getHistory(1);
		for(History history : hs) {
			    System.out.println(history);
			}
	}


	/**
	 * 保存用户历史记录
	 */
	public void savHistory(String history_article, String history_uri, int uid) {
		userDao.saveUserHistory(history_article, history_uri, uid);
	}


	/**
	 * 通过用户名查询信息
	 */
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUsername(username);
	}
}
