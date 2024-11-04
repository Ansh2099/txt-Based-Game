import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class txtBasedGame{
    public static void main(String[] args){

        methods gameMethods = new methods();
        gameMethods.showMenu();
    }
}

class methods{

    int health;
    int enemyHealth;
    int enemyDamage;
    int damage;
    int healthPotions;
    int Score;
    Boolean isEnemyDefeated;
    Boolean playerLost;
    Boolean isUltimateAttackActivated = false;
    int noOfEnemyDefeated = 2;

    Scanner sc = new Scanner(System.in);

    void showMenu(){

        System.out.println("****************************************************");
        System.out.println("");
        System.out.println("Welcome to the Dungeon !!!");
        System.out.println("");
        System.out.println("****************************************************");
        System.out.println("Choose your Difficulty");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        System.out.println("");
        System.out.println("****************************************************");

        try {
            while (true) {
                int number = 0;
                boolean validInput = false;

                while (!validInput) {
                    try {
                        number = sc.nextInt();
                        validInput = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input, please enter a valid number (1, 2, or 3).");
                        sc.next(); // Clear the invalid input
                    }
                }

                switch (number) {
                    case 1 -> {
                        health = 200;
                        healthPotions = 10;
                        System.out.println("");
                        System.out.println("Health: " + health);
                        System.out.println("Health Potions: " + healthPotions);
                    }
                    case 2 -> {
                        health = 150;
                        healthPotions = 5;
                        System.out.println("");
                        System.out.println("Health: " + health);
                        System.out.println("Health Potions: " + healthPotions);
                    }
                    case 3 -> {
                        health = 100;
                        healthPotions = 0;
                        System.out.println("");
                        System.out.println("Health: " + health);
                        System.out.println("Health Potions: " + healthPotions);
                    }
                    default -> {
                        System.out.println("Please enter a valid number.");
                        break;
                    }
                }

                System.out.println("");
                System.out.println("Off you go !!");
                System.out.println("");

                enemies();

                isEnemyDefeated = false;
                playerLost = false;

                while (true) {

                    if (isEnemyDefeated == true) {
                        enemies();
                        if (noOfEnemyDefeated > 0) {
                            noOfEnemyDefeated--;
                        } else if (noOfEnemyDefeated == 0) {
                            isUltimateAttackActivated = true;
                            noOfEnemyDefeated = 2;
                        }

                        isEnemyDefeated = false;

                    } else if (playerLost == true) {

                        System.out.println("Your Final Score: " + Score);
                        System.out.println("");
                        System.out.println("Thank You for Playing !!!");
                        System.out.println("PLease come again :)");
                        return;
                    }

                    System.out.println("");
                    System.out.println("1. Attack");
                    System.out.println("2. Use Health Potion");
                    System.out.println("3. Exit the Dungeon");
                    System.out.println("");

                    int number2 = 0;
                    validInput = false;

                    while (!validInput) {
                        try {
                            number2 = sc.nextInt();
                            validInput = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input, please enter a valid number (1, 2, or 3).");
                            sc.next(); // Clear the invalid input
                        }
                    }

                    switch (number2) {
                        case 1 -> Attack();
                        case 2 -> useHealthPotions();
                        case 3 -> {
                            System.out.println("");
                            System.out.println("Your Final Score: " + Score);
                            System.out.println("");
                            System.out.println("Thank You for Playing !!!");
                            System.out.println("PLease come again :)");
                            return;
                        }
                        default -> System.out.println("Please Enter a valid number !!!");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    void enemies() {
        String no1 = "Minotaur";
        String no2 = "Assassin";
        String no3 = "Goblin";
        String no4 = "Slime";
        String no5 = "Giant Spider";
        String no6 = "Mummified Soldier";
        String no7 = "Giant Slime";

        Random rc = new Random();
        int r = rc.nextInt(7) + 1;

        switch (r) {
            case 1 -> {
                enemyHealth = 120;
                System.out.println("****************************************************");
                System.out.println(no1 + " has appeared !!!");
                System.out.println("Health:" + enemyHealth);
            }
            case 2 -> {
                enemyHealth = 75;
                System.out.println("****************************************************");
                System.out.println(no2 + " has appeared !!!");
                System.out.println("Health:" + enemyHealth);
            }
            case 3 -> {
                enemyHealth = 50;
                System.out.println("****************************************************");
                System.out.println(no3 + " has appeared !!!");
                System.out.println("Health:" + enemyHealth);
            }
            case 4 -> {
                enemyHealth = 20;
                System.out.println("****************************************************");
                System.out.println(no4 + " has appeared !!!");
                System.out.println("Health:" + enemyHealth);
            }
            case 5 -> {
                enemyHealth = 150;
                System.out.println("****************************************************");
                System.out.println(no5 + " has appeared !!!");
                System.out.println("Health:" + enemyHealth);
            }
            case 6 -> {
                enemyHealth = 90;
                System.out.println("****************************************************");
                System.out.println(no6 + " has appeared !!!");
                System.out.println("Health:" + enemyHealth);
            }
            case 7 -> {
                enemyHealth = 80;
                System.out.println("****************************************************");
                System.out.println(no7 + " has appeared !!!");
                System.out.println("Health:" + enemyHealth);
            }
        }
    }

    void Attack() {

        Random r = new Random();

        if (isUltimateAttackActivated == true) {
            damage = enemyHealth;

        } else {
            damage = r.nextInt(55) + 1;
        }

        enemyDamage = r.nextInt(damage) + 1;

        health -= enemyDamage;
        enemyHealth -= damage;

        if (isUltimateAttackActivated == true) {

            System.out.println("You used your ULTIMATE ATTACK");
            System.out.println("THE ENEMY HAS PERISHED FROM THE FACE OF THE EARTH");
            System.out.println("");
            isUltimateAttackActivated = false;

        } else if (isUltimateAttackActivated == false) {

            System.out.println("");
            System.out.println("You attacked and dealt " + damage + " damage");
            System.out.println("The enemy retaliated with " + enemyDamage + " damage");
            System.out.println("");
            System.out.println("Your Remaining Health: " + health);
            System.out.println("Enemy remaining Health: " + enemyHealth);
            System.out.println("");
        }

        if (enemyHealth <= 0) {

            System.out.println("Enemy has been DEFEATED !!! ");
            System.out.println("");
            System.out.println("No of Enemies to Ultimate Attack: " + noOfEnemyDefeated);
            System.out.println("");

            if (noOfEnemyDefeated == 0) {

                System.out.println("ULTIMATE ATTACK AVAILABLE !!!");
                System.out.println("");
            }

            isEnemyDefeated = true;
            Score++;

        } else if (health <= 0) {

            System.out.println("You LOST !!!");
            playerLost = true;
        }
    }

    void useHealthPotions() {
        if (health < 200 && healthPotions > 0) {

            health += 50;
            healthPotions -= 1;
            System.out.println("You used a Health Potion ");
            System.out.println("");
            System.out.println("Health: " + health);
            System.out.println("Remaining Potions: " + healthPotions);

        } else if (health >= 200) {

            System.out.println("Health already Full !!!");

        } else if (healthPotions <= 0) {

            System.out.println("No more Health Potions remain !!!");
        }
    }
}
