package displayinfomodule;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javabean.*;
/**
 * Servlet implementation class DisplayInfoAction
 */
public class DisplayInfoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayInfoAction() {
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
		String id = null;
		String kind = request.getParameter("kind");
		MemberInfomation memberinfo = null;
		HttpSession session = request.getSession();
		//System.out.println("displayinfoaction-----2");
		if(session.isNew() == false){
			//System.out.println("displayinfoaction-----1");
			id = (String)session.getAttribute("userid");
			DisplayInfoDAO displayinfo = new DisplayInfoDAO();
			if(kind != null && kind.equals("member")){
				UserName member = new UserName();
				member.set_memberid(request.getParameter("memberid"));
				member.set_username(request.getParameter("membername"));
				memberinfo = displayinfo.getmemberinfo(member.get_memberid());
				if(memberinfo != null){
					request.setAttribute("memberinfo", memberinfo);
					request.getRequestDispatcher("memberinfo.jsp").forward(request, response);
				}
				else
					response.sendRedirect("error.jsp");
			}			
			else{
				memberinfo = displayinfo.getmemberinfo(id);
				if(memberinfo != null){
					request.setAttribute("memberinfo", memberinfo);
					session.setAttribute("username", memberinfo.get_name());
					request.getRequestDispatcher("memberinfo.jsp").forward(request, response);
				}
				else
					response.sendRedirect("error.jsp");
			}
		}
		else
			System.out.println("displayinfoaction-----false");
	}

}
