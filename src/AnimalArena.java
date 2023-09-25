import java.util.Random;

public class AnimalArena {
    public static Random rand = new Random();
    public static final int MAXHEALTH = 20;
    public static final int MAXSTRENGTH = 10;
    public static final int MILLIDELAY = 500;


    public static void main(String[] args) {
        animal BiliApe = createAnimalWithDefaultConstructor("BiliApe");
        animal Sloth = createAnimalWithDefaultConstructor("Sloth");
        System.out.println(BiliApe);
        System.out.println(Sloth);
        System.out.println("It's " + BiliApe.getType() + " Vs. " + Sloth.getType() + "!");
        System.out.println("FIGHT!");
        fight(BiliApe, Sloth);

    }

    public static animal createAnimalWithDefaultConstructor(String type){
        animal a = new animal(); //THIS IS USING THE DEFAULT CONSTRUCTOR!
        a.setType(type); //Using Setters
        int startingHealth = rand.nextInt(MAXHEALTH/2) + 1;
        int startingStrangth = rand.nextInt(MAXSTRENGTH) + 1;
        a.setType(type);

        a.sethealth(startingHealth);
        a.setStrength(startingStrangth);
        return a;
    }

    public static animal createAnimalWithParameterizedConstructor(String type){
        int startingHealth = (rand.nextInt(MAXHEALTH/2) + 10);
        int startingStrangth = (rand.nextInt(MAXSTRENGTH) + 1);
        return new animal(type, startingStrangth, startingHealth);
    }

    public static void  fight(animal a1, animal a2){
        while(!a1.isDead() && !a2.isDead()){
            animalAttack(a1, a2);
            if (a2.isDead()){
                System.out.println(a2.getType() + " is dead. " + a1.getType() + " won!");
            }else{
                animalAttack(a2, a1);
                if(a1.isDead()){
                    System.out.println(a1.getType() + " is dead. " + a2.getType() + " won!");
                }
            }
        }
    }

    public static void animalAttack(animal attacker, animal defender){
        int attack = rand.nextInt(attacker.getHealth());
        System.out.println(attacker.getType() + " attacks " + defender.getType() +
                "delivering " + attack + " damage!");
        pause(MILLIDELAY);
        defender.sethealth(defender.getHealth() - attack);
        System.out.println(defender.getType() + " has " +defender.getHealth() + " remaining ");
    }

    public static void pause(int milliseconds){
        try{
            Thread.sleep(milliseconds);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
