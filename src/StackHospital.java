import java.util.Stack;

public class StackHospital<PatientType> extends Hospital<PatientType>{

	Stack<PatientType> Hospital;
	
	public StackHospital() {
		super();
		Hospital = new Stack<PatientType>();
	}

	public void addPatient(PatientType p) {
		Hospital.add(p);
	}
	
	public PatientType nextPatient() {
		return Hospital.peek();
	}
	
	public PatientType treatNextPatient() {
		return Hospital.pop();
	}
	
	public int numPatients() {
		return Hospital.size();
	}
	
	public String hospitalType() {
		return "Stack Hospital";
	}
	
	public String allPatientInfo() {
		String ret = "";
		for (PatientType p : Hospital) {
			ret += p.toString();
		}
		return ret;
	}
}
