package jsp_task_dao;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jsp_task_dto.Student;

public class StudentDao {
public EntityManager getEManager() {
	return Persistence.createEntityManagerFactory("Lavanya").createEntityManager();	
}
public Student saveStudent(Student student) {
	EntityManager entityManager=getEManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(student);
	entityTransaction.commit();
	return student;
	
}
public Student getStudentByEmail(String email) {
	EntityManager entityManager=getEManager();
	Query query=entityManager.createQuery("select s from Student s where s.email=?1");
	query.setParameter(1, email);
	Student student=(Student)query.getSingleResult();
	return student;
	
	
}
public List<Student> getAllStudent(){
	
	EntityManager  entityManager=getEManager();
	Query query=entityManager.createQuery("select s from Student s");
	List<Student> list=query.getResultList();
	return list;
}
public boolean deleteStudent(int id) {
	EntityManager  entityManager=getEManager();
	Student student=entityManager.find(Student.class, id);
	EntityTransaction entityTransaction=entityManager.getTransaction();
	if(student!=null) {
		entityTransaction .begin();
		entityManager.remove(student);
		entityTransaction.commit();
		return true;
	}
	return false;
}
public Student getStudentById(int id) {
	return getEManager().find(Student.class, id);
}
public Student updateStudent(Student student) {
	EntityManager entityManager=getEManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.merge(student);
	entityTransaction.commit();
	return student;
}



}
