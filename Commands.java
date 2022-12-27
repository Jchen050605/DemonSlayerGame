import java.util.Scanner;
import java.util.*;

public class Commands{
  public static Room[][] map;
  public static int row;
  public static int column;
  public static int hp;
  public static Room currentRoom;
  public static boolean gameWon;
  public static ArrayList<Inventory> inventory;
  public static ArrayList<Enemy> villain;

  public static void runGame() {
    Message parents = new Message("parents envelope", "\nDearest daughter, \n\nWe are deeply sorry that we have left you in this horrible world. We both have been eaten by these horrible monsters so I leave the journey to you. Get the golden key and get to the victory room and escape from here as possible! Look around the house to get items and some clues", 2.0, "Bed Room");
    Message evil = new Message("evil envelope", "\nHAHAHAHA, \n\nYOU LITTLE GIRL CAN THINK YOU CAN JUST TRY TO GET THE GOLDEN KEY FROM OUR DUNGEON AND ESCAPE FROM US!!! YOU ARE ALL ALONE!!! YOU HAVE NO ONE TO TALK TO OR LOOK UP TO FOR HELP!!! I'VE EATEN YOUR PARENTS AND SEND IN MY ARMY IN YOUR AREA. DON'T TRY TO ESCAPE ME!!!! I'LL MAKE SURE THAT MY RABBID ARMY DEVOURS YOU AND RIPS YOU FROM LIMB TO LIMB. \n\nFrom: ???", 2.0, "Equipment Room");
    Item smallPainting = new Item("Small Painting", "This is a small painting of you and your parents that you're parents left in the mailbox.", 1.0, "Living Room");
    Item welcomeMat = new Item("Welcome Mat", "A small welcome mat for you to carry. It is not for you to attack with.", 3.0, "Bed Room");
    Weapon pan = new Weapon("Pan", "You can use this item to attack mobs. This will be found in the kitchen room.", 4.0, "Kitchen Room");
    Weapon knife = new Weapon("Knife", "You can use this item to attack mobs. This will be found in the bed room.", 4.0, "Bed Room");
    Weapon pistol = new Weapon("Pistol", "You can use this item to attack mobs. This will be found in the bed room.", 4.0, "Bed Room");
    Item goldenKey = new Item("Golden Key", "You use this item to unlock the door to the Victory room.", 5.0, "Dungeon");
    Item silverKey = new Item("Silver Key", "You use this item to unlock the door to the equipment room", 5.0, "Living Room");
    Weapon sword = new Weapon("Aoi's Nichirin Sword", "This nichirin sword was forged by you but had your parents' help and wields sun breathing. You can use this item to attack mobs. This will be found in the equipment room.", 5.0, "Kitchen Room");
    Food katsu = new Food("Katsu", "This food item is katsu and its so yummy that it can restore your health!", 2.0, "Kitchen Room");
    Food ramen = new Food("Ramen", "This food item is ramen and its so yummy that it can restore your health!", 2.0, "Kitchen Room");
    Food apple = new Food("Apple", "This food is a fruit item that is also good and is found all over the forest", 2.0, "Forest");
    Food dragonfruit = new Food("Dragon Fruit", "This food is a fruit item that is also good and is found all over the forest", 2.0, "Forest");
    Food pear = new Food("Pear", "This food is a fruit item that is also good and is found all over the forest", 2.0, "Forest");
    Food strawberry = new Food("Strawberry", "This food is a fruit item that is also good and is found all over the forest", 2.0, "Forest");
    Food blackberry = new Food("Blackberry", "This food is a fruit item that is also good and is found all over the forest", 2.0, "Forest");
    Food grape = new Food("Grape", "This food is a fruit item that is also good and is found all over the forest", 2.0, "Forest");
    Food chicken = new Food("Chicken", "This food is a fruit item that is also good and is found all over the forest", 2.0, "Forest");
    Food beef = new Food("Beef", "This food is a fruit item that is also good and is found all over the forest", 2.0, "Forest");
    Food banana = new Food("Banana", "This food is a fruit item that is also good and is found all over the forest", 2.0, "Forest");
    Food mango = new Food("Mango", "This food is a fruit item that is also good and is found all over the forest", 2.0, "Forest");
    Drink milktea = new Drink("Milk tea", "This drink is a tea drink that gives you some health and is found in the kitchen", 5.0, "Kitchen");
    Drink tea = new Drink("Tea", "This drink is a tea drink that gives you some health and is found in the kitchen", 5.0, "Kitchen");
    Drink wine = new Drink("Wine", "This drink is a grape drink that gives you some health and is found in the forest", 5.0, "Forest");
    Drink water = new Drink("Water", "This drink is a liquid drink that gives you some health and is found in the forest", 5.0, "Forest");
    Drink soda = new Drink("Soda", "This drink is a grape drink that gives you some health and is found in the forest", 5.0, "Forest");
    Drink pepsi = new Drink("Pepsi", "This drink is a grape drink that gives you some health and is found in the forest", 5.0, "Forest");
    Drink mug = new Drink("Mug", "This drink is a coffee drink that gives you some health and is found in the forest", 5.0, "Forest");
    Enemy haunter = new Enemy("Haunter", "The haunters are ghost, rabbid-type (half-rabbit and half-human) that has medium-ranged blasters and are masters at teleporting.", "Dungeon");
    Enemy ghoul = new Enemy("Ghoul", "The ghouls are ghost, rabbid-type (half-rabbit and half-human) that has medium-ranged blasters and are masters at teleporting.", "Dungeon");
    Enemy ghostScout = new Enemy("Ghost Scout", "The Ghost Scouts are ghost, rabbid-type monster (half-rabbid and half-human) that looks like a wolf and is also good at long-range shots just like the haunter. However, they cannot teleport.", "Dungeon");
    Enemy vanquisher = new Enemy("Vanquisher", "The vanquishers are vampire, rabbid-type monsters (half-rabbit and half-human) that does not have a gun and strikes at you using its claws (it is a melee user).", "Dungeon");
    Enemy ambusher = new Enemy("Ambusher", "The ambushers are huge, buff, ghost rabbid-type (half-rabbit and half-human) monsters that yields a shotgun.", "Dungeon");
    Enemy intercepter = new Enemy("Intercepter", "The intercepters are huge, buff, ghost rabbid-type (half-rabbit and half-human) monsters that yields a shotgun.", "Dungeon");
    Enemy wolfScout = new Enemy("Wolf Scout", "The Wolf Scouts are wolf, rabbid-type monsters (half-rabbit and half-human) that looks like wolves and are also masters at long-range attacks.", "Forest");
    Enemy scoper = new Enemy("Scoper", "The Scopers are wolf, rabbid-type monsters (half-rabbit and half-human) or snipers that are masters at long-range attacks.", "Forest");
    Enemy gunner = new Enemy("Gunner", "The Gunners are normal, rabbid-type (half-rabbit and half-human) monsters that has medium-ranged blasters.", "Forest");
    Enemy soldier = new Enemy("Soldier", "The Soldiers are normal, rabbid-type (half-rabbit and half-human) monsters that has medium-ranged blasters.", "Forest");
    Enemy hopper = new Enemy("Hopper", "The hoppers are normal, rabbid-type (half-rabbit and half-human) monsters that has medium-ranged blasters and can jump from other rooms.", "Forest");
    Enemy blaster = new Enemy("Blaster", "The Blasters are normal, rabbid-type (half-rabbit and half-human) monsters that has medium-ranged blasters.", "Forest");
    Enemy slasher = new Enemy("Slasher", "The slashers are normal, rabbid-type (half-rabbit and half-human) monsters that use swords to fight with.", "Forest");
    Enemy ninja = new Enemy("Ninja", "The ninjas are normal, rabbid-type (half-rabbit and half-human) monsters that use kunai to fight with and only do short-range attacks.", "Forest");
    Enemy archer = new Enemy("Archer", "The archers are normal, rabbid-type (half-rabbit and half-human) monsters that use bows and arrows to fight with and are masters at long-range attacks.", "Forest");
    Enemy buckler = new Enemy("Buckler", "The bucklers are huge, buff, rabbid-type (half-rabbit and half-human) monsters that yields a shotgun.", "Forest");   
    Enemy supporter = new Enemy("Supporter", "The supporters are healing, rabbid-type (half-rabbit and half-human) monsters that yields a grenade.", "Forest");
    
    ArrayList<Inventory> bedRoomList = new ArrayList<Inventory>();
    bedRoomList.add(knife);
    bedRoomList.add(welcomeMat);
    bedRoomList.add(parents);

    ArrayList<Inventory> kitchenList = new ArrayList<Inventory>();
    kitchenList.add(pan);
    kitchenList.add(katsu);
    kitchenList.add(ramen);
    kitchenList.add(milktea);
    kitchenList.add(tea);

    ArrayList<Inventory> livingList = new ArrayList<Inventory>();
    livingList.add(smallPainting);
    livingList.add(silverKey);

    ArrayList<Inventory> equipmentList = new ArrayList<Inventory>();
    equipmentList.add(pistol);
    equipmentList.add(sword);
    equipmentList.add(evil);

    ArrayList<Inventory> dungeon2List = new ArrayList<Inventory>();
    dungeon2List.add(apple);
    dungeon2List.add(goldenKey);

    ArrayList<Inventory> dungeon1List = new ArrayList<Inventory>();
    dungeon1List.add(pear);

    ArrayList<Inventory> dungeon3List = new ArrayList<Inventory>();
    dungeon3List.add(banana);

    ArrayList<Inventory> forest1List = new ArrayList<Inventory>();
    forest1List.add(apple);
    forest1List.add(wine);

    ArrayList<Inventory> forest1 = new ArrayList<Inventory>();
    forest1.add(dragonfruit);

    ArrayList<Inventory> forest2List = new ArrayList<Inventory>();
    forest2List.add(pear);
    forest2List.add(water);

    ArrayList<Inventory> forest2 = new ArrayList<Inventory>();
    forest2.add(strawberry);

    ArrayList<Inventory> forest3List = new ArrayList<Inventory>();
    forest3List.add(banana);
    forest3List.add(soda);

    ArrayList<Inventory> forest3 = new ArrayList<Inventory>();
    forest3.add(mango);

    ArrayList<Inventory> forest4List = new ArrayList<Inventory>();
    forest4List.add(blackberry);
    forest4List.add(pepsi);

    ArrayList<Inventory> forest4 = new ArrayList<Inventory>();
    forest4.add(grape);

    ArrayList<Inventory> forest5List = new ArrayList<Inventory>();
    forest5List.add(chicken);
    forest5List.add(mug);

    ArrayList<Inventory> forest5 = new ArrayList<Inventory>();
    forest5.add(beef);

    ArrayList<Enemy> forest1Enemies1 = new ArrayList<Enemy>();
    forest1Enemies1.add(slasher);

    ArrayList<Enemy> forest1Enemies2 = new ArrayList<Enemy>();
    forest1Enemies2.add(soldier);

    ArrayList<Enemy> forest1Enemies3 = new ArrayList<Enemy>();
    forest1Enemies3.add(hopper);

    ArrayList<Enemy> forest2Enemies1 = new ArrayList<Enemy>();
    forest2Enemies1.add(blaster);

    ArrayList<Enemy> forest2Enemies2 = new ArrayList<Enemy>();
    forest2Enemies2.add(wolfScout);

    ArrayList<Enemy> forest2Enemies3 = new ArrayList<Enemy>();
    forest2Enemies3.add(hopper);

    ArrayList<Enemy> forest3Enemies1 = new ArrayList<Enemy>();
    forest3Enemies1.add(ninja);

    ArrayList<Enemy> forest3Enemies2 = new ArrayList<Enemy>();
    forest3Enemies2.add(hopper);

    ArrayList<Enemy> forest3Enemies3 = new ArrayList<Enemy>();
    forest3Enemies3.add(scoper);

    ArrayList<Enemy> forest4Enemies1 = new ArrayList<Enemy>();
    forest4Enemies1.add(gunner);

    ArrayList<Enemy> forest4Enemies2 = new ArrayList<Enemy>();
    forest4Enemies2.add(buckler);

    ArrayList<Enemy> forest4Enemies3 = new ArrayList<Enemy>();
    forest4Enemies3.add(hopper);

    ArrayList<Enemy> forest5Enemies1 = new ArrayList<Enemy>();
    forest5Enemies1.add(supporter);

    ArrayList<Enemy> forest5Enemies2 = new ArrayList<Enemy>();
    forest5Enemies2.add(archer);

    ArrayList<Enemy> forest5Enemies3 = new ArrayList<Enemy>();
    forest5Enemies3.add(hopper);

    ArrayList<Enemy> dungeon1Enemies = new ArrayList<Enemy>();
    dungeon1Enemies.add(vanquisher);
    dungeon1Enemies.add(ghostScout);

    ArrayList<Enemy> dungeon2Enemies = new ArrayList<Enemy>();
    dungeon2Enemies.add(ghoul);
    dungeon2Enemies.add(intercepter);

    ArrayList<Enemy> dungeon3Enemies = new ArrayList<Enemy>();
    dungeon3Enemies.add(haunter);
    dungeon3Enemies.add(ambusher);

    map = new Room[5][9];
		map [0][0] = new Room(false, true, true, false, "Forest", "You are in the forest which is lurking with villains. Pls be careful!!", forest1List,  forest1Enemies1);
    map [1][0] = new Room(true, true, true, false, "Forest", "You are in the forest which is lurking with villains. Pls be careful!!", forest1, forest1Enemies1);
    map [2][0] = new Room(false, true, false, false, "Kitchen Room", "When you enter the kitchen, you see a pan, and a sword. Look around to see.", kitchenList);
    map [3][0] = new Room(true, false, true, false, "Bed Room", "At the start of the game, you wake up in your bedroom. You have nothing in your hands. However, you do see a welcome mat and your mailbox with tons of items in there.", bedRoomList);
    map [4][0] = new Room(false, false, true, false, "Forest", "You are in the forest which is lurking with villains. Pls be careful!!", forest1List, forest1Enemies2);
    map [0][1] = new Room(false, true, true, true, "Forest", "You are in the forest which is lurking with villains. Pls be careful!!", forest1, forest1Enemies2);
    map [1][1] = new Room(true, true, false, true, "Forest", "You are in the forest which is lurking with villains. Pls be careful!!", forest1List, forest1Enemies2);
    map [2][1] = new Room(false, true, true, false, "Equipment Room", "In the Equipment Room, you will find a weapon chest and inside it, you will find various weapons inside it (Psst...It has also your family's weapons too). You can grab all of it or just take one.", equipmentList);
    map [3][1] = new Room(false, false, false, true, "Living Room", "In the Living Room, you will have a locked door to north to the equipment room (Type in use Silver Key'). There is only the small painting and a silver Key inside it to access the Equipment Room. You can take it if you want to.", livingList);
    map [4][1] = new Room(true, false, true, true, "Forest", "You are in the forest which is lurking with villains. Pls be careful!!", forest1List, forest1Enemies3);
    map [0][2] = new Room(false, true, true, true, "Forest", "You are in the forest which is lurking with villains. Pls be careful!!",forest1, forest1Enemies3);
    map [1][2] = new Room(true, true, true, true, "Forest", "You are in the forest which is lurking with villains. Pls be careful!!", forest2List, forest2Enemies1);
    map [2][2] = new Room(true, true, true, true, "Forest", "You are in the forest which is lurking with monsters. Pls be careful!!", forest2, forest2Enemies1);
    map [3][2] = new Room(true, true, true, false, "Forest", "You are in the forest which is lurking with monsters. Pls be careful!!", forest2List, forest2Enemies2);
    map [4][2] = new Room(true, true, true, true, "Forest", "You are in the forest which is lurking with monsters. Pls be careful!!", forest2, forest2Enemies2);
    map [0][3] = new Room(false, true, true, true, "Forest", "You are in the forest which is lurking with monsters. Pls be careful!!", forest2List, forest2Enemies2);
    map [1][3] = new Room(true, true, true, true, "Forest", "You are in the forest which is lurking with monsters. Pls be careful!!", forest2List, forest2Enemies3);
    map [2][3] = new Room(true, true, true, true, "Forest", "You are in the forest which is lurking with monsters. Pls be careful!!", forest2, forest2Enemies3);
    map [3][3] = new Room(true, true, true, true, "Forest", "You are in the forest which is lurking with monsters. Pls be careful!!", forest3List, forest3Enemies1);
    map [4][3] = new Room(true, false, true, true, "Forest", "You are in the forest which is lurking with monsters. Pls be careful!!", forest3, forest3Enemies1);
    map [0][4] = new Room(false, true, true, true, "Forest", "You are in the forest which is lurking with monsters. Pls be careful!!", forest3List, forest3Enemies2);
    map [1][4] = new Room(true, true, true, true, "Forest", "You are in the forest which is lurking with monsters. Pls be careful!!", forest3List, forest3Enemies2);
    map [2][4] = new Room(true, true, true, true, "Forest", "You are in the forest which is lurking with monsters. Pls be careful!!", forest3, forest3Enemies2);
    map [3][4] = new Room(true, true, true, true, "Forest", "You are in the forest which is lurking with monsters. Pls be careful!!", forest3List, forest3Enemies3);
    map [4][4] = new Room(true, false, true, true, "Forest", "You are in the forest which is lurking with monsters. Pls be careful!!", forest3, forest3Enemies3);
    map [0][5] = new Room(false, true, true, true, "Forest", "You are in the forest which is lurking with monsters. Pls be careful!!", forest4List, forest4Enemies1);
    map [1][5] = new Room(true, true, true, true, "Forest", "You are in the forest which is lurking with monsters. Pls be careful!!", forest4List, forest4Enemies1);
    map [2][5] = new Room(true, true, true, true, "Forest", "You are in the forest which is lurking with monsters. Pls be careful!!", forest4, forest4Enemies2);
    map [3][5] = new Room(true, true, true, true, "Forest", "You are in the forest which is lurking with monsters. Pls be careful!!", forest4List, forest4Enemies2);
    map [4][5] = new Room(true, false, true, true, "Forest", "You are in the forest which is lurking with monsters. Pls be careful!!", forest4, forest4Enemies2);
    map [0][6] = new Room(false, true, true, true, "Forest", "You are in the forest which is lurking with monsters. Pls be careful!!", forest4List, forest4Enemies3);
    map [1][6] = new Room(true, true, false, true, "Forest", "You are in the forest which is lurking with monsters. Pls be careful!!", forest4, forest4Enemies3);
    map [2][6] = new Room(true, true, true, true, "Forest", "You are in the forest which is lurking with monsters. Pls be careful!!", forest5List, forest5Enemies1);
    map [3][6] = new Room(true, true, false, true, "Forest", "You are in the forest which is lurking with monsters. Pls be careful!!", forest5, forest5Enemies1);
    map [4][6] = new Room(true, false, true, true, "Forest", "You are in the forest which is lurking with monsters. Pls be careful!!", forest5List, forest5Enemies2);
    map [0][7] = new Room(false, false, true, true, "Forest", "You are in the forest which is lurking with monsters. Pls be careful!!", forest5, forest5Enemies2);
    map [1][7] = new Room(false, true, false, false, "Dungeon 2", "This Dungeon Room also has mobs but it has the key to the Victory Room.", dungeon2List, dungeon2Enemies);
    map [2][7] = new Room(true, true, false, true, "Dungeon 1", "This Dungeon Room is where you find plenty of mobs or monsters inside it. There are two doors to the North and the South. Enter either of them to find the key to the locked door to the east - Type use {item}.", dungeon1List, dungeon1Enemies);
    map [3][7] = new Room(true, true, false, false, "Dungeon 3", "This Dungeon Room only has a lot of mobs and you will have to try to defeat all of it.", dungeon3List, dungeon3Enemies);
    map [4][7] = new Room(true, false, true, true, "Forest", "You are in the forest which is lurking with monsters. Pls be careful!!", forest5List, forest5Enemies2);
    map [0][8] = new Room(false, true, false, true, "Forest", "You are in the forest which is lurking with monsters. Pls be careful!!", forest5, forest5Enemies3);
    map [1][8] = new Room(true, false, false, false, "Forest", "You are in the forest which is lurking with monsters. Pls be careful!!", forest5List, forest5Enemies3);
    map [2][8] = new Room(false, false, false, true, "Victory Room", "When you put the key on this door, you will enter the victory room and win the game! :D");
    map [3][8] = new Room(false, true, false, false, "Forest", "You are in the forest which is lurking with monsters. Pls be careful!!",forest5, forest5Enemies1);
    map [4][8] = new Room(true, false, false, true, "Forest", "You are in the forest which is lurking with monsters. Pls be careful!!", forest5List, forest5Enemies2);

    row = 3;
    column = 0;
    hp = 300;
    currentRoom = map[row][column];

    inventory = new ArrayList<Inventory>();

    villain = new ArrayList<Enemy>();

    String item = "";
    boolean exitGame = false;

    Scanner userCommandInputs = new Scanner(System.in);

    String output = gameIntro();
    System.out.println(output);

    String userInput;
    String command;

    while (!exitGame) {
      System.out.print("~$ ");

      userInput = userCommandInputs.nextLine();

      command = getFirstWord(userInput);

      item = getRestOfSentence(userInput);

      output = executeCommand(command, item);

      updateRoom();

      System.out.println(output + "\n");

      if (getCurrentRoom().getName().equalsIgnoreCase("Victory Room")) {
        gameWon = true;
				if (gameWon == true) {
					exitGame = true;
          System.out.println("You won the game!! Nice job!!\nHow did you like the game?\nIf it was awesome, email me of your experiences at jasonchen050605@gmail.com\n");
          System.out.println("You are finally in " + currentRoom.toString() + currentRoom.getNamesOfObjectsInRoom() + "\n" + currentRoom.getNamesOfEnemiesInRoom());
				}
			}

      if (command.equals("quit")) {
        exitGame = true;
      }

      if (hp <= 0) {
        exitGame = true;
        System.out.println("GAME OVER!! YOU LOST!!");
      }
    }
    userCommandInputs.close();
  }

