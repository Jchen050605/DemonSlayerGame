public class Weapon implements Inventory {
    private String name;
    private String description;
    private double weight;
    private String room;

    public Weapon(String name, String description, double weight, String room) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.room = room;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    public void setWeight(double newWeight) {
        this.weight = newWeight;
    }

    public void setRoom(String newRoom) {
        this.room = newRoom;
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

    public String getItemInRoom() {
        return this.room;
    }

    public String toString() {
        return "Name: " + name + "\n" + "Description: " +description + "\n" + "Weight: " + weight + " lbs\n" + "Room: " + room + "\n";
    }
}