package qwer.qwq.service;

import java.util.List;

import qwer.qwq.domain.History;
import qwer.qwq.domain.User;

public interface UserService {
	
	void savHistory(String history_article,String history_uri,int uid);
	
	/**
	 * 通过用户名查询信息
	 * @param username
	 * @return
	 */
	User findByUsername(String username);
	
	
	/**
	 * 获取所有历史记录
	 * @param uid
	 * @return
	 */
    List<History> getHistory(int uid);
	
    
	/**
     * 注册用户
     * @param user
     * @return
     */
    boolean regist(User user);
    
    
    /**
     * 激活用户
     * @param code
     * @return
     */
    boolean active(String code);

    
    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);
}
