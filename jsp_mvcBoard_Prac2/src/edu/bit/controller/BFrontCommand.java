package edu.bit.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.bit.command.BCommand;
import edu.bit.command.BListCommand;

/**
 * Servlet implementation class BFrontCommand
 */
@WebServlet("*.do")
public class BFrontCommand extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontCommand() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");//�ѱ� ���ڵ�
		
		String viewPage = null;//dispatcher�� ���� ����.
		BCommand command = null;//Model���� Command. FrontController�� BCommand ��ü�� �����ߴ�.
								//����� BCommand�� ��� command���� ���� �������̽��̴�.
		
		String uri = request.getRequestURI();//��û�������� ��üURI�� �̾Ƽ� uri�� ����
		String conPath = request.getContextPath();//��û���������� ContextPath�� ����.
		String com = uri.substring(conPath.length());
		//��ü uri���� ���ؽ�Ʈ�佺�� ������ �κ��� ������.�׷��� �� ���� .jsp�� .do���� �ü��ִ°�.
		
		if(com.equals("/list.do")) {
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
		}
		
	}

}
