package qwer.qwq.dao;

import java.util.List;

import qwer.qwq.domain.History;
import qwer.qwq.domain.User;

public interface UserDao {
	
	
	/**
	 * 查询所有历史记录并返回
	 * @return
	 */
	public List<History> findAllHistory(int uid);
	
	
	/**
	 * 保存用户历史记录
	 * @param title
	 * @param uri
	 */
	public void saveUserHistory(String title,String uri,int uid);
	
	
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public User findByUsername(String username);

    
    /**
      * 用户保存
     * @param user
     */
    public void save(User user);
    
    
    /**
     * 通过激活码查询用户
     * @param code
     * @return
     */
    User findByCode(String code);

    
    /**
     * 更新激活状态
     * @param user
     */
    void updateStatus(User user);

    
    /**
     * 通过账号密码查找用户
     * @param username
     * @param password
     * @return
     */
    User findByUsernameAndPassword(String username, String password);
    
}