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
		request.setCharacterEncoding("EUC-KR");//한글 인코딩
		
		String viewPage = null;//dispatcher를 위한 인자.
		BCommand command = null;//Model쪽의 Command. FrontController가 BCommand 객체를 생성했다.
								//참고로 BCommand는 모든 command들이 따를 인터페이스이다.
		
		String uri = request.getRequestURI();//요청받은곳의 전체URI를 뽑아서 uri에 넣음
		String conPath = request.getContextPath();//요청받은곳에서 ContextPath를 받음.
		String com = uri.substring(conPath.length());
		//전체 uri에서 컨텍스트페스를 제외한 부분을 가져옴.그래서 맨 뒤의 .jsp나 .do등이 올수있는것.
		
		if(com.equals("/list.do")) {
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
		}
		
	}

}
