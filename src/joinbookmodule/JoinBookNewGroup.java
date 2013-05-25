package joinbookmodule;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabean.UserSchoolViewBean;
import javabean.SelectInfoViewBean;
/**
 * Servlet implementation class JoinBookNewGroup
 */
public class JoinBookNewGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinBookNewGroup(){
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
		String province_select = null, province_select_input = null;
		String city_select = null, city_select_input = null;
		String town_select = null, town_select_input = null;
		String school_select = null, school_select_input = null;
		String age_select = null, age_select_input = null;
		String class_grade_select = null, classandgrade_select_input = null;
		String id = null,username = null;
		String newapplyquestion=null, newquestionanswer=null;
		//
		HttpSession session = request.getSession();
		UserSchoolViewBean userschoolviewbean = new UserSchoolViewBean();
		SelectInfoViewBean selectinfoviewbean = new SelectInfoViewBean();
		//
		newapplyquestion = request.getParameter("newapplyquestion");		
		newquestionanswer = request.getParameter("newquestionanswer");
		
		province_select = request.getParameter("province_select");
		city_select = request.getParameter("city_select");
		town_select = request.getParameter("town_select");
		school_select = request.getParameter("school_select");
		age_select = request.getParameter("age_select");
		class_grade_select = request.getParameter("class_grade_select");
		
		province_select_input = request.getParameter("province_select_input");
		city_select_input = request.getParameter("city_select_input");
		town_select_input = request.getParameter("town_select_input");
		school_select_input = request.getParameter("school_select_input");
		age_select_input = request.getParameter("age_select_input");
		classandgrade_select_input = request.getParameter("classandgrade_select_input");
		//System.out.println(create);
		id = (String)session.getAttribute("userid");
		//System.out.println(id);
		username = (String)session.getAttribute("username");
		//System.out.println(username);
		//把数据统归到select为后缀的属性中；
		if(province_select == ""){
			province_select = province_select_input;
		}
		if(city_select == ""){
			city_select = city_select_input;
		}
		if(town_select == ""){
			town_select = town_select_input;
		}
		if(school_select == ""){
			school_select = school_select_input;
		}
		if(age_select == ""){
			age_select=age_select_input;
		}
		if(class_grade_select == ""){
			class_grade_select = classandgrade_select_input;
		}
		//user_schoolviewbean对象的属性值赋值
		userschoolviewbean.setAge(age_select);
		userschoolviewbean.setCity(city_select);
		userschoolviewbean.setClass_And_Grade(class_grade_select);
		userschoolviewbean.setId(id);
		userschoolviewbean.setProvince(province_select);
		userschoolviewbean.setSchool(school_select);
		userschoolviewbean.setTown(town_select);
		userschoolviewbean.setUserName(username);
		//select_infoviewbean对象属性的赋值
		selectinfoviewbean.setAge(age_select);
		selectinfoviewbean.setAnswear(newquestionanswer);
		selectinfoviewbean.setCity(city_select);
		selectinfoviewbean.setClass_And_Grade(class_grade_select);
		selectinfoviewbean.setProvince(province_select);
		selectinfoviewbean.setQuestion(newapplyquestion);
		selectinfoviewbean.setSchool(school_select);
		selectinfoviewbean.setTown(town_select);
		//
		JoinBookDAO joinbookdao = new JoinBookDAO();
		if(joinbookdao.insertUserSchoolView(userschoolviewbean)&&joinbookdao.insertSelectInfoView(selectinfoviewbean)){
			response.sendRedirect(response.encodeURL("ClassListAction"));
		}
		else
			response.sendRedirect("error.jsp");
	}

}
