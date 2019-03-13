import org.junit.*;

public class TestDriver {

	public static void main(String[] args)
	{
		PriorityQueueHospital<Animal> animal_pqh = new PriorityQueueHospital<Animal>();
		QueueHospital<Animal> animal_qh = new QueueHospital<Animal>();
		StackHospital<Animal> animal_s = new StackHospital<Animal>();
		
		PriorityQueueHospital<SickPerson> sp_pqh = new PriorityQueueHospital<SickPerson>();
		QueueHospital<SickPerson> sp_qh = new QueueHospital<SickPerson>();
		StackHospital<SickPerson> sp_s = new StackHospital<SickPerson>();
	
		PriorityQueueHospital<HealthyPerson> hp_pqh = new PriorityQueueHospital<HealthyPerson>();
		QueueHospital<HealthyPerson> hp_qh = new QueueHospital<HealthyPerson>();
		StackHospital<HealthyPerson> hp_s = new StackHospital<HealthyPerson>();
	
		Animal a1 = new Animal("dog", 24);
		Animal a2 = new Animal("cat", 34);
		Animal a3 = new Animal("hamster", 10);
		Animal a4 = new Animal("lizard", 4);
		
		SickPerson sp1 = new SickPerson("Lizzie", 23, 5);
		SickPerson sp2 = new SickPerson("John", 43, 7);
		SickPerson sp3 = new SickPerson("Karen", 21, 9);
		SickPerson sp4 = new SickPerson("Marie", 32, 2);
	
		HealthyPerson hp1 = new HealthyPerson("Bonnie", 84, "check up");
		HealthyPerson hp2 = new HealthyPerson("Connor", 16, "medication refill");
		HealthyPerson hp3 = new HealthyPerson("Abigail", 32, "blood tests");
		HealthyPerson hp4 = new HealthyPerson("Lilia", 53, "is lonely");
	
		// Add animals
		animal_pqh.addPatient(a1);
		animal_qh.addPatient(a1);
		animal_s.addPatient(a1);
		
		animal_pqh.addPatient(a2);
		animal_qh.addPatient(a2);
		animal_s.addPatient(a2);
		
		animal_pqh.addPatient(a3);
		animal_qh.addPatient(a3);
		animal_s.addPatient(a3);
		
		animal_pqh.addPatient(a4);
		animal_qh.addPatient(a4);
		animal_s.addPatient(a4);
		
		// Test animal stack
		Assert.assertEquals(animal_s.nextPatient(), a4);
		Assert.assertEquals(animal_s.treatNextPatient(), a4);
		Assert.assertEquals(animal_s.treatNextPatient(), a3);
		Assert.assertEquals(animal_s.hospitalType(), "Stack Hospital");
		Assert.assertEquals(animal_s.numPatients(), 2);
		String reta1 = a1.toString() + a2.toString();
		Assert.assertEquals(animal_s.allPatientInfo(), reta1);
		
		// Test animal priority queue
		Assert.assertEquals(animal_pqh.nextPatient(), a2);
		Assert.assertEquals(animal_pqh.treatNextPatient(), a2);
		Assert.assertEquals(animal_pqh.treatNextPatient(), a1);
		Assert.assertEquals(animal_pqh.hospitalType(), "Priority Queue Hospital");
		Assert.assertEquals(animal_pqh.numPatients(), 2);
		String reta2 = a3.toString() + a4.toString();
		Assert.assertEquals(animal_pqh.allPatientInfo(), reta2);
		
		// Test animal queue
		Assert.assertEquals(animal_qh.nextPatient(), a1);
		Assert.assertEquals(animal_qh.treatNextPatient(), a1);
		Assert.assertEquals(animal_qh.treatNextPatient(), a2);
		Assert.assertEquals(animal_qh.hospitalType(), "Queue Hospital");
		Assert.assertEquals(animal_qh.numPatients(), 2);
		String reta3 = a3.toString() + a4.toString();
		Assert.assertEquals(animal_qh.allPatientInfo(), reta3);
		
		// Add healthy people
		hp_pqh.addPatient(hp2);
		hp_qh.addPatient(hp2);
		hp_s.addPatient(hp2);
		
		hp_pqh.addPatient(hp4);
		hp_qh.addPatient(hp4);
		hp_s.addPatient(hp4);
		
		hp_pqh.addPatient(hp1);
		hp_qh.addPatient(hp1);
		hp_s.addPatient(hp1);
		
		hp_pqh.addPatient(hp3);
		hp_qh.addPatient(hp3);
		hp_s.addPatient(hp3);
		
		// Test healthy people stack
		Assert.assertEquals(hp_s.nextPatient(), hp3);
		Assert.assertEquals(hp_s.treatNextPatient(), hp3);
		Assert.assertEquals(hp_s.treatNextPatient(), hp1);
		Assert.assertEquals(hp_s.hospitalType(), "Stack Hospital");
		Assert.assertEquals(hp_s.numPatients(), 2);
		String rethp1 = hp2.toString() + hp4.toString();
		Assert.assertEquals(hp_s.allPatientInfo(), rethp1);
		
		// Test healthy people priority queue
		Assert.assertEquals(hp_pqh.nextPatient(), hp3);
		Assert.assertEquals(hp_pqh.treatNextPatient(), hp3);
		Assert.assertEquals(hp_pqh.treatNextPatient(), hp1);
		Assert.assertEquals(hp_pqh.hospitalType(), "Priority Queue Hospital");
		Assert.assertEquals(hp_pqh.numPatients(), 2);
		String rethp2 = hp2.toString() + hp4.toString();
		Assert.assertEquals(hp_pqh.allPatientInfo(), rethp2);
		
		// Test healthy people queue
		Assert.assertEquals(hp_qh.nextPatient(), hp2);
		Assert.assertEquals(hp_qh.treatNextPatient(), hp2);
		Assert.assertEquals(hp_qh.treatNextPatient(), hp4);
		Assert.assertEquals(hp_qh.hospitalType(), "Queue Hospital");
		Assert.assertEquals(hp_qh.numPatients(), 2);
		String rethp3 = hp1.toString() + hp3.toString();
		Assert.assertEquals(hp_qh.allPatientInfo(), rethp3);
		
		// Add sick people
		sp_pqh.addPatient(sp1);
		sp_qh.addPatient(sp1);
		sp_s.addPatient(sp1);
		
		sp_pqh.addPatient(sp4);
		sp_qh.addPatient(sp4);
		sp_s.addPatient(sp4);
		
		sp_pqh.addPatient(sp3);
		sp_qh.addPatient(sp3);
		sp_s.addPatient(sp3);
		
		sp_pqh.addPatient(sp2);
		sp_qh.addPatient(sp2);
		sp_s.addPatient(sp2);
		
		// Test sick people stack
		Assert.assertEquals(sp_s.nextPatient(), sp2);
		Assert.assertEquals(sp_s.treatNextPatient(), sp2);
		Assert.assertEquals(sp_s.treatNextPatient(), sp3);
		Assert.assertEquals(sp_s.hospitalType(), "Stack Hospital");
		Assert.assertEquals(sp_s.numPatients(), 2);
		String retsp1 = sp1.toString() + sp4.toString();
		Assert.assertEquals(sp_s.allPatientInfo(), retsp1);
		
		// Test healthy people priority queue
		Assert.assertEquals(sp_pqh.nextPatient(), sp4);
		Assert.assertEquals(sp_pqh.treatNextPatient(), sp4);
		Assert.assertEquals(sp_pqh.treatNextPatient(), sp1);
		Assert.assertEquals(sp_pqh.hospitalType(), "Priority Queue Hospital");
		Assert.assertEquals(sp_pqh.numPatients(), 2);
		String retsp2 = sp2.toString() + sp3.toString();
		Assert.assertEquals(sp_pqh.allPatientInfo(), retsp2);
		
		// Test sick people queue
		Assert.assertEquals(sp_qh.nextPatient(), sp1);
		Assert.assertEquals(sp_qh.treatNextPatient(), sp1);
		Assert.assertEquals(sp_qh.treatNextPatient(), sp4);
		Assert.assertEquals(sp_qh.hospitalType(), "Queue Hospital");
		Assert.assertEquals(sp_qh.numPatients(), 2);
		String ret3 = sp3.toString() + sp2.toString();
		Assert.assertEquals(sp_qh.allPatientInfo(), ret3);
		
	}
}
