package edu.bit.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BDao {
	DataSource dataSource;//Ŀ�ؼ�Ǯ. ��ü�� �����ɶ� �����ڿ� �ٷ� �ִ°� ���� ����.
	
	public BDao() {
		try {
			Context context = new InitialContext();
			//context�� xml���� �����Ӵ�. Ŀ�ؼ�Ǯ ����� ���� xml�� �̸� �־�J�⶧��
			//������ ������ context�� �޸𸮿� �ø��� �޸𸮰� Ŀ�ؼ�Ǯ�� ������
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<DBtp>

}
