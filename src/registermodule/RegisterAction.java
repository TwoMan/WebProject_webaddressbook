package registermodule;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javabean.*;
/**
 * Servlet implementation class RegisterAction
 */
public class RegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		MemberInsertBean memberinsert = new MemberInsertBean();
		memberinsert.setID(request.getParameter("id"));
		memberinsert.set_name(request.getParameter("username"));
		memberinsert.set_career(request.getParameter("career"));
		memberinsert.set_currentaddress(request.getParameter("currentaddress"));
		memberinsert.set_phonenumber(request.getParameter("phonenumber"));
		memberinsert.set_workt(request.getParameter("workt"));
		memberinsert.setAnswear(request.getParameter("answer"));
		memberinsert.setQuestion(request.getParameter("question"));
		RegisterDAO register = new RegisterDAO();
		if(register.insertMember(memberinsert)){
			response.sendRedirect(response.encodeURL("index.jsp"));
		}
		else
			response.sendRedirect("error.jsp");
		
	}

}
