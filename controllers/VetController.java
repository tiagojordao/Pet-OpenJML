package controllers;


import java.util.ArrayList;
import java.util.List;

import models.Vet;

public class VetController {
	//@ public initially vets.size() == 0;

	/*@ spec_public @*/
	private /*@ non_null @*/ List<Vet> vets;
	
	public VetController() {
		this.vets = new ArrayList<>();
	}
	
	/*@ 
	@	ensures \result != null; 
	@*/
	public /*@ pure @*/ List<Vet> getAllVets() {
		return vets;
	}
	
	/*@
	@	requires v != null;
	@	ensures vets.get(vets.size()-1).equals(v);
	@	ensures vets.size() == \old(vets.size())+1;
	@*/
	public void addVet(Vet v) {
		vets.add(v);
	}
	
	public /*@ nullable @*/ Vet getVetByName(/*@ non_null @*/String name) {
		for(Vet v : vets) {
			if(v.getName().equalsIgnoreCase(name)) {
				return v;
			}
		}
		return null;
	}
	
	//@		requires name != null;
	//@		requires (\exists int i; 0 <= i < vets.size(); vets.get(i).getName() != name);
	public void deleteVetByName(String name) {
		for(Vet v : vets) {
			if(v.getName().equalsIgnoreCase(name)) {
				vets.remove(v);
			}
		}
	}
}
