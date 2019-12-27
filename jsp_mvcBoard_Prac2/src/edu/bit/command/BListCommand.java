package edu.bit.command;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import edu.bit.dao.BDao;
import edu.bit.dto.BDto;

public class BListCommand implements BCommand {
	
	@Override
	public void execute(HttpServlet request, HttpServletResponse response) {
		
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		
	}
}
	
