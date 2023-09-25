public class animal {
    private String type;
    private int strength;
    private int health;

    public animal() {
        this.type = " ";
        this.health = 0;
        this.strength = 1;
    }

    public animal(String type, int strength, int health) {
        setType(type);
        setStrength(strength);
        this.health = health;
    }


    public void SetType(String type) {
        this.type = type;
    }

    public int getHealth() {
        return health;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void sethealth(int health) {
        if (health < 0) {
            this.health = 0;
        } else {
            this.health = health;
        }


    }

    public boolean isDead(){
        return health <= 0;
    }

    public void setStrength(int strength) {
        if (strength <= 0) {
            this.strength = 1;
        } else {
            this.strength = strength;
        }
    }
    @Override
    public String toString(){
        return "Type: " + type + "; Strength " + strength + ": Health" + health;
    }
}
