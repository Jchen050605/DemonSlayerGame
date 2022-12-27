public class Message implements Inventory {
	
	private String name;
	private String description;
	private double weight;
    private String room;
	
	public Message(String name, String description, double weight, String room) {
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

    public void setRoom(String room) {
        this.room = room;
    }
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public double getWeight() {
		return weight;
	}

    public String getRoom() {
        return room;
    }
	
	public String toString() {
		return "Name: " + name + "\nDescription: " + description + "\nWeight: " + weight + "\nRoom: " + room;
	}
	
}
