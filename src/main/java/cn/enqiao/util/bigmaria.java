package cn.enqiao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class bigmaria {
	private static Logger logger = Logger.getLogger(bigmaria.class);

	String driver = "com.mysql.jdbc.Driver";
	// URL指向要访问的数据库名
	String bmurl = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_enqiaojun?useUnicode=true&characterEncoding=UTF-8";
	// MySQL配置时的用户名
	String user = "z1y5jl2mz1";
	// MySQL配置时的密码
	String password = "0k552y1444i21k5zjhjyy35kz0m44j1k1lll1wz4";

	// @constructor
	public bigmaria() {
		// 加载驱动程序
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// add link
	public int addlink(String title, String url, String topic) {
		// TODO 需要一整套前台后台判空的方法，此处仅保证入库安全。
		if (title == null) {
			title = "";
		}
		if (url == null) {
			url = "";
		}
		if (topic == null || topic.equals("")) {
			topic = "1";
		}

		try {

			// 连接数据库
			Connection conn = DriverManager
					.getConnection(bmurl, user, password);

			// statement用来执行SQL语句
			Statement statement = conn.createStatement();

			// 要执行的SQL语句
			String sql = "INSERT INTO links (title, url, user_id, isdel, topic) VALUES('"
					+ title + "', '" + url + "', null, '1', '" + topic + "');";
			statement.execute(sql);
			conn.close();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	// get link
	public StringBuffer getLinks() {
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("");
			// 连接数据库
			Connection conn = DriverManager
					.getConnection(bmurl, user, password);
			// statement用来执行SQL语句
			Statement statement = conn.createStatement();
			Statement statement0 = conn.createStatement();

			// 要执行的SQL语句
			// 金字塔部分
			String init = "select title,url,id from links order by links.click desc";
			ResultSet rs = statement.executeQuery(init);
			int i = 1, j = 1;
			sb.append("<div>");
			while (rs.next()) {
				sb.append("<a id=\"wa\" href=\"" + rs.getString("url")
						+ "\" target=\"_blank\" onClick=\"clickadd("
						+ rs.getString("id") + ")\" title=\""
						+ rs.getString("title") + "\">" + rs.getString("title")
						+ "</a>\r");
				// logger.info(rs.getString("title"));

				if (i == j) {
					sb.append("<br>");
					i -= j;
					j++;
				}
				if (j==7) break;
				i++;
			}
			sb.append("<br>");
			sb.append("</div>");
			sb.append("<br>");

			// 分类部分
			// init = "select tid,title from topic order by topic.heavy desc";
			/**
			 * select t2.title,sum(t1.click) as sumclick from links t1, topic t2
			 * where t1.topic = t2.tid group by t2.title order by sumclick desc;
			 * select t2.tid as tid,t2.title as title from links t1, topic t2
			 * where t1.topic = t2.tid group by t2.title order by sum(t1.click)
			 * desc;
			 */
			init = "select t2.tid as tid,t2.title as title from  links t1, topic t2 where t1.topic = t2.tid group by t2.title order by sum(t1.click) desc; ";
			String lint = "";// links in topic
			ResultSet rslint = null;
			rs = null;
			rs = statement.executeQuery(init);
			sb.append("<div>");

			while (rs.next()) {
				lint = "select title,url,id from links where topic = "
						+ rs.getString("tid") + " order by links.click desc";
				sb.append("<a id=\"w\" href=\"index.jsp\" target=\"_blank\" title=\""
						+ rs.getString("title")
						+ "\">"
						+ rs.getString("title")
						+ "</a>\r");
				rslint = statement0.executeQuery(lint);
				while (rslint.next()) {
					sb.append("<a id=\"wa\" href=\"" + rslint.getString("url")
							+ "\" target=\"_blank\" onClick=\"clickadd("
							+ rslint.getString("id") + ")\" title=\""
							+ rslint.getString("title") + "\">"
							+ rslint.getString("title") + "</a>\r");
				}
				sb.append("<br>");
			}
			sb.append("<br>");
			sb.append("</div>");

			rs.close();
			conn.close();
			return sb;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public void addclick(String id) {
		try {

			// 连接数据库
			Connection conn = DriverManager
					.getConnection(bmurl, user, password);

			// statement用来执行SQL语句
			Statement statement = conn.createStatement();

			// 要执行的SQL语句=
			String sql = "update links set click = click+1 where id = " + id;
			statement.execute(sql);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public StringBuffer getTopic() {
		StringBuffer sb = new StringBuffer();
		sb.append("分类ID 分类名<br>");
		// 连接数据库
		Connection conn;
		try {
			conn = DriverManager.getConnection(bmurl, user, password);

			// statement用来执行SQL语句
			Statement statement = conn.createStatement();
			String sql = "select * from topic";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()){
				sb.append(rs.getString("tid")+" "+rs.getString("title")+"<br>");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb;
	}
	
	/**
	 * @author 77
	 * @return
	 */
	
	public StringBuffer getJobs() {
		StringBuffer sb = new StringBuffer();
		// 连接数据库
		Connection conn;
		try {
			conn = DriverManager.getConnection(bmurl, user, password);
			// statement用来执行SQL语句
			Statement statement = conn.createStatement();
			String sql = "select * from jobs";
			ResultSet rs = statement.executeQuery(sql);
			sb.append("[");
			while (rs.next()){
				String title = rs.getString("title");
				String content = rs.getString("content");
				String longitude = rs.getString("longitude");
				String latitude = rs.getString("latitude");
				String isOpen = rs.getString("isOpen");
							
				sb.append("{title:\""+title+"\",content:\""+content+"\",point:\""+longitude+"|"+latitude+"\",isOpen:"+isOpen+",icon:{w:21,h:21,l:0,t:0,x:6,lb:5}}");
				sb.append(",");
				
			}
			sb.append("]");
			System.out.println("json："+sb);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sb;
	}
}










