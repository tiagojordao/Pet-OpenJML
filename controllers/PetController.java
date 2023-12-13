package controllers;


import java.util.ArrayList;
import java.util.List;

import models.Pet;

public class PetController {

	//@ spec_public
	private /*@ non_null @*/ List<Pet> pets;
	
	//@ public initially pets.size() == 0;

	/*@ 
	@	public normal_behavior
	@	ensures pets != null;
	@*/
	public PetController() {
		this.pets = new ArrayList<>();
	}

	/*@
	@	requires p != null;
	@	requires p instanceof Pet;
	@	ensures pets.size() == \old(pets.size()) + 1;
	@	ensures pets.get(pets.size() - 1).equals(p);
	@*/
	public void addPet(Pet p) {
		pets.add(p);
	}
	
	//@ requires petName != null;
	//@ pure
	public /*@ nullable @*/ Pet getPetByName(String petName) {
		for (Pet pet : pets) {
			if(pet.getName().equalsIgnoreCase(petName)) {
				return pet;
			}
		}
		return null;
	}
	
			//	ensures (\forall int i; 0 <= i < pets.size(); pets.get(i).getName() != name);
	//@	requires name != null;
	//@	requires name != "";
	public void deletePetByName(String name) {
		// maintaining 0 <= i <= pets.size();
		// maintaining pets.size() <= \old(pets.size());
		//@ loop_writes i, pets;
		//@ decreases pets.size() - i;
		for(int i = 0 ; i < pets.size() ; i ++) {
			if(pets.get(i).getName().equalsIgnoreCase(name)) {
				pets.remove(pets.get(i));
			}
		}
	}
	
	public List<Pet> getAllPets() {
		return pets;
	}
}
