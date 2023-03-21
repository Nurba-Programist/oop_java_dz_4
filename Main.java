import Unit.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

import Unit.Arbaletchik;
import Unit.Hero;
import Unit.Koldun;
import Unit.Kopeishik;
import Unit.Krestyanin;
import Unit.Monah;
import Unit.Razboinik;
import Unit.Sniper;

public class Main {
    static final int UNITS = 10;

    public static void main(String[] args) {

        ArrayList<Hero> holyTeam = new ArrayList<>();
        ArrayList<Hero> darkTeam = new ArrayList<>();
        ArrayList<Hero> allTeam = new ArrayList<>();
        try (Scanner user_input = new Scanner(System.in)) {
            createTeam(holyTeam, 0, 1);
            createTeam(darkTeam, 3, 10);
            allTeam.addAll(holyTeam);
            allTeam.addAll(darkTeam);
            sortTeam(allTeam);

            for (Hero hero : allTeam) {
                if (holyTeam.contains(hero))
                    hero.step(holyTeam, darkTeam);
                else
                    hero.step(darkTeam, holyTeam);
            }

            while (true) {
                user_input.nextLine();

            }
        }

    }

    static void createTeam(ArrayList team, int offset, int posY) {
        for (int i = 0; i < UNITS; i++) {
            int rnd = new Random().nextInt(4) + offset;
            switch (rnd) {
                case (0):
                    team.add(new Sniper(getName(), new Vector2D(i + 1, posY)));
                    break;
                case (1):
                    team.add(new Arbaletchik(getName(), new Vector2D(i + 1, posY)));
                    break;
                case (2):
                    team.add(new Koldun(getName(), new Vector2D(i + 1, posY)));
                    break;
                case (3):
                    team.add(new Kopeishik(getName(), new Vector2D(i + 1, posY)));
                    break;
                case (4):
                    team.add(new Krestyanin(getName(), new Vector2D(i + 1, posY)));
                    break;
                case (5):
                    team.add(new Razboinik(getName(), new Vector2D(i + 1, posY)));
                    break;
                case (6):
                    team.add(new Monah(getName(), new Vector2D(i + 1, posY)));
                    break;
            }
        }
    }

    private static String getName() {
        return null;
    }

    private static void sortTeam(ArrayList<Hero> allTeam) {
    }

}