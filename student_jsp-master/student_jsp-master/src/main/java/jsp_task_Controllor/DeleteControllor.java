package jsp_task_Controllor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_task_dao.StudentDao;
import jsp_task_dto.Student;
@WebServlet("/delete")
public class DeleteControllor extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	Student student=new Student();
	StudentDao dao=new StudentDao();
	boolean value=dao.deleteStudent(id);
	if(value) {
		List<Student> list=dao.getAllStudent();
		req.setAttribute("list", list);
		RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
		dispatcher.forward(req, resp);
	}
}
}
