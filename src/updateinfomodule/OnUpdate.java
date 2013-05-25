package updateinfomodule;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabean.MemberInfomation;;
/**
 * Servlet implementation class OnUpdate
 */
public class OnUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnUpdate() {
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
		//��request��ȡ���û���ص�session����Ҫ����ȡ���е�id�ã�
		HttpSession session = request.getSession();
		//System.out.println("onupdate session is null?"+session.isNew());
		//System.out.println("onupdate session��userid ?"+session.getAttribute("userid"));
		String username = request.getParameter("username");
		String phonenumber = request.getParameter("phonenumber");
		String currentaddress = request.getParameter("currentaddress");
		String career = request.getParameter("career");
		String workt = request.getParameter("workt");
		//�����������Գ�ʼ��memberinfo����
		MemberInfomation memberinfo = new MemberInfomation();
		memberinfo.set_career(career);
		memberinfo.set_currentaddress(currentaddress);
		memberinfo.set_name(username);
		memberinfo.set_phonenumber(phonenumber);
		memberinfo.set_workt(workt);
		//ʵ����UpdateInfoDAO����ִ�и������ݹ��ܣ�
		UpdateInfoDAO update = new UpdateInfoDAO();
		//����update�����updateinfo�����ķ���ֵ��ѡ�����������޸Ļ�����ʾ�޸ĳɹ���ѡ��
		if(update.updateInfo(memberinfo , (String)session.getAttribute("userid"))){
			request.getRequestDispatcher(response.encodeURL("DisplayInfoAction")).forward(request, response);
		}
		else{
			response.sendRedirect("error.jsp");
		}
	}

}
