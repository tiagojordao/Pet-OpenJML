

public class PetClinic {
	public static void main(String[] args) {
		AppointmentController ac = new AppointmentController();

		Pet p = new Pet(1, "Pet", "12/12/2020", "Owner");
		Vet v = new Vet(1, "Dr.Vet", "email@email.com", "2002840029");
		Appointment app = new Appointment(1, "agendado", "12/12/2022", p, v);
		ac.addAppointment(app);
	}
}
