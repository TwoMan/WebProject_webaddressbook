package loginmodule;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabean.*;
/**
 * Servlet implementation class LoginCheckAction
 */
public class LoginCheckAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheckAction() {
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
		String userid = null, questanswear = null;
		//获得request中的id，questanswear属性的数据
		userid = request.getParameter("id");
		questanswear = request.getParameter("questanswear");
		System.out.println(userid+questanswear);
		//设置好checkuserbean类中的对象
		CheckUserBean checkuserbean = new CheckUserBean();
		checkuserbean.set_id(userid);
		checkuserbean.set_questswear(questanswear);
		//把数据传到logincheckdao类的对象中进行处理返回结果
		LoginCheckDAO logincheck = new LoginCheckDAO();
		if(logincheck.checkLogin(checkuserbean)){
			//如果回答问题答案匹配，则进行成功后的后续工作处理
			System.out.println("login successful");
			HttpSession session = request.getSession(true);
			session.setAttribute("userid", userid);
			response.sendRedirect(response.encodeURL("DisplayInfoAction"));
		}
		else{
			response.sendRedirect("index.jsp");
		}
	}

}
