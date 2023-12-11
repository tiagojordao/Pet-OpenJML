

public class Appointment {

	//@ spec_public
    private /*@ non_null */ int id;
	//@ spec_public
    private /*@ non_null */ String status;
	//@ spec_public
    private /*@ non_null */ String dia;
	//@ spec_public
    private /*@ non_null */ Pet pet;
	//@ spec_public
    private /*@ non_null */ Vet vet;

    
    /*@
	@		public normal_behavior
    @		requires n_id >= 0;
    @		requires n_status == "agendado";
    @		requires n_dia != "";
    @		ensures id == n_id;
    @		ensures status == n_status;
    @		ensures dia == n_dia;
    @*/
    public Appointment(int n_id, String n_status, String n_dia, Pet n_pet, Vet n_vet) {
    	this.id = n_id;
    	this.status = n_status;
    	this.dia = n_dia;
    	this.pet = n_pet;
    	this.vet = n_vet;
    }
	
    public /*@ pure @*/ int getId() {
    	return id;
    }

	public /*@ pure @*/ String getStatus() {
		return status;
	}
	/*@ 
	@	assignable status;
	@	ensures status == n_status;
	@*/
	public void setStatus(/*@ non_null @*/ String n_status) {
		this.status = n_status;
	}

	public /*@ pure @*/ String getDia() {
		return dia;
	}
	/*@ 
	@	assignable dia;
	@	ensures dia == n_dia;
	@*/
	public void setDia(/*@ non_null @*/ String n_dia) {
		this.dia = n_dia;
	}

	/*@
	@	ensures \result != null;
	@*/
	public /*@ pure @*/ Pet getPet() {
		return pet;
	}
	/*@ 
	@	assignable pet;
	@	ensures pet == n_pet;
	@*/
	public void setPet(/*@ non_null @*/ Pet n_pet) {
		this.pet = n_pet;
	}
	
	/*@ 
	@	ensures \result != null;
	@*/
	public /*@ pure @*/ Vet getVet() {
		return vet;
	}
	/*@ 
	@	assignable vet;
	@	ensures vet == n_vet;
	@*/
	public void setVet(/*@ non_null @*/ Vet n_vet) {
		this.vet = n_vet;
	}
}
