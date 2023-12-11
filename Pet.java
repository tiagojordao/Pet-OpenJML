

public class Pet {
	
	//@ spec_public
	private /*@ non_null */ int id;
	//@ spec_public
	private /*@ non_null */ String name;
	//@ spec_public
	private /*@ non_null */ String birthday;
	//@ spec_public
	private /*@ non_null */ String owner;
	
	
	/*@
    @		requires n_id >= 0;
    @		requires n_name != "";
    @		requires n_birthday != "";
    @		requires n_owner != "";
    @		ensures id == n_id;
    @		ensures name == n_name;
    @		ensures birthday == n_birthday;
    @		ensures owner == n_owner;
    @*/
	public Pet(int n_id, String n_name, String n_birthday, String n_owner) {
		this.id = n_id;
		this.name = n_name;
		this.birthday = n_birthday;
		this.owner = n_owner;
	}
	public /*@ pure @*/ int getId() {
		return id;
	}
	public /*@ pure @*/ String getName() {
		return name;
	}
	/*@ 
	@	assignable name;
	@	ensures name == n_name;
	@*/
	public void setName(String n_name) {
		this.name = n_name;
	}
	public /*@ pure @*/ String getBirthday() {
		return birthday;
	}
	/*@ 
	@	assignable birthday;
	@	ensures birthday == n_birthday;
	@*/
	public void setBirthday(String n_birthday) {
		this.birthday = n_birthday;
	}
	public /*@ pure @*/ String getOwner() {
		return owner;
	}
	/*@ 
	@	assignable owner;
	@	ensures owner == n_owner;
	@*/
	public void setOwner(String n_owner) {
		this.owner = n_owner;
	}
	
	
}
