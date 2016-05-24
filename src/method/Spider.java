package method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import bean.ArticleBean;

public class Spider {

	public static void getTopUserInfo(String url) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		String mySqlUrl = "jdbc:mysql://localhost:3306/article-spider";
		String username = "root";
		String password = "root";

		Connection con = DriverManager.getConnection(mySqlUrl, username, password);

		Statement stmt = con.createStatement();

		ArticleBean article = new ArticleBean(url);

		System.out.println(article);

		String sql = "INSERT INTO content(title,content)" + " VALUES('" + article.getTitle() + "','"
				+ article.getContent() + "')";

		stmt.executeUpdate(sql);
		System.out.println("信息存入数据库成功！");
		System.out.println();
	}
}
