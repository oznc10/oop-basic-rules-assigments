package Assignment1;

public class Item {
    private String name;
    private String bonusType;
    private int bonusValue;

    public Item(String name, String bonusType, int bonusValue) {
        this.name = name;
        this.bonusType = bonusType;
        this.bonusValue = bonusValue;
    }

    public String getName() {
        return name;
    }

    public String getBonusType() {
        return bonusType;
    }

    public int getBonusValue() {
        return bonusValue;
    }

    @Override
    public String toString() {
        return name + " [" + bonusType + " BONUS: " + bonusValue + "]";
    }
}