package Unit;

import java.util.ArrayList;

public abstract class Archer extends Hero {

    protected int range;
    protected int cartridges;

    public Archer(String name, int speed, float hp, int minDamage, int maxDamage, int attack, int defense, int maxHp,
            int range, int cartridges, int posX, int posY) {
        super(name, hp, speed, minDamage, maxDamage, attack, defense, maxHp, posX, posY);
        this.range = range;
        this.cartridges = cartridges;
    }

    @Override
    public void step(ArrayList<Hero> team1, ArrayList<Hero> team2) {
        if (state.equals("Die") || cartridges == 0) return;
        int target = findNearest(team2);
        float damage = (team2.get(target).defense - attack > 0) ? minDamage : (team2.get(target).defense - attack < 0) ? maxDamage : (maxDamage +minDamage) / 2;
        team2.get(target).getDamage(damage);

        for (int i = 0; i < team1.size(); i++) {
            if (team1.get(i).getInfo().toString().split(":")[0].equals("Крестьянин") && team1.get(i).state.equals("Stand")) {
                team1.get(i).state = "Busy";
                return;
            }
        }
        cartridges--;
    }

    protected boolean findFarmer(ArrayList<Hero> team) {
        ArrayList<Hero> arrayFarmer = new ArrayList<>();
        for (int i = 0; i < team.size(); i++) {
            if (team.get(i).getClass() == Krestyanin.class) {
                if (((Krestyanin) team.get(i)).getCartridgesKrestyanin() > 0) {
                    arrayFarmer.add(team.get(i));
                }
            }
        }
        switch (arrayFarmer.size()) {
            case (0):
                return false;
            case (1):
                ((Krestyanin) arrayFarmer.get(0)).setCartridgesKrestyanin(0);
                return true;
            default:
                ((Krestyanin) arrayFarmer.get(findNearest(arrayFarmer))).setCartridgesKrestyanin(0);
                return true;
        }
    }

}
