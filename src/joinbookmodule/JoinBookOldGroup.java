package joinbookmodule;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javabean.UserSchoolViewBean;
/**
 * Servlet implementation class JoinBookOldGroup
 */
public class JoinBookOldGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinBookOldGroup() {
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
		UserSchoolViewBean userschoolviewbean = new UserSchoolViewBean();
		userschoolviewbean.setAge(request.getParameter("age_select"));
		userschoolviewbean.setCity(request.getParameter("city_select"));
		userschoolviewbean.setClass_And_Grade(request.getParameter("class_grade_select"));
		userschoolviewbean.setId((String) session.getAttribute("userid"));
		userschoolviewbean.setProvince(request.getParameter("province_select"));
		userschoolviewbean.setSchool(request.getParameter("school_select"));
		userschoolviewbean.setTown(request.getParameter("town_select"));
		userschoolviewbean.setUserName((String) session.getAttribute("username"));
		JoinBookDAO joinbook = new JoinBookDAO();
		//如果插入正常，则跳转到List.jsp页面去，否则出错页面
		if(joinbook.insertUserSchoolView(userschoolviewbean)){
			request.getRequestDispatcher(response.encodeURL("ClassListAction")).forward(request, response);
		}
		else{
			response.sendRedirect("error.jsp");
		}
		
	}

}
