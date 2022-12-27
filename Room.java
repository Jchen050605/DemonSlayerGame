import java.util.*;

public class Room {  
  private boolean canGoNorth;
  private boolean canGoSouth;
  private boolean canGoEast;
  private boolean canGoWest;
  private String name;
  private String description;
  private ArrayList<Inventory> inventory;
  private ArrayList<Enemy> monsters;

  public Room() {
    canGoNorth = false;
    canGoSouth = false;
    canGoEast = false;
    canGoWest = false;
    name = "Not a room";
    description = "This is not a room, you shouldn't be here!!!";
  }
  
  public Room(boolean canGoNorth, boolean canGoSouth, boolean canGoEast, boolean canGoWest, String name, String description) {
    this.canGoNorth = canGoNorth;
    this.canGoSouth = canGoSouth;
    this.canGoEast = canGoEast;
    this.canGoWest = canGoWest;
    this.name = name;
    this.description = description;
    inventory = new ArrayList<Inventory>();
    monsters = new ArrayList<Enemy>();
  }

  public Room(boolean canGoNorth, boolean canGoSouth, boolean canGoEast, boolean canGoWest, String name, String description, Inventory item) {
    this.canGoNorth = canGoNorth;
    this.canGoSouth = canGoSouth;
    this.canGoEast = canGoEast;
    this.canGoWest = canGoWest;
    this.name = name;
    this.description = description;
    inventory = new ArrayList<Inventory>();
    inventory.add(item);
    monsters = new ArrayList<Enemy>();
  }

  public Room(boolean canGoNorth, boolean canGoSouth, boolean canGoEast, boolean canGoWest, String name, String description, ArrayList<Inventory> items) {
    this.canGoNorth = canGoNorth;
    this.canGoSouth = canGoSouth;
    this.canGoEast = canGoEast;
    this.canGoWest = canGoWest;
    this.name = name;
    this.description = description;
    inventory = items;
    monsters = new ArrayList<Enemy>();
  }

  public Room(boolean canGoNorth, boolean canGoSouth, boolean canGoEast, boolean canGoWest, String name, String description, Inventory item, Enemy monster) {
		this.canGoNorth = canGoNorth;
		this.canGoSouth = canGoSouth;
		this.canGoEast = canGoEast;
		this.canGoWest = canGoWest;
		this.name = name;
		this.description = description;
		monsters = new ArrayList<Enemy>();
		monsters.add(monster);
		inventory = new ArrayList<Inventory>();
		inventory.add(item);
	}

  public Room(boolean canGoNorth, boolean canGoSouth, boolean canGoEast, boolean canGoWest, String name, String description, ArrayList<Inventory> items, ArrayList<Enemy> monster) {
		this.canGoNorth = canGoNorth;
		this.canGoSouth = canGoSouth;
		this.canGoEast = canGoEast;
		this.canGoWest = canGoWest;
		this.name = name;
		this.description = description;
		inventory = items;
		monsters = monster;
	}

  public Room(boolean canGoNorth, boolean canGoSouth, boolean canGoEast, boolean canGoWest, String name, String description, Inventory item, ArrayList<Enemy> monster) {
		this.canGoNorth = canGoNorth;
		this.canGoSouth = canGoSouth;
		this.canGoEast = canGoEast;
		this.canGoWest = canGoWest;
		this.name = name;
		this.description = description;
		inventory = new ArrayList<Inventory>();
		inventory.add(item);
		monsters = monster;
	}

  public String getDescription() {
    return this.description;
  }

