package Docker.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	List<Employee> emplist = new ArrayList<Employee>();
    	for(int i=1;i<5;i++){
    		emplist.add(new Employee(i, "name"+i, "Bangalore address"+i));
    	}
    	for (Iterator iterator = emplist.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			System.out.println(employee.toString());
			
		}
        System.out.println( "Hello World!" );
    }
}
