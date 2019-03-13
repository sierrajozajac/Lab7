import java.util.Comparator;

public class HealthyPerson extends Person implements Comparator<Person>{

	protected String name;
	protected int age;
	protected String reason;
	
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
