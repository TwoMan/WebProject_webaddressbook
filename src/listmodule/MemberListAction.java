package listmodule;

import java.io.IOException;
import java.util.ArrayList;
import javabean.UserName;
import javabean.UserSchool;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberListAction
 */
public class MemberListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListAction() {
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
		UserSchool schoolselect = new UserSchool();
		//初始化school_select对象
		schoolselect.set_age(request.getParameter("age"));
		schoolselect.set_city(request.getParameter("city"));
		schoolselect.set_class_and_grade(request.getParameter("class_and_grade"));
		schoolselect.set_province(request.getParameter("province"));
		schoolselect.set_school(request.getParameter("school"));
		schoolselect.set_town(request.getParameter("town"));
		System.out.println(request.getParameter("province"));
		//
		MemberListDAO memberlistdao = new MemberListDAO();
		ArrayList<UserName> arraylist = null;
		arraylist = memberlistdao.getMemberListArrayList(schoolselect);
		if(arraylist != null){
			request.setAttribute("arraylist", arraylist);
			request.getRequestDispatcher("memberlist.jsp").forward(request, response);
		}
		else
			response.sendRedirect("error.jsp");
	}

}
