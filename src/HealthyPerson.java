import java.util.Comparator;

/**
 * Class representing a healthy person
 * @author Sierra Jo
 * @version 03/12/2019
 */
public class HealthyPerson extends Person implements Comparator<Person>{

	/**
	 * Protected variables representing all necessary information 
	 * for a healthy person object
	 */
	protected String name;
	protected int age;
	protected String reason;
	
	/**
	 * Constructor for Healthy Person
	 * @param name The person's name
	 * @param age The person's age
	 * @param reason The reason the healthy person is visiting the hospital
	 */
	public HealthyPerson(String name, int age, String reason) {
		super(name, age);
		this.name = name;
		this.age = age;
		this.reason = reason;
	}

	@Override
	protected int compareToImpl(Person p) {
		int ret = 0;
		if (p.getType().equals("Healthy")) {
			HealthyPerson p2 = (HealthyPerson)p;
			ret = name.compareToIgnoreCase(p2.getName());
		}
		else {
			ret = 1;
		}
		return ret;
	}

	@Override
	protected String getType() {
		return "Healthy";
	}

	@Override
	public int compare(Person o1, Person o2) {
		return o1.compareToImpl(o2);
	}
}
