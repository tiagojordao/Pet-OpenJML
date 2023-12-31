

import java.util.ArrayList;
import java.util.List;

public class VetController {
	private List<Vet> vets;
	
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
	@	requires id != null;
	@	requires name != null;
	@	requires email != null;
	@	requires registro != null;
	@	requires (\forall int i; 0 <= i < vets.size(); vets.get(i).getId() != id);
	@	ensures vets.size() == \old(vets.size())+1;
	@*/
	public void addVet(int id, String name, String email, String registro) {
		Vet v = new Vet(id, name, email, registro);
		vets.add(v);
	}
	
	public /*@ pure @*/ Vet getVetByName(/*@ non_null @*/String name) {
		for(Vet v : vets) {
			if(v.getName().equalsIgnoreCase(name)) {
				return v;
			}
		}
		return null;
	}
	
	public void deleteVetByName(/*@ non_null @*/String name) {
		for(Vet v : vets) {
			if(v.getName().equalsIgnoreCase(name)) {
				vets.remove(v);
			}
		}
	}
}
