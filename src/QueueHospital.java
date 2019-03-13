import java.util.LinkedList;
import java.util.Queue;

/**
 * Class representing a Hospital. Hospitals store a collection of patients who are waiting to receive
 * medical treatment. Patients are treated one at a time in first in first out order. Once a patient is 
 * treated, it is removed from the Hospital.
 *
 * Hospitals may have different types of patients. In the case of this lab, the two general patient types
 * used are Person and Animal.
 *
 * @author Sierra
 * @version 03/12/2019
 * @param <PatientType> The generic type for the type of patient that the Hospital accepts.
 */
public class QueueHospital<PatientType> extends Hospital<PatientType> {

	/**
	 * The only necessary local information is the queue that will
	 * hold the hospital patients
	 */
	Queue<PatientType> hospital;
	
	/**
	 * Constructor for the QueueHospital
	 */
	public QueueHospital() {
		super();
		hospital = new LinkedList<PatientType>();
	}

	/**
	 * Adds a patient to the queue
	 * @param p Patient to be added to the queue
	 */
	public void addPatient(PatientType patient) {
		hospital.add(patient);
		
	}

	/**
	 * Reveals, but does not remove the next patient in the queue.
	 * @return PatientType Returns the appropriate patient object
	 */
	public PatientType nextPatient() {
		return hospital.peek();
	}

	/**
	 * Removes the next patient on the queue
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
		return "Queue Hospital";
	}

	/**
	 * Returns the toString for all patients in the hospital
	 * @return String The string of all the patients
	 */
	public String allPatientInfo() {
		String ret = "";
		for (PatientType p : hospital) {
			ret += p.toString();
		}
		return ret;
	}

}
