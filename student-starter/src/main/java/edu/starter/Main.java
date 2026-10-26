package edu.starter;
import java.util.Scanner;
/** Student-owned game entry point; replace this message with your own implementation. */
public final class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int playerHP = 100;
        int resources = 5;
        int enemyHP = 30;
        int pendingDefense = 0;

        /* Initial Test
        System.out.println(playerHP + "," + resources + "," + enemyHP + ",");

        int [] specialAttackResult = specialAttack(enemyHP, resources);
        enemyHP = specialAttackResult[0];
        resources = specialAttackResult[1];

        System.out.println(playerHP + "," + resources + "," + enemyHP + ",");

        playerHP = attack(playerHP, pendingDefense);

        System.out.println(playerHP + "," + resources + "," + enemyHP + ",");
        */

        while(playerHP > 0 && enemyHP > 0) {
            
        }
    }

    public static int attack(int health, int defense) {
        if (health >= 10) {
            return health - (10 - defense);
        } else {
            return 0;
        }
    }

        public static int counterAttack(int health) {
        if (health >= 10) {
            return health - 10;
        } else {
            return 0;
        }
    }

    public static int recover(int resources) {
        if (resources <= 7) {
            return resources + 3;
        } else {
            return 10;
        }
    }

    public static int defend(int defense) {
        return defense + 5;
    }

    public static int[] specialAttack(int enemyHealth, int resources) {
        int [] stats = {enemyHealth, resources};
        if (resources < 3) {
            System.out.println("Not enough resources!");
            return stats;
        } else {
            if (stats[0] >= 15) {
                stats[0] -= 15;
            } else {
                stats[0] = 0;
            }
            stats[1] -= 3;
            return stats;
        }
    }
 }
 
