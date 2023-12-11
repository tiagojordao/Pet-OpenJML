import controllers.AppointmentController;
import models.Appointment;
import models.Pet;
import models.Vet;

public class PetClinic {
	public static void main(String[] args) {
		Pet p = new Pet(1, "Pet", "12/12/2020", "Owner");
		Vet v = new Vet(1, "Dr.Vet", "email@email.com", "2002840029");
		Appointment app = new Appointment(1, "agendado", "12/12/2022", p, v);
		AppointmentController ac = new AppointmentController();
		ac.addAppointment(app);
	}
}
