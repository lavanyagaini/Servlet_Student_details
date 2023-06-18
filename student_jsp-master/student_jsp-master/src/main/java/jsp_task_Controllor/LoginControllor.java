package jsp_task_Controllor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.dialect.RDMSOS2200Dialect;

import jsp_task_dao.StudentDao;
import jsp_task_dto.Student;
@WebServlet("/login")
public class LoginControllor extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	
	
	StudentDao dao=new StudentDao();
	Student student=dao.getStudentByEmail(email);
	if(student.getPassword().equals(password)) {
		List<Student> list=dao.getAllStudent();
		req.setAttribute("list", list);
		RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
		dispatcher.forward(req, resp);
		
	}else {
		req.setAttribute("message", "Invalid password");
		RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
		dispatcher.include(req, resp);
	}

}
}
