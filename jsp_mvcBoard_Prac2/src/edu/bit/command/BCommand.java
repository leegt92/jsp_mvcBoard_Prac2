package edu.bit.command;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

public interface BCommand {
	void execute(HttpServlet request, HttpServletResponse response);

}
