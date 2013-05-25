package listmodule;

import java.io.IOException;
import java.util.ArrayList;

import javabean.UserSchool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ClassListAction
 */
public class ClassListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassListAction() {
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
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("userid");
		if(userid != null){
			ClassListDAO classlist = new ClassListDAO();
			ArrayList<UserSchool> schoolarraylist = null;
			schoolarraylist = classlist.getUserSchoolList(userid);
			request.setAttribute("schoolarraylist", schoolarraylist);
			request.getRequestDispatcher("classlist.jsp").forward(request, response);
		}
		else 
			response.sendRedirect("error.jsp");
	}

}
