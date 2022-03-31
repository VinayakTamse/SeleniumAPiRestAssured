package selenium.features.applombok;

import org.apache.juneau.annotation.Beanc;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employee {
	
	
	int id;
	String name;
	int salary;
	String place;
	
	@Beanc(properties="id, name, salary, place")
	public Employee(int id, String name, int salary, String place) {
		
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.place = place;
	}

}
