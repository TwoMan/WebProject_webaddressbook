package joinbookmodule;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinbookAction
 */
public class JoinbookAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinbookAction() {
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
		String create = request.getParameter("create");
		//如果这个问题是旧的，则判断为是申请加入已有的通讯组里，则跳转到旧的处理机制里面
		if(request.getParameter("oldquestionanswer")!=null||create!=null&&create.equals("old")){
			request.getRequestDispatcher(response.encodeURL("JoinBookOldGroup")).forward(request, response);
		}
		//如果这个问题是新的问题，则说明，该人创建了新的通讯组，则跳转到新的处理机制里面
		if(request.getParameter("newapplyquestion")!=null||create!=null&&create.equals("new")){
			request.getRequestDispatcher(response.encodeURL("JoinBookNewGroup")).forward(request, response);
		}			
	}

}
