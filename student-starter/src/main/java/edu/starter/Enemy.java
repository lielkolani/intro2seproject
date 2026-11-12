package edu.starter;

public class Enemy implements Combatant {
    private int health;
    private int maxHealth;

    public Enemy(int health, int maxHealth) {
        this.health = health;
        this.maxHealth = maxHealth;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public void attack(Combatant player) {
        player.takeDamage(10);
    }

    public int getHealth() {
        return health;
    }
}
