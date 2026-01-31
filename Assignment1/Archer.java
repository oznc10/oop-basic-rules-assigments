package Proje4;

public class Archer extends Character {
    private int accuracy;

    public Archer(String name, int health, int attackPower, int accuracy) {
        super(name, health, attackPower);
        this.accuracy = accuracy;
        this.inventory = new Item[4];
        this.equipment = new Item[2];
    }

    public int getAccuracy() {
        return accuracy;
    }

    void archerAttack(Character target) {
        int totalAttackPower = getAttackPower();
        int totalAccuracy = accuracy;
        for (int i = 0; i < equipment.length; i++) {
            if (equipment[i] != null && equipment[i].getBonusType().equals("ATTACK")) {
                totalAttackPower += equipment[i].getBonusValue();
            }
            if (equipment[i] != null && equipment[i].getBonusType().equals("ACCURACY")) {
                totalAccuracy += equipment[i].getBonusValue();
            }
        }
        if (totalAccuracy >= 80) {
            totalAttackPower += 5;
        }
        System.out.println(getName() + " attacks " + target.getName() + " with total power " + totalAttackPower);
        target.takeDamage(totalAttackPower);
    }

    @Override
    public String toString() {
        int totalAttackPower = getAttackPower();
        int bonusAccuracy = 0;
        for (int i = 0; i < equipment.length; i++) {
            if (equipment[i] != null && equipment[i].getBonusType().equals("ATTACK")) {
                totalAttackPower += equipment[i].getBonusValue();
            }
            if (equipment[i] != null && equipment[i].getBonusType().equals("ACCURACY")) {
                bonusAccuracy += equipment[i].getBonusValue();
            }
        }
        return "Archer " + getName() + " [Current Health: " + getHealth() + ", Total Attack: " + totalAttackPower
                + ", Accuracy: "
                + getAccuracy() + ", BONUS ACCURACY: " + bonusAccuracy + "]";
    }
}
