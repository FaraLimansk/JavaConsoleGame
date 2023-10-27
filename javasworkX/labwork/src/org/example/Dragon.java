package org.example;

public class Dragon {
    int health;
    int defense;
    int damage;
    boolean weapon;
    int weaponDamage;

    Dragon(int health, int defense, int damage, int weaponDamage, boolean weapon){
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.weaponDamage = weaponDamage;
        this.weapon = weapon;
    }

    void castFireBolt(Hero target){
        if(target.shield){
            System.out.println("Hero reflected fire bolt.");
        }else{
            target.health -= damage * 2;
            System.out.println("Dragon threw fire bolt to hero and deal " + damage * 2 + " damage.");
        }
        if(target.health <= 0){
            Main.endOfBattle = true;
        }
    }

    void attack(Hero target){
        if(this.health < 0){
            return;
        }
        int totalDamage = damage;
        if(weapon){
            totalDamage += weaponDamage;
        }
        int total = target.shield ? (totalDamage - (target.defense + target.shieldDefense)) : (totalDamage - target.defense);
        target.health -= total;

        System.out.println("Dragon hits hero on " + total + " damage.");

        if(target.health <= 0){
            Main.endOfBattle = true;
        }
    }
}