  public static String map() {
    String out = "";
    for (int r = 0; r <= map.length; r++) {
      for (int c = 0; c <= map[r].length; c++) {
        out += map[r][c].toString();
      }
    }
    return out;
  }

  public static String gameIntro() {
    return "Hello everyone and welcome to the Demon Slayer: Stuck with Rabbids! (a fan collab with Demon Slayer and Rabbids). In this game, you will be Aoi Kanzaki (the main character in the entire game). At the start of the game you will find yourself traveling in time in another world. You are still dressed in your demon slayer uniform but see these new types of demons continuously devouring your demon slayers in front of you, rabbids. You will gather yourself the following items: kitchen items, weapons, and the armor in all of the four rooms in your house that you are in right now. After you get these items, you will also have to try to find the golden key. After you get these items, you will face numerous monsters on your journey. The main goal of the game is to devour and destroy rabbid villains in your way and get to the dungeon to get out of this world as fast as you can. As you get inside the dungeon, you will have two other doors on your left and right. One of these doors will have a key for the golden key. HAVE FUN!! ALSO EMAIL ME IF YOU LIKED THIS GAME: jasonchen050605@gmail.com\nType and input these commands below: \n 1. North (Ex: north) - Moves the player north \n 2. South (Ex: south) - Moves the player south \n 3. East (Ex: east) - Moves the player east \n 4. West (Ex: west) - Moves the player west \n 5. Take (Ex: take sword) - Allows your player to take any item \n 6. Drop (Ex: drop hammer) - Allows you to drop items from your inventory \n 7. Look (Ex: look) - Allows the player to search around the room that he or she is currently in \n 8. Inventory (Ex: inventory) - Allows the player to search the list of items in his or her inventory \n 9. Examine (Ex: examine bow) - Allows the player to examine the item in great detail \n 10. Eat (Ex: eat katsu) - Allows the player to eat certain items and gain health \n 11. Help (Ex: help) - Ask for help and shows you this script \n 12. Attack (Ex: attack goblin) - Allows the player to attack an enemy \n 13. Quit (Ex: quit) - Just allows the player to quit the game \n 14. Hp [your max hp is 300] (ex: hp) - Allows the player to see how much health he or she has\n 15. Killstreak (Ex: killstreak) - Allows the player to search the list of monsters that he or she killed\n 16. Inspect (Ex: inspect gunner) - Allows the player to get a description of monsters that he or she sees\n 17. Drink (Ex: drink soda) - Allows the player to get a sip of drink of that he or she sees to gain health\n 18. Read (read parents envelope) - Allows the player to read messages from an envelope he or she sees\n";
  }
  
