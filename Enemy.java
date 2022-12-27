public class Enemy {
    private String name;
    private String description;
    private String room;

    public Enemy() {
        this.name = null;
        this.description = null;
        this.room = "Forest";
    }

    public Enemy(String name, String description, String room) {
        this.name = name;
        this.description = description;
        this.room = room;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
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

    public String getEnemyInRoom() {
        return this.room;
    }

    public String toString() {
        return "Name: " + name + "\n" + "Description: " + description + "\n" + "Room: " + room + "\n";
    }
}