package edu.starter;

public interface Combatant {

    public void takeDamage(int damage);

    public int getHealth();

    public void attack(Combatant enemy);

}
