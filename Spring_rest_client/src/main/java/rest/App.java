package rest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rest.configuration.MyConfig;
import rest.entity.Employee;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication", Communication.class);
/*        List<Employee> allEmployees = communication.getAllEmployees();
        Employee employee = communication.getEmployee(3);

        context.close();
        allEmployees.forEach(System.out::println);
        System.out.println(employee);*/
/*        Employee employee = new Employee("Kolya", "Kolov"
                , "IT", 2000);*/
/*        Employee employee = new Employee("Kolya", "Kolov"
                , "IT", 1000);
        employee.setId(10);
        communication.saveEmployee(employee);*/
        communication.deleteEmployee(10);

        context.close();
    }
}
