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
		//���request�е�id��questanswear���Ե�����
		userid = request.getParameter("id");
		questanswear = request.getParameter("questanswear");
		System.out.println(userid+questanswear);
		//���ú�checkuserbean���еĶ���
		CheckUserBean checkuserbean = new CheckUserBean();
		checkuserbean.set_id(userid);
		checkuserbean.set_questswear(questanswear);
		//�����ݴ���logincheckdao��Ķ����н��д����ؽ��
		LoginCheckDAO logincheck = new LoginCheckDAO();
		if(logincheck.checkLogin(checkuserbean)){
			//����ش������ƥ�䣬����гɹ���ĺ�����������
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
