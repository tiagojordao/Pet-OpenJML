package controllers;


import java.util.ArrayList;
import java.util.List;

import models.Appointment;

public class AppointmentController {
	
	//@ public initially appointments.size() == 0;
	/*@ spec_public @*/
	private /*@ non_null @*/ List<Appointment> appointments;
	
	//@ public invariant appointments.size() >= 0;

	/*@ 
	@	public normal_behavior
	@	ensures appointments.size() == 0;
	@*/
	public AppointmentController() {
		appointments = new ArrayList<>();
	}
	
	
	//@	requires  app instanceof Appointment;
	//@	requires \forall int i; 0 <= i < appointments.size(); appointments.get(i).getId() != app.getId();
	//@	ensures appointments.size() == \old(appointments.size())+1;
	//@ ensures appointments.get(appointments.size() - 1).equals(app);
	public void addAppointment(Appointment app) {
		appointments.add(app);
	}

	//@ requires appId >= 0;
	//@ requires appId < Integer.MAX_VALUE;
	//@ requires appointments.size() > 0;
	//@ ensures \result instanceof Appointment || \result == null;
	//@ pure
	public /*@ nullable @*/ Appointment getAppointment(int appId) {
		//@ maintaining 0 <= i <= appointments.size();
		//@ maintaining \forall int k; 0 <= k < i; appointments.get(k).getId() != appId;
		//@ loop_writes i;
		//@ decreases appointments.size() - i;
		for(int i = 0 ; i < appointments.size() ; i++) {
			if(appointments.get(i).getId() == appId) {
				return appointments.get(i);
			}
			//@ assert appointments.get(i).getId() != appId;
		}
		//@ assert \forall int i ; 0 <= i < appointments.size() ; appointments.get(i).getId() != appId;
		return null;
	}

	//@ requires appointments.size() > 0;
	//@ ensures (\forall int i ; 0 <= i < appointments.size() ; appointments.get(i) instanceof Appointment);
	//@ pure
	public List<Appointment> getAllAppointments() {
		//@ assume (\forall int i ; 0 <= i < appointments.size() ; appointments.get(i) instanceof Appointment);
		return appointments;
	}
	
	
	//@ requires id >= 0;
	//@ requires id < Integer.MAX_VALUE;
	public void cancelAppointment(int id) {
		for(Appointment app : appointments) {
			if(app.getId() == id) {
				app.setStatus("cancelado");
			}
		}
	}
}
