package Assignment1;

public class Warrior extends Character {
    private double armor;

    public Warrior(String name, int health, int attackPower, double armor) {
        super(name, health, attackPower);
        this.armor = armor;
        this.inventory = new Item[6];
        this.equipment = new Item[3];
    }

    public double getArmor() {
        return armor;
    }

    @Override
    protected void takeDamage(int damage) {
        warriorTakeDamage(damage, false);
    }

    void warriorTakeDamage(int damage, boolean ignoreArmor) {
        if (ignoreArmor || armor <= 0) {
            super.takeDamage(damage);
        } else {
            System.out.println(getName() + " damage reduced.");
            double damageReduction = 0.05;
            if (armor >= 50) {
                damageReduction = 0.1;
            }
            damage = (int) Math.round(damage * (1 - damageReduction));
            super.takeDamage(damage);
            armor -= 10;
            if (armor < 0) {
                armor = 0;
            }
            System.out.println("Current Armor: " + armor);
        }
    }

    void warriorAttack(Character target) {
        int totalAttackPower = getAttackPower();
        for (int i = 0; i < 3; i++) {
            if (equipment[i] != null && equipment[i].getBonusType().equals("ATTACK")) {
                totalAttackPower += equipment[i].getBonusValue();
            }
        }
        System.out.println(getName() + " attacks " + target.getName() + " with total power " + totalAttackPower);
        target.takeDamage(totalAttackPower);
    }

    @Override
    public String toString() {
        int totalAttackPower = getAttackPower();
        int bonusHealth = 0;
        for (int i = 0; i < equipment.length; i++) {
            if (equipment[i] != null && equipment[i].getBonusType().equals("ATTACK")) {
                totalAttackPower += equipment[i].getBonusValue();
            }
            if (equipment[i] != null && equipment[i].getBonusType().equals("HEALTH")) {
                bonusHealth += equipment[i].getBonusValue();
            }
        }
        return "Warrior " + getName() + " [Current Health: " + getHealth() + ",Total Attack: " + totalAttackPower
                + ",Current Armor: "
                + getArmor() + ",Bonus HEALTH: " + bonusHealth + "]";
    }
}
