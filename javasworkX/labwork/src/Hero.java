package org.example;

public class Hero {
    int health;
    int defense;
    int damage;
    boolean weapon;
    int weaponDamage;
    int shieldDefense;

    boolean shield;
    boolean havePotion = true;

    Hero(int health, int defense, int damage, int weaponDamage, int shieldDefense, boolean weapon, boolean shield){
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.weaponDamage = weaponDamage;
        this.shieldDefense = shieldDefense;
        this.weapon = weapon;
        this.shield = shield;
    }

    void drinkPotion(){
        health += 500;
        System.out.println("Hero drank potion and healed on 100.");
    }

    void attack(Dragon target){
        if(this.health < 0){
            return;
        }
        int totalDamage = damage;
        if(weapon){
            totalDamage += weaponDamage;
        }
        target.health -= (totalDamage - target.defense);
        System.out.println("Hero hits dragon on " + (totalDamage - target.defense) + " damage.");
        if(target.health <= 0){
            Main.endOfBattle = true;
        }
    }
}
