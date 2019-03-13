import java.util.Stack;

/**
 * Class representing a Hospital. Hospitals store a collection of patients who are waiting to receive
 * medical treatment. Patients are treated one at a time in last in first out order. Once a patient is 
 * treated, it is removed from the Hospital.
 *
 * Hospitals may have different types of patients. In the case of this lab, the two general patient types
 * used are Person and Animal.
 *
 * @author Sierra
 * @version 03/12/2019
 * @param <PatientType> The generic type for the type of patient that the Hospital accepts.
 */
public class StackHospital<PatientType> extends Hospital<PatientType>{

	/**
	 * The only necessary local information is the stack that will
	 * hold the hospital patients
	 */
	Stack<PatientType> Hospital;
	
	/**
	 * Constructor for the StackHospital
	 */
	public StackHospital() {
		super();
		Hospital = new Stack<PatientType>();
	}

	/**
	 * Adds a patient to the stack
	 * @param p Patient to be added to the stack
	 */
	public void addPatient(PatientType p) {
		Hospital.add(p);
	}
	
	/**
	 * Reveals, but does not remove the next patient on the stack.
	 * @return PatientType Returns the appropriate patient object
	 */
	public PatientType nextPatient() {
		return Hospital.peek();
	}
	
	/**
	 * Removes the next patient on the stack
	 * @return PatientType Returns the appropriate patient object
	 */
	public PatientType treatNextPatient() {
		return Hospital.pop();
	}
	
	/** 
	 * Returns the number of patients who have not been treated
	 * @return int Returns the integer representation of the number of patients
	 */
	public int numPatients() {
		return Hospital.size();
	}
	
	/**
	 * Returns the type of hospital
	 * @return String Lets others know what type of hospital
	 */
	public String hospitalType() {
		return "Stack Hospital";
	}
	
	/**
	 * Returns the toString for all patients in the hospital
	 * @return String The string of all the patients
	 */
	public String allPatientInfo() {
		String ret = "";
		for (PatientType p : Hospital) {
			ret += p.toString() + "\n";
		}
		return ret;
	}
}
