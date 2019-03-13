import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueHospital<PatientType> extends Hospital<PatientType> {

	PriorityQueue<PatientType> hospital;
	
	Comparator<PatientType> compare = new Comparator<PatientType>() {

		@Override
		public int compare(PatientType o1, PatientType o2) {
			Class<? extends Object> c = o2.getClass();
			String c2 = c.toString();
			if (c.toString().equalsIgnoreCase("class SickPerson")) {
				SickPerson sp1 = (SickPerson) o1;
				SickPerson sp2 = (SickPerson) o2;
				return sp1.compareTo(sp2);
			}
			if (c.toString().equalsIgnoreCase("class HealthyPerson")) {
				HealthyPerson hp1 = (HealthyPerson) o1;
				HealthyPerson hp2 = (HealthyPerson) o2;
				return hp1.compareTo(hp2);
			}
			if (c.toString().equalsIgnoreCase("class Animal")) {
				Animal a1 = (Animal) o1;
				Animal a2 = (Animal) o2;
				int ret = a1.compareTo(a2);
				if (ret > 0) {
					return 1;
				}
				if (ret < 0) {
					return -1;
				}
				else {
					return 0;
				}
				}
			else return -50;
		}
	};
	
	public PriorityQueueHospital() {
		super();
		hospital = new PriorityQueue<>(compare);
	}

	@Override
	public void addPatient(PatientType patient) {
		hospital.add(patient);
	}

	@Override
	public PatientType nextPatient() {
		return hospital.peek();
	}

	@Override
	public PatientType treatNextPatient() {
		return hospital.remove();
	}

	@Override
	public int numPatients() {
		return hospital.size();
	}

	@Override
	public String hospitalType() {
		return "Priority Queue Hospital";
	}

	@Override
	public String allPatientInfo() {
		String ret = "";
		for (PatientType p : hospital) {
			ret += p.toString();
		}
		return ret;
	}

}
