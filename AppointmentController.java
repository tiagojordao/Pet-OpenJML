

import java.util.ArrayList;
import java.util.List;

public class AppointmentController {
	
	//@ public initially appointments.size() == 0;
	/*@ spec_public @*/
	private /*@ non_null @*/ List<Appointment> appointments;

	public AppointmentController() {
		appointments = new ArrayList<>();
	}
	
	
	/*@ 
	@ 	requires app instanceof Appointment;
	@	requires (\forall int i; 0 <= i < appointments.size(); appointments.get(i).getId() != app.getId());
	@	ensures appointments.size() == \old(appointments.size())+1;
	@*/ 
	public void addAppointment(Appointment app) {
		appointments.add(app);
	}

	//@ pure
	public List<Appointment> getAllAppointments() {
		return appointments;
	}
	
	
	//@ requires id >= 0;
	public void cancelAppointment(int id) {
		for(Appointment app : appointments) {
			if(app.getId() == id) {
				app.setStatus("cancelado");
			}
		}
	}
}
