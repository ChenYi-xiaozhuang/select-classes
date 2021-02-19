package testDB;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDB {

	public static void main(String[] args) throws SQLException {
		//加载Spring配置文件，启动spring
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		System.out.println(ac);
		
		//获取datasource对象
		BasicDataSource ds=ac.getBean("dataSource",BasicDataSource.class);
		
		//从ds中获取连接
		Connection conn=ds.getConnection();
		System.out.println(conn);
	}
}
