package Unit;

import java.util.ArrayList;

public abstract class Hero implements GameInterfase {

    public String name;
    protected float hp;
    protected int speed;
    protected int minDamage;
    protected int maxDamage;
    protected int attack;
    protected int defense;
    protected int maxHp;
    protected Vector2D coords;
    public String state;

    public Hero(String name, float hp, int speed, int minDamage, int maxDamage, int attack, int defense, int maxHp,
            int posX, int posY) {
        this.name = name;
        this.speed = speed;
        this.hp = hp;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.attack = attack;
        this.defense = defense;
        this.maxHp = maxHp;
        coords = new Vector2D(posX, posY);
        state = "Stand";
    }

    public int getSpeed() {
        return this.speed;
    }

    public float getHp() {
        return this.hp;
    }

    @Override
    public void step(ArrayList<Hero> team1, ArrayList<Hero> team2) {
    }

    protected int findNearest(ArrayList<Hero> team) {
        double min = 100;
        int index = 0;
        for (int i = 0; i < team.size(); i++) {
            if (min > coords.getDistance(team.get(i).coords) & !team.get(i).state.equals("Die")) {
                index = i;
                min = coords.getDistance(team.get(i).coords);
            }
        }
        return index;
    }

    protected void getDamage(float damage) {
        hp -= damage;
        if (hp > maxHp)
            hp = maxHp;
        if (hp < 0)
            state = "Die";
    }

    @Override
    public StringBuilder getInfo() {
        return new StringBuilder();
    }
}