package com.example.spring_boot.dao;

//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.spring_boot.entity.Employee;
import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.Query;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
/*        Session session = entityManager.unwrap(Session.class);
        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        List<Employee> allEmployees = query.getResultList();*/
        //следующий квери интерфейс не работает с дженериками:
        Query query = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> allEmployees = query.getResultList();
        return allEmployees;
    }


    @Override
    public void saveEmployee(Employee employee) {
/*        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);*/
        Employee newEmployee = entityManager.merge(employee);
        employee.setId(new Employee().getId());
    }

    @Override
    public Employee getEmployee(int id) {
/*        Session session = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class, id);*/
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
/*        Session session = entityManager.unwrap(Session.class);*/
        Query query = entityManager.createQuery("delete from Employee  " +
                "where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
/*        Employee employee = session.get(Employee.class, id);
        session.delete(employee);*//*


        Query<Employee> query = session.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }

*/

}
