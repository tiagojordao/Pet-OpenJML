

import java.util.ArrayList;
import java.util.List;

public class PetController {
	private List<Pet> pets;
	
	public PetController() {
		this.pets = new ArrayList<>();
	}

	/*@
	@	requires id != null;
	@	requires name != null;
	@	requires birthday != null;
	@	requires owner != null;
	@	requires (\forall int i; 0 <= i < pets.size(); pets.get(i).getId() != id);
	@	ensures pets.size() == \old(pets.size())+1;
	@*/
	public void addPet(int id, String name, String birthday, String owner) {
		Pet p = new Pet(id, name, birthday, owner);
		pets.add(p);
	}
	
	public /*@ pure @*/ Pet getPetByName(String petName) {
		for (Pet pet : pets) {
			if(pet.getName().equalsIgnoreCase(petName)) {
				return pet;
			}
		}
		return null;
	}
	
	/*@
	@	requires name != null;
	@	requires (\forall int i; 0 <= i < pets.size(); pets.get(i).getName() == name);
	@*/
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
