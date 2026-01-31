package Assignment1;

public class Mage extends Character {
    private int mana;

    public Mage(String name, int health, int attackPower, int mana) {
        super(name, health, attackPower);
        this.mana = mana;
        this.inventory = new Item[2];
        this.equipment = new Item[1];
    }

    public int getMana() {
        return mana;
    }

    void mageAttack(Character target) {
        int spellDamage = getAttackPower();
        if (mana >= 10) {
            spellDamage += 5;
            for (int i = 0; i < equipment.length; i++) {
                if (equipment[i] != null && equipment[i].getBonusType().equals("ATTACK")) {
                    spellDamage += equipment[i].getBonusValue();
                }
            }
            System.out.println(
                    getName() + " casts a spell on " + target.getName() + " dealing " + spellDamage + " damage.");
            target.takeDamage(spellDamage);
            mana -= 10;
            System.out.println(getName() + "'s remaining mana: " + mana);
        } else {
            target.takeDamage(spellDamage);
        }
    }

    @Override
    public String toString() {
        int totalAttackPower = getAttackPower();
        int bonusMana = 0;
        for (int i = 0; i < equipment.length; i++) {
            if (equipment[i] != null && equipment[i].getBonusType().equals("ATTACK")) {
                totalAttackPower += equipment[i].getBonusValue();
            }
            if (equipment[i] != null && equipment[i].getBonusType().equals("MANA")) {
                bonusMana += equipment[i].getBonusValue();
            }
        }
        return "Mage " + getName() + " [Current Health: " + getHealth() + ", Total Attack: " + totalAttackPower
                + ", Current Mana: "
                + getMana() + ", Bonus MANA: " + bonusMana + "]";
    }
}