  public static String getFirstWord(String input) {
    int index = input.indexOf(" ");
    if (index != -1) {
      return input.substring(0, index);
    } else {
      return input;
    }
  }
  
  public static String getRestOfSentence(String input) {
    int index = input.indexOf(" ");
    if (index != -1) {
      return input.substring(index + 1);
    } else {
      return "";
    }
  }

  public static String north() {
    if (currentRoom.getCanGoNorth()) {
      row--;
      return "You moved north.";
    } else {
      return "You cannot go north.";
    }
  }

  public static String south() {
    if (currentRoom.getCanGoSouth()) {
      row++;
      return "You moved south.";
    } else {
      return "You cannot go south.";
    }
  }

  public static String east() {
    if (currentRoom.getCanGoEast()) {
      column++;
      return "You moved east.";
    } else {
      return "You cannot go east.";
    }
  }

  public static String west() {
    if (currentRoom.getCanGoWest()) {
      column--;
      return "You moved west.";
    } else {
      return "You cannot go west.";
    }
  }

  public static void updateRoom() {
    currentRoom = map[row][column];
  }

  public static Room getCurrentRoom() {
    updateRoom();
    return currentRoom;
  }

  public static String take(String item) {
    String result = "";
    if (currentRoom.hasObject(item) == false) {
      result = "The object is not in this room so you cannot take it";
    } else {
      result = "You took the " + item + ".";
      Inventory i = currentRoom.removeObject(item);
      inventory.add(i);
    }
    return result;
  }

  public static String drop(String objectName) {
    String result = "You cannot drop the object because it is not in your inventory.";
    for (int i = 0; i < inventory.size(); i++) {
      if (inventory.get(i).getName().toLowerCase().equals(objectName.toLowerCase())) {
        result = "You dropped the " + objectName + ".";
        currentRoom.addObject(inventory.get(i));
        inventory.remove(i);
      }
    }
    return result;
  }

  public static String look() {
    return currentRoom.toString() + currentRoom.getNamesOfObjectsInRoom() + "\n" + currentRoom.getNamesOfEnemiesInRoom();
  }

  public static String inventory() {
    String items = "";
    for (int i = 0; i < inventory.size(); i++) {
      items += inventory.get(i) + "\n";
    }
    return "The current items in your inventory are: \n" + items;
  }

  public static String killstreak() {
    String villains = "";
    for (int i = 0; i < villain.size(); i++) {
      villains += villain.get(i) + "\n";
    }
    return "The current monsters that you killed are: \n" + villains;
  }

  public static String examine(String item) {
    String result = "You do not have that item";
    for (int i = 0; i < inventory.size(); i++) {
      if (inventory.get(i).getName().toLowerCase().equals(item.toLowerCase())) {
        result = "Description of the " + item + ": " + inventory.get(i).getDescription();
      }
    }
    return result;
  }

  public static String read(String item) {
    String result = "You do not have that item";
    for (int i = 0; i < inventory.size(); i++) {
      if (inventory.get(i) instanceof Message) {
        if (item.toLowerCase().equalsIgnoreCase("parents envelope")) {
          result = inventory.get(i).getDescription();
          inventory.remove(i);
        } else if (item.toLowerCase().equalsIgnoreCase("evil envelope")) {
          result = inventory.get(i).getDescription();
          inventory.remove(i);
        } else {
          result = "This item is not readable";
        }
      }
    }
    return result;
  }

  public static String inspect(String enemy) {
    String result = "This enemy is not within your sight";
    for (int x = 0; x < villain.size(); x++) {
      if (villain.get(x).getName().toLowerCase().equals(enemy.toLowerCase())) {
        result = "Description of the " + enemy + ": " + villain.get(x).getDescription();
      }
    }
    return result;
  }

  public static String hp() {
    return "You have an hp of: " + hp;
  }

  public static String eat(String item) {
    String result = "That item is not in your inventory";
		for(int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).getName().toLowerCase().equals(item.toLowerCase())) {
				if (inventory.get(i) instanceof Food) {
          if (item.toLowerCase().equalsIgnoreCase("katsu")) {
            if (hp <= 200) {
              hp += 100;
              result = "You ate the " + item + ". and you now have an hp of: " + hp;
              inventory.remove(i);
            } else if (hp > 200) {
              hp = 300;
              result = "You ate the " + item + ". and you now have an hp of: " + hp;
              inventory.remove(i);
            }
          } else if (item.toLowerCase().equalsIgnoreCase("ramen")) {
            if (hp <= 200) {
              hp += 100;
              result = "You ate the " + item + ". and you now have an hp of: " + hp;
              inventory.remove(i);
            } else if (hp > 200) {
              hp = 300;
              result = "You ate the " + item + ". and you now have an hp of: " + hp;
              inventory.remove(i);
            }
          } else if (hp <= 250) {
            hp += 35;
					  result = "You ate the " + item + ". and you now have an hp of: " + hp;
					  inventory.remove(i);
          } else if (hp > 250) {
            hp = 300;
            result = "You ate the " + item + ". and you still have an hp of: " + hp;
            inventory.remove(i);
          }
				} else if(inventory.get(i) instanceof Item) {
					result = "You cannot eat an inventory item.";
				} else {
					result = "That item is not a food";
				}
			}
		}
		return result;
	}

  public static String drink(String item){
		String result = "That item is not in your inventory.";
		for(int i = 0; i < inventory.size(); i++) {
			if(inventory.get(i).getName().toLowerCase().equals(item.toLowerCase())) {
				if(inventory.get(i) instanceof Drink) {
          if (hp <= 240) {
            hp += 50;
					  result = "You drank the " + item + ". Your hp is " + hp;
					  inventory.remove(i);
          } else if (hp > 240) {
            hp = 300;
            result = "You drank the " + item + ". Your hp is " + hp;
					  inventory.remove(i);
          }
				} else if(inventory.get(i) instanceof Food){
					result = "You cannot drink a food.";
				} else if(inventory.get(i) instanceof Item){
					result = "You can't drink items";
			}
		}
 	}
  return result;
}

  public static String use(String item) {
    String result = "Your inventory is empty";
    for (int i = 0; i < inventory.size(); i++) {
      if (inventory.get(i).getName().toLowerCase().equals(item.toLowerCase())) {
        if(item.toLowerCase().equals("golden key")) {
					if(getCurrentRoom().getName().equalsIgnoreCase("Dungeon 1")) {
						//can go east = true instead of false
						map[2][7].setCanGoEast(true);
						//update description
						map[2][7].setDescription("You enter the first dungeon room here you find plenty of mobs or monsters inside it. There are two doors to the North and the South. Enter either of them to find the key to the Victory Room.\nThe door to the victory is to the east and is unlocked.");
						result = "You used the key and the door to the Victory Room opened, you can now move east";
            inventory.remove(i);
					} else {
						result = "This is not the right room to use the key in.";
					}
          result = "You are using the " + item;
        }
        else if (item.toLowerCase().equals("silver key")) {
					if(getCurrentRoom().getName().equalsIgnoreCase("Living Room")) {
						//can go east = true instead of false
						map[3][1].setCanGoNorth(true);
						//update description
						map[3][1].setDescription("You enter the lving room and see the silver key and a small painting. Use the silver key and type 'use silver key' to grant access to the north door to the equipment room\nThe door to the equipment room is to the north and is unlocked.");
						result = "You used the key and the door to the Victory Room opened, you can now move east";
            inventory.remove(i);
					} else {
						result = "This is not the right room to use the key in.";
					}
          result = "You are using the " + item;
        }
      }
    }
    return result;
  }

  public static String attack(String enemyName) {
    String result = "The monster is not in the room so you cannot talk to them";
      if (enemyName.toLowerCase().equalsIgnoreCase("Buckler")) {
        if(currentRoom.hasEnemy("Buckler") == true) {
          result = currentRoom.getEnemy("Buckler");
          hp -= 80;
          Enemy x = currentRoom.removeEnemy(enemyName);
          villain.add(x);
          return "The " + enemyName + " attacked you but you attack it back. Your hp is: " + hp;
        } else {
          result = "That enemy is not in this room so you cannot attack them";
        }
      } else if (enemyName.toLowerCase().equalsIgnoreCase("Wolf Scout")) {
        if (currentRoom.hasEnemy("Wolf Scout") == true) {
          result = currentRoom.getEnemy("Wolf Scout");
          hp -= 55;
          Enemy z = currentRoom.removeEnemy(enemyName);
          villain.add(z);
          return "The " + enemyName + " attacked you but you attack it back. Your hp is: " + hp;
        } else {
          result = "That enemy is not in this room so you cannot attack them";
        }
      } else if (currentRoom.hasEnemy(enemyName) == true) {
        result = currentRoom.getEnemy(enemyName);
        hp -= 40;
        Enemy y = currentRoom.removeEnemy(enemyName);
        villain.add(y);
        return "The " + enemyName + " attacked you but you attack it back. Your hp is: " + hp;
      }
      return result;
  }

  public static String help() {
    return "Commands in this game: \n 1. North (Ex: north) - Moves the player north \n 2. South (Ex: south) - Moves the player south \n 3. East (Ex: east) - Moves the player east \n 4. West (Ex: west) - Moves the player west \n 5. Take (Ex: take sword) - Allows your player to take any item \n 6. Drop (Ex: drop hammer) - Allows you to drop items from your inventory \n 7. Look (Ex: look) - Allows the player to search around the room that he or she is currently in \n 8. Inventory (Ex: inventory) - Allows the player to search the list of items in his or her inventory \n 9. Examine (Ex: examine bow) - Allows the player to examine the item in great detail \n 10. Eat (Ex: eat katsu) - Allows the player to eat certain items and gain health \n 11. Help (Ex: help) - Ask for help and shows you this script \n 12. Attack (Ex: attack goblin) - Allows the player to attack an enemy \n 13. Quit (Ex: quit) - Just allows the player to quit the game \n 14. Hp [max hp is 300] (ex: hp) - Allows the player to see how much health he or she has\n15. Killstreak (Ex: killstreak) - Allows the player to search the list of monsters that he or she killed\n16. Inspect (Ex: inspect gunner) - Allows the player to get a description of monsters that he or she sees\n17. Drink (Ex: drink soda) - Allows the player to get a sip of drink of that he or she sees to gain health\n18. Read (read parents envelope) - Allows the player to read messages from an envelope he or she sees\n";
  }

  public static String quit() {
    return "You have decided to quit the game";
  }

  public static String invalid() {
    return "I do not understand";
  }

  public static String executeCommand(String command, String item) {
    if (command.equalsIgnoreCase("north")) {
      return north();
    }
    if (command.equalsIgnoreCase("south")) {
      return south();
    }
    if (command.equalsIgnoreCase("east")) {
      return east();
    }
    if (command.equalsIgnoreCase("west")) {
      return west();
    }
    if (command.equalsIgnoreCase("take")) {
      return take(item);
    }
    if (command.equalsIgnoreCase("drop")) {
      return drop(item);
    }
    if (command.equalsIgnoreCase("attack")) {
      return attack(item);
    }
    if (command.equalsIgnoreCase("look")) {
      return look();
    }
    if (command.equalsIgnoreCase("inventory")) {
      return inventory();
    }
    if (command.equalsIgnoreCase("killstreak")) {
      return killstreak();
    }
    if (command.equalsIgnoreCase("examine")) {
      return examine(item);
    }
    if (command.equalsIgnoreCase("inspect")) {
      return inspect(item);
    }
    if (command.equalsIgnoreCase("hp")) {
      return hp();
    }
    if (command.equalsIgnoreCase("eat")) {
      return eat(item);
    }
    if (command.equalsIgnoreCase("drink")) {
      return drink(item);
    }
    if (command.equalsIgnoreCase("read")) {
      return read(item);
    }
    if (command.equalsIgnoreCase("use")) {
      return use(item);
    }
    if (command.equalsIgnoreCase("help")) {
      return help();
    }
    if (command.equalsIgnoreCase("quit")) {
      return quit();
    }
    else {
      return invalid();
    }
  }
}