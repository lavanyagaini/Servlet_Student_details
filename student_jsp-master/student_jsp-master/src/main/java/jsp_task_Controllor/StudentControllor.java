package jsp_task_Controllor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.dialect.RDMSOS2200Dialect;

import jsp_task_dao.StudentDao;
import jsp_task_dto.Student;
@WebServlet("/save")
public class StudentControllor extends HttpServlet {
@Override

protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name=req.getParameter("name");
	String fathername=req.getParameter("fathername");
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	long phone=Long.parseLong(req.getParameter("phone"));
	Student student=new Student();
	student.setEmail(email);
	student.setFathername(fathername);
	student.setName(name);
	student.setPassword(password);
	student.setPhone(phone);
	
	ServletContext context=getServletContext();
	double fees=Double.parseDouble(context.getInitParameter("fees"));
	student.setFees(fees);
	
	StudentDao dao=new StudentDao();
	Student student2=dao.saveStudent(student);
	if(student2!=null) {
		req.setAttribute("message", "successfully signed in");
        RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
        dispatcher.forward(req, resp);
	}
	
	
}
}
