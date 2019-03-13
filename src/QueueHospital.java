import java.util.LinkedList;
import java.util.Queue;

public class QueueHospital<PatientType> extends Hospital<PatientType> {

	Queue<PatientType> hospital;
	
	public QueueHospital() {
		super();
		hospital = new LinkedList<PatientType>();
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
		return "Queue Hospital";
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
