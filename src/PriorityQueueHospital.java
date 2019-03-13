import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Class representing a Hospital. Hospitals store a collection of patients who are waiting to receive
 * medical treatment. Patients are treated one at a time, sorted by their respective compare methods. 
 * Once a patient is treated, it is removed from the Hospital.
 *
 * Hospitals may have different types of patients. In the case of this lab, the two general patient types
 * used are Person and Animal.
 *
 * @author Sierra
 * @version 03/12/2019
 * @param <PatientType> The generic type for the type of patient that the Hospital accepts.
 */
public class PriorityQueueHospital<PatientType> extends Hospital<PatientType> {

	/**
	 * The only necessary local information is the priority queue that will
	 * hold the hospital patients
	 */
	PriorityQueue<PatientType> hospital;
	
	/**
	 * The comparator that defines how each type of patient should be ordered within
	 * the priority queue. Animals are ordered decreasingly by their age. Sick people
	 * are ordered by decreasingly the severity of their illness. Healthy people are 
	 * ordered alphabetically by their name.
	 */
	Comparator<PatientType> compare = new Comparator<PatientType>() {

		@Override
		public int compare(PatientType o1, PatientType o2) {
			Class<? extends Object> c = o2.getClass();
			// The patient type is sick person
			if (c.toString().equalsIgnoreCase("class SickPerson")) {
				SickPerson sp1 = (SickPerson) o1;
				SickPerson sp2 = (SickPerson) o2;
				return sp1.compareTo(sp2);
			}
			// The patient type is healthy person
			if (c.toString().equalsIgnoreCase("class HealthyPerson")) {
				HealthyPerson hp1 = (HealthyPerson) o1;
				HealthyPerson hp2 = (HealthyPerson) o2;
				return hp1.compareTo(hp2);
			}
			// The patient type is animal
			if (c.toString().equalsIgnoreCase("class Animal")) {
				Animal a1 = (Animal) o1;
				Animal a2 = (Animal) o2;
				int ret = a1.compareTo(a2);
				// Animal 1 is older than animal 2
				if (ret > 0) {
					return 1;
				}
				// Animal 2 is older than animal 1
				if (ret < 0) {
					return -1;
				}
				// The two animals are the same age
				else {
					return 0;
				}
				}
			// Should never occur
			else return -50;
		}
	};
	
	/**
	 * Constructor for the PriorityQueueHospital
	 */
	public PriorityQueueHospital() {
		super();
		hospital = new PriorityQueue<>(compare);
	}

	/**
	 * Adds a patient to the priority queue
	 * @param p Patient to be added to the stack
	 */
	public void addPatient(PatientType patient) {
		hospital.add(patient);
	}

	/**
	 * Reveals, but does not remove the next patient on the priority queue.
	 * @return PatientType Returns the appropriate patient object
	 */
	public PatientType nextPatient() {
		return hospital.peek();
	}

	/**
	 * Removes the next patient on the priority queue
	 * @return PatientType Returns the appropriate patient object
	 */
	public PatientType treatNextPatient() {
		return hospital.remove();
	}

	/** 
	 * Returns the number of patients who have not been treated
	 * @return int Returns the integer representation of the number of patients
	 */
	public int numPatients() {
		return hospital.size();
	}

	/**
	 * Returns the type of hospital
	 * @return String Lets others know what type of hospital
	 */
	public String hospitalType() {
		return "Priority Queue Hospital";
	}

	/**
	 * Returns the toString for all patients in the hospital
	 * @return String The string of all the patients
	 */
	public String allPatientInfo() {
		String ret = "";
		for (PatientType p : hospital) {
			ret += p.toString() +"\n";
		}
		return ret;
	}

}
