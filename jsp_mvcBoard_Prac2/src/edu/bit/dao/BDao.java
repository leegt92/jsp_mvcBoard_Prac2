package edu.bit.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BDao {
	DataSource dataSource;//커넥션풀. 객체가 생성될때 생성자에 바로 넣는게 가장 좋다.
	
	public BDao() {
		try {
			Context context = new InitialContext();
			//context는 xml에서 가져왓다. 커넥션풀 사용을 위해 xml에 미리 넣어놧기때문
			//서버에 설정된 context를 메모리에 올리면 메모리가 커넥션풀을 생성함
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<DBtp>

}
