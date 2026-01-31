package Assignment1;

public class Main {
    public static void main(String[] args) {
        // Create characters.
        Warrior warrior = new Warrior("Conan", 100, 15, 60);
        Mage mage = new Mage("Merlin", 80, 10, 30);
        Archer archer = new Archer("Robin", 70, 12, 75);

        // Create and equip items.
        warrior.addItemToInventory(new Item("Sword of Might", "ATTACK", 5));
        warrior.addItemToInventory(new Item("Shield of Valor", "HEALTH", 15));
        warrior.addItemToInventory(new Item("Rune of Power", "ACCURACY", 5));
        warrior.equipItemFromInventory(0); // Equips Sword of Might (Bonus ATTACK: 5)
        warrior.equipItemFromInventory(0); // Equips Shield of Valor (Bonus HEALTH: 15)

        mage.addItemToInventory(new Item("Mystic Staff", "MANA", 10));
        mage.addItemToInventory(new Item("Rune of Fury", "ATTACK", 5));
        mage.equipItemFromInventory(0); // Equips Mystic Staff (Bonus MANA: 10)

        archer.addItemToInventory(new Item("Longbow", "ATTACK", 4));
        archer.addItemToInventory(new Item("Quiver of Precision", "ACCURACY", 5));
        archer.equipItemFromInventory(0); // Equips Longbow (Bonus ATTACK: 4)
        archer.equipItemFromInventory(0); // Equips Quiver of Precision (Bonus ACCURACY: 5)

        // Short combat simulation.
        System.out.println("\n--- Combat Simulation ---");
        // Warrior attacks Mage.
        warrior.warriorAttack(mage);
        // Mage attacks Archer.
        mage.mageAttack(archer);
        // Archer attacks Warrior.
        archer.archerAttack(warrior);

        // Removal test: Mage unequips its equipment.
        System.out.println("\n--- Removal Test ---");
        mage.unequipItem(0); // Should remove Mystic Staff and show bonus as 0.

        // Final status.
        System.out.println("\n--- Final Stats ---");
        System.out.println(warrior);
        System.out.println(mage);
        System.out.println(archer);
    }
}