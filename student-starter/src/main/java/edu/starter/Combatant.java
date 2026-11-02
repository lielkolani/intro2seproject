package edu.starter;

public class Combatant {
    private int health;
    private int resources;
    private int pendingDefense;

    public Combatant(int health, int resources, int pendingDefense) {
        this.health = health;
        this.resources = resources;
        this.pendingDefense = 0;
    }

    public void takeDamage(int damage) {
        if ((health - (damage - pendingDefense)) < 0) {
            health = 0;
            
        } else {
            health -= (damage - pendingDefense);
            pendingDefense = 0;
        }
    }

    public int getHealth() {
        return health;
    }

    public boolean isDefeated() {
        return health == 0;
    }

    public void recoverResources() {
        if (resources <= 7) {
            resources += 3;
        } else {
            resources = 10;
        }
    }

    public void attack(Combatant enemy) {
        enemy.takeDamage(10);
    }

    public void defense() {
        pendingDefense += 5;
    }

    public void specialAttack(Combatant enemy) {
        if (resources >= 3) {
            enemy.takeDamage(15);
            resources -= 3;
        } else {
            System.out.println("Not enough resources!");
        }

    }
}
