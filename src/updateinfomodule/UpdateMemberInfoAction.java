package updateinfomodule;

import java.io.IOException;

import javabean.UserName;
import javabean.MemberInfomation;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import displayinfomodule.DisplayInfoDAO;

/**
 * Servlet implementation class UpdateMemberInfoAction
 */
public class UpdateMemberInfoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberInfoAction() {
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
		//构造一个username实体，方面从数据库中提取出与username先关的实体模型数据；
		HttpSession session = request.getSession();
		UserName username = new UserName();
		username.set_memberid(session.getAttribute("userid").toString());
		//调用displayinfomodule中的*dao对象，获取用户准备修改的信息
		DisplayInfoDAO displayinfodao = new DisplayInfoDAO();
		MemberInfomation memberinfo = displayinfodao.getmemberinfo(username.get_memberid());
		if(memberinfo != null){
			request.setAttribute("memberinfo", memberinfo);
			System.out.println(memberinfo.get_career());
			request.getRequestDispatcher(response.encodeURL("updateinfo.jsp")).forward(request, response);
		}
		else
			response.sendRedirect("index.jsp");
	}

}
