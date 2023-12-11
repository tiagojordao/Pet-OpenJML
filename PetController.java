

import java.util.ArrayList;
import java.util.List;

public class PetController {
	private List<Pet> pets;
	
	public PetController() {
		this.pets = new ArrayList<>();
	}
	
	public void addPet(int id, String name, String birthday, String owner) {
		Pet p = new Pet(id, name, birthday, owner);
		pets.add(p);
	}
	
	public Pet getPetByName(String petName) {
		for (Pet pet : pets) {
			if(pet.getName().equalsIgnoreCase(petName)) {
				return pet;
			}
		}
		return null;
	}
	
	public void deletePetByName(String name) {
		for (Pet pet : pets) {
			if(pet.getName().equalsIgnoreCase(name)) {
				pets.remove(pet);
			}
		}
	}
	
	public List<Pet> getAllPets() {
		return pets;
	}
}
