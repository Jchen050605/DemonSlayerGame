public class Drink implements Inventory {
    private String name;
	private String description;
	private double weight;
    private String room;
	
	public Drink(String name, String description, double weight, String room) {
		this.name = name;
		this.description = description;
		this.weight = weight;
        this.room = room;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	 }
	
	public void setWeight(double weight) {
		this.weight = weight;
	}

    public void setDrinkInRoom(String room) {
        this.room = room;
    }
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public double getWeight() {
		return this.weight;
	}

    public String getDrinkInRoom() {
        return this.room;
    }
	
	public String toString() {
		return "\nName: " + name + "\nDescription: " + description + "\nWeight: " + weight + "\nRoom: " + room + "\n";
	}
}