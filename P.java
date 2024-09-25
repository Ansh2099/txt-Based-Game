import java.util.Random;
import java.util.Scanner;

public class txtBasedGame{
    public static void main(String[] args){

        methods M = new methods();
        M.showMenu();
    }
}

class methods{

    int health;
    int enemyHealth;
    int enemyAttackDamage;
    int attackDamage;
    int healthPotions;
    int Score;
    Boolean isEnemyDefeated;
    Boolean playerLost;

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

    while(true){

    int number = sc.nextInt();

    switch(number){

      case 1 -> {
         health = 200;
         healthPotions = 10;
         System.out.println("Health: " + health);
         System.out.println("Health Potions: " + healthPotions);
      }
      case 2 -> {
        health = 150;
        healthPotions = 5;
        System.out.println("Health: " + health);
        System.out.println("Health Potions: " + healthPotions);
      }

      case 3 -> {
        health = 100;
        healthPotions = 0;

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

    while(true){

    System.out.println("");
    System.out.println("1. Attack");
    System.out.println("2. Use Health Potion");
    System.out.println("3. Exit the Dungeon");
    System.out.println("");

    int number2 = sc.nextInt();

    switch (number2) {
      case 1 -> {
        Attack();
        if(isEnemyDefeated == true){
          enemies();
          isEnemyDefeated = false;
        } else if(playerLost == true){
          System.out.println("Your Final Score: " + Score);
          return;
        }
      }

      case 2 -> {

        if(health < 200  && healthPotions > 0){

        health += 50;
        healthPotions -= 1;
        System.out.println("You used a Health Potion ");
        System.out.println("");
        System.out.println("Health: " + health);
        System.out.println("Remaining Potions: " + healthPotions);

      } else if(health >= 200){

        System.out.println("Health already Full !!!");

      } else if(healthPotions <= 0){

        System.out.println("No more Health Potions remain !!!");

      }
      }
    
      default -> {

        System.out.println("Thank You for Playing !!!");
        System.out.println("PLease come again");
        return;
      }
    }
  }
}
}

  void enemies(){

    String no1 = "Minotaur";
    String no2 = "Assassin";
    String no3 = "Goblin";
    String no4 = "Slime";
    String no5 = "Giant Spider";

    Random rc = new Random();
    int r = rc.nextInt(5) + 1;

    switch(r){
      case  1 -> { 
        enemyHealth = 100;
        System.out.println(no1 + " has appeared !!!");
        System.out.println("Health:" + enemyHealth);
    }
       case 2 -> {
        enemyHealth = 70;
        System.out.println(no2 + " has appeared !!!");
        System.out.println("Health:" + enemyHealth);
       }

       case 3 -> {
        enemyHealth  = 50;
        System.out.println(no3 + " has appeared !!!");
        System.out.println("Health:" + enemyHealth);
       }

       case 4 -> {
        enemyHealth = 20;
        System.out.println(no4 + " has appeared !!!");
        System.out.println("Health:" + enemyHealth);
       }

       case 5 -> {
        enemyHealth = 150;
        System.out.println(no5 + " has appeared !!!");
        System.out.println("Health:" + enemyHealth);
       }

  }
}

void Attack(){

  Random r = new Random();

  int Damage = r.nextInt(100) + 1;
  int enemyDamage = r.nextInt(attackDamage) + 1;

  health -= enemyAttackDamage;
  enemyHealth -= attackDamage;

  System.out.println("You attacked and dealt " + Damage + "damage");
  System.out.println("The enemy retaliated with " + enemyDamage + "damage");
  System.out.println("Your Remaining Health: " + health);
  System.out.println("Enemy remaining Health: " + enemyHealth);

  if(enemyHealth <= 0){
    System.out.println("Enemy has been DEFEATED !!! ");
    isEnemyDefeated = true;
    Score++;
    return;
  }else if(health <= 0){
    System.out.println("You LOST !!!");
    playerLost = true;
    return;
  }
}
}