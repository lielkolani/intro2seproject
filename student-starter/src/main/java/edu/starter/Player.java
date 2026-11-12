package edu.starter;

public class Player implements Combatant {
    private int health;
    private int maxHealth;
    private int resources;
    private int pendingDefense;
    private int baseDamage;

    public Player(int health, int maxHealth, int resources, int pendingDefense, int baseDamage) {
        this.health = health;
        this.maxHealth = maxHealth;
        this.resources = resources;
        this.pendingDefense = pendingDefense;
        this.baseDamage = baseDamage;
    }

    @Override
    public void takeDamage(int damage) {
        if ((health - (damage - pendingDefense)) < 0) {
            health = 0;
        } else {
            health -= (damage - pendingDefense);
        }
        pendingDefense = 0;
    }

    @Override
    public int getHealth() {
        return health;
    }

    public int getResources() {
        return resources;
    }

    public int getDefense() {
        return pendingDefense;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void clearDefense() {
        pendingDefense = 0;
    }

    @Override
    public void attack(Combatant enemy) {
        enemy.takeDamage(baseDamage);
    }

    public void defense() {
        pendingDefense += 5;
    }

    public boolean specialAttack(Combatant enemy) {
        if (resources >= 3) {
            resources -= 3;
            enemy.takeDamage(15);
            return true;
        } else {
            return false;
        }
    }

    public boolean recoverResources() {
        if (resources <= 7) {
            resources += 3;
            return true;
        } else if (7 < resources && resources < 10) {
            resources = 10;
            return true;
        } else {
            return false;
        }
    }

    public void recover() {
        if (health <= maxHealth - 25) {
            health += 25;
        } else {
            health = maxHealth;
        }
    }

    public void power() {
        baseDamage += 2;
    }
}