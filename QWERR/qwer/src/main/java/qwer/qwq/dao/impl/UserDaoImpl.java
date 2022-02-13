package qwer.qwq.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import qwer.qwq.dao.UserDao;
import qwer.qwq.domain.History;
import qwer.qwq.domain.User;
import qwer.qwq.util.JDBCUtils;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    
    public void saveUserHistory(String title,String uri,int uid) {
    	try {
            //1.定义sql
            String sql = "insert into user_history(history_article,history_uri,uid) values (?,?,?)";
            //2.执行sql
            template.update(sql,title,uri,uid);
        } catch (Exception e) {

        }
    }
    
    public User findByUsername(String username) {
        User user = null;
        try {
            //1.定义sql
            String sql = "select * from user where username = ?";
            //2.执行sql
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        } catch (Exception e) {

        }

        return user;
    }

    public void save(User user) {
        //1.定义sql
        String sql = "insert into user(username,password,telephone,email,status,code) values(?,md5(?),?,?,?,?)";
        //2.执行sql

        template.update(sql,user.getUsername(),
                    user.getPassword(),
                user.getTelephone(),
                user.getEmail(),
                user.getStatus(),
                user.getCode()
                );
    }

    /**
     * 根据激活码查询用户对象
     * @param code
     * @return
     */
    public User findByCode(String code) {
        User user = null;
        try {
            String sql = "select * from user where code = ?";

            user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),code);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return user;
    }

    /**
     * 修改指定用户激活状态
     * @param user
     */
    public void updateStatus(User user) {
        String sql = " update user set status = 'Y' where uid=?";
        template.update(sql,user.getUid());
    }

    /**
     * 根据用户名和密码查询的方法
     * @param username
     * @param password
     * @return
     */
    public User findByUsernameAndPassword(String username, String password) {
        User user = null;
        try {
            //1.定义sql
            String sql = "select * from user where username = ? and password = md5(?)";
            //2.执行sql
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username,password);
        } catch (Exception e) {

        }

        return user;
    }

	@Override
	public List<History> findAllHistory(int uid) {
		String sql = "select * from user_history where uid = ?";
        List<History> list = template.query(sql, new RowMapper<History>() {
			
            @Override
            public History mapRow(ResultSet rs, int i) throws SQLException {
            	History hs=new History();
            	String history_article=rs.getString("history_article");
            	String history_uri=rs.getString("history_uri");
            	int history_id=rs.getInt("history_id");
            	hs.setHistory_article(history_article);
            	hs.setHistory_uri(history_uri);
            	hs.setHistory_id(history_id);
                return hs;
            }
        },uid);
		return list;
	}
}