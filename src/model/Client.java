package model;

public class Client implements Comparable <Client> {
	
	public final static int MAN = 1;
	public final static int WOMAN = 1;
    private String name, id, phone, address;
    private boolean disabled, pregnant;
    private int gender, age;

    

    public Client(String name, String id, String phone, String address, boolean disabled, boolean pregnant, int gender, int age) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.address = address;
        this.disabled = disabled;
        this.pregnant = pregnant;
        this.gender = gender;
        this.age = age;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    

    public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public boolean isPregnant() {
		return pregnant;
	}

	public void setPregnant(boolean pregnant) {
		this.pregnant = pregnant;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}
	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
    public String toString() {
        return "Client{" + "name=" + name + ", id=" + id + ", phone=" + phone + ", address=" + address + '}';
    }
    
    //Modificar para los ordenamientos
	@Override
	public int compareTo(Client o) {
		// TODO Auto-generated method stub
		return 0;
	}
     
}
