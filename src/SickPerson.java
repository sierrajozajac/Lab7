import java.util.Comparator;

/**
 * Class representing a sick person
 * @author Sierra Jo
 * @version 03/12/2019
 */
public class SickPerson extends Person implements Comparator<Person>{

	/**
	 * Protected variables representing all necessary information 
	 * for a sick person object
	 */
	public int severity;
	public String name;
	public int age;
	
	/**
	 * Constructor for Healthy Person
	 * @param name The person's name
	 * @param age The person's age
	 * @param severity The severity of their illness
	 * Sick people are ordered by their illness severity in decreasing order.
	 */
	public SickPerson(String name, int age, int severity) {
		super(name, age);
		this.name = name;
		this.age = age;
		this.severity = severity;
	}

	@Override
	protected int compareToImpl(Person p) {
		int ret = 0;
		if (p.getType().equals("Sick")) {
			SickPerson p2 = (SickPerson)p;
			if (p2.getSeverity() > severity) {
				ret = -1;
			}
			else if (p2.getSeverity() < severity) {
				ret = 1;
			}
		}
		else {
			ret = -1;
		}
		return ret;
	}
	
	@Override
	protected String getType() {
		return "Sick";
	}
	
	protected int getSeverity() {
		return severity;
	}

	@Override
	public int compare(Person o1, Person o2) {
		return o1.compareToImpl(o2);
	}
}
