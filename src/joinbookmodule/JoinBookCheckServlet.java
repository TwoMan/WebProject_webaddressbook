package joinbookmodule;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class JoinBookCheckServlet
 */
public class JoinBookCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinBookCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();		
		String province_select = null;
		String city_select = null;
		String town_select = null;
		String school_select = null;
		String age_select = null;
		String classandgrade_select = null;
		//×ª»»×Ö·û¸ñÊ½
		province_select=new String(request.getParameter("province_select").getBytes("iso-8859-1"),"gbk");
		//System.out.print(province_select);
		city_select=new String(request.getParameter("city_select").getBytes("iso-8859-1"),"gbk");
		town_select=new String(request.getParameter("town_select").getBytes("iso-8859-1"),"gbk");
		school_select=new String(request.getParameter("school_select").getBytes("iso-8859-1"),"gbk");
		age_select=new String(request.getParameter("age_select").getBytes("iso-8859-1"),"gbk");
		classandgrade_select=new String(request.getParameter("classandgrade_select").getBytes("iso-8859-1"),"gbk");
		//
		String applyquestion=null;		
		HttpSession session=request.getSession();
		if(session.isNew())
		{
			response.sendRedirect("index.jsp");
		}
		GetJoinBookQuestionDAO getjoinbookquestion = new GetJoinBookQuestionDAO();
		applyquestion = getjoinbookquestion.getJoinBookQuestion(province_select, city_select, town_select, school_select, age_select, classandgrade_select);		
		out.println(applyquestion);
	    System.out.println("JoinBookCheckServlet-----"+applyquestion);	    	
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
