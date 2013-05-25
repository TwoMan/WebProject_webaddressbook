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
		//�����������Ǿɵģ����ж�Ϊ������������е�ͨѶ�������ת���ɵĴ����������
		if(request.getParameter("oldquestionanswer")!=null||create!=null&&create.equals("old")){
			request.getRequestDispatcher(response.encodeURL("JoinBookOldGroup")).forward(request, response);
		}
		//�������������µ����⣬��˵�������˴������µ�ͨѶ�飬����ת���µĴ����������
		if(request.getParameter("newapplyquestion")!=null||create!=null&&create.equals("new")){
			request.getRequestDispatcher(response.encodeURL("JoinBookNewGroup")).forward(request, response);
		}			
	}

}