  public String getName() {
    return this.name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean getCanGoNorth() {
    return this.canGoNorth;
  }

  public boolean getCanGoSouth() {
    return this.canGoSouth;
  }

  public boolean getCanGoEast() {
    return this.canGoEast;
  }

  public boolean getCanGoWest() {
    return this.canGoWest;
  }

  public void setCanGoNorth(boolean b) {
    this.canGoNorth = b;
  }

  public void setCanGoSouth(boolean b) {
    this.canGoSouth = b;
  }

  public void setCanGoEast(boolean b) {
    this.canGoEast = b;
  }

  public void setCanGoWest(boolean b) {
    this.canGoWest = b;
  }

  public void setUnlock(String direction) {
    switch (direction) {
      case "north":
        if (this.canGoNorth)
          System.out.println("north is already unlocked");
        else if (!(this.canGoNorth)) {
          this.canGoNorth = true;
          System.out.println("The door to the north has been unlocked");
        }
      case "south":
        if (this.canGoSouth)
          System.out.println("south is already unlocked");
        else if (!(this.canGoSouth)) {
          this.canGoSouth = true;
          System.out.println("The door to the south has been unlocked");
        }
      case "east":
        if (this.canGoEast)
          System.out.println("east is already unlocked");
        else if (!(this.canGoEast)) {
          this.canGoEast = true;
          System.out.println("The door to the east has been unlocked");
        }
      case "west":
        if (this.canGoWest)
          System.out.println("west is already unlocked");
        else if (!(this.canGoWest)) {
          this.canGoWest = true;
          System.out.println("The door to the west has been unlocked");
        }
      default:
        System.out.println("Sorry, I don't understand which door you are trying to unlock");
    }
  }

  public void setLock(String direction) {
    switch (direction) {
      case "north":
        if (this.canGoNorth)
          System.out.println("north is already locked");
        else if (!(this.canGoNorth))
          this.canGoNorth = false;
          System.out.println("The door to the north has been locked");
      case "south":
        if (this.canGoSouth)
          System.out.println("south is already locked");
        else if (!(this.canGoSouth))
          this.canGoSouth = false;
          System.out.println("The door to the south has been locked");
      case "east":
        if (this.canGoEast)
          System.out.println("east is already locked");
        else if (!(this.canGoEast))
          this.canGoEast = false;
          System.out.println("The door to the east has been locked");
      case "west":
        if (this.canGoWest)
          System.out.println("west is already locked");
        else if (!(this.canGoWest))
          this.canGoWest = false;
          System.out.println("The door to the west has been locked");
      default:
        System.out.println("I don't understand which door you want to lock");
    }
  }

  public boolean hasObject(String objectName) {
    boolean objectInRoom = false;
    for (int i = 0; i < inventory.size(); i++) {
      if (inventory.get(i).getName().toLowerCase().equals(objectName.toLowerCase())) {
        objectInRoom = true;
      }
    }
    return objectInRoom;
  }

  public boolean hasEnemy(String enemyName) {
	  boolean enemyInRoom = false;
	  for (int i = 0; i < monsters.size(); i++) {
		  if (monsters.get(i).getName().toLowerCase().equals(enemyName.toLowerCase())) {
			  enemyInRoom = true;
		  }
	  }
	  return enemyInRoom;
  }

  public void addObject(Inventory inventory2) {
    inventory.add(inventory2);
  }

  public Inventory removeObject(String objName) {
    Inventory objectToRemove = null;
    for (int i = 0; i < inventory.size(); i++) {
      if (inventory.get(i).getName().toLowerCase().equals(objName.toLowerCase())) {
        objectToRemove = inventory.remove(i);
      }
    }
    return objectToRemove;
  }

  public Enemy removeEnemy(String enemyName) {
    Enemy enemyToRemove = null;
    for (int i = 0; i < monsters.size(); i++) {
      if (monsters.get(i).getName().toLowerCase().equals(enemyName.toLowerCase())) {
        enemyToRemove = monsters.remove(i);
      }
    }
    return enemyToRemove;
  }

  public String getNamesOfObjectsInRoom() {
    String items = "";
    if (inventory.size() == 0) {
      return "No items are in the room";
    } else {
      for (int i = 0; i < inventory.size(); i++) {
        items += inventory.get(i).getName() + ", ";
      }
      return "Items in room are: " + items;
    }
  }

  public String getNamesOfEnemiesInRoom() {
		String names = "";
		if(monsters.size() == 0) {
			return "No monsters are in the room";
		} else {
			for(int i = 0; i < monsters.size(); i++) {
				names += monsters.get(i).getName() + ", ";
			}
			return "Enemies in the room: " + names;
		}
	}
	public String getEnemy(String enemyName) {
		String response = "";
		for(int i = 0; i < monsters.size(); i++) {
			if(monsters.get(i).getName().toLowerCase().equals(enemyName.toLowerCase())) {
					response = monsters.get(i).toString();
				}
			}
		return response; 
		
	}

  public String toString() {
    return name + "\n" + description + "\n" + "North: " + canGoNorth + " South: " + canGoSouth + " East: " + canGoEast + " West: " + canGoWest + "\n";
  }
}