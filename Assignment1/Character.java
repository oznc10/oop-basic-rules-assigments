package Assignment1;

public class Character {
    private String name;
    private int health;
    private int attackPower;
    protected Item[] inventory;
    protected Item[] equipment;

    public Character(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    protected void takeDamage(int damage) {
        if (damage > 0) {
            health -= damage;
            if (health <= 0) {
                System.out.print(getName() + " takes " + damage + " damage");
                health = 0;
                System.out.println("(Current Health: 0)");
                return;
            }
            System.out.print(getName() + " takes " + damage + " damage");
            System.out.println("(Current Health: " + health + ")");
        }
    }

    public void addItemToInventory(Item item) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = item;
                break;
            }
        }
    }

    public void removeItemFromInventory(int index) {
        if (index < 0 || index >= inventory.length || inventory[index] == null) {
            return;
        }
        for (int i = index; i < inventory.length - 1; i++) {
            inventory[i] = inventory[i + 1];
        }
        inventory[inventory.length - 1] = null;
    }

    public void equipItemFromInventory(int invIndex) {
        if (invIndex < 0 || invIndex >= inventory.length || inventory[invIndex] == null) {
            return;
        }
        int emptySlot = -1;
        for (int i = 0; i < equipment.length; i++) {
            if (equipment[i] == null) {
                emptySlot = i;
                break;
            }
        }
        if (emptySlot != -1) {
            Item item = inventory[invIndex];
            removeItemFromInventory(invIndex);
            equipment[emptySlot] = item;
            System.out.println(
                    name + " equips " + item.getName() + " from inventory. (BONUS " + item.getBonusType() + ": "
                            + item.getBonusValue() + ")");
        } else {
            System.out.println("ERROR.Equipment slots are full!");
        }
    }

    public void unequipItem(int equipIndex) {
        if (equipIndex < 0 || equipIndex >= inventory.length || inventory[equipIndex] == null) {
            return;
        }
        Item item = equipment[equipIndex];
        for (int i = equipIndex; i < equipment.length - 1; i++) {
            equipment[i] = equipment[i + 1];
        }
        equipment[equipment.length - 1] = null;
        addItemToInventory(item);
        System.out.println(
                name + " removes " + item.getName() + " from equipment. (BONUS " + item.getBonusType() + ": 0)");
    }
}
