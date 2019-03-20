package robofight;

import java.util.Scanner;

public class RoboFight {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Hány soros legyen az aréna? ");
        int numRow = sc.nextInt();
        System.out.print("Hány oszlopos legyen az aréna? ");
        int numColumn = sc.nextInt();
        System.out.print("Hány páncél ponttal induljanak a robotok? ");
        int initArmour = sc.nextInt();
        System.out.print("Hány fordulós legyen legfeljebb a csata? ");
        int maxNumRound = sc.nextInt();

        Arena a = new Arena(numRow, numColumn);

        Wolf w;
        Fox f;
        do {
            w = new Wolf(new Field((int) (Math.random() * numRow), (int) (Math.random() * numColumn), "A"), a, new Fox(), initArmour);
            f = new Fox(new Field((int) (Math.random() * numRow), (int) (Math.random() * numColumn), "B"), a, w, initArmour);
        } while ((w.getOwnPosition().getCoordinateRow() == f.getOwnPosition().getCoordinateRow()) && (w.getOwnPosition().getCoordinateColumn() == f.getOwnPosition().getCoordinateColumn()));
        w.setEnemyFox(f);
        w.setPositionInArena(a);
        f.setPositionInArena(a);

        System.out.println("Nyomjon \"ENTER\"-t a következő fordulóhoz!");
        sc.nextLine();

        int counter = 0;
        while ((counter < maxNumRound) && (w.getOwnArmour() > 0) && (f.getOwnArmour() > 0)) {

            System.out.println(counter + ". kör");
            a.draw();
            System.out.println("");
            System.out.println("\"A\" robot: " + w.getClass().getSimpleName() + ".class");
            System.out.println("Páncél: " + w.getOwnArmour() + "/" + initArmour);
            System.out.println("");
            System.out.println("\"B\" robot: " + f.getClass().getSimpleName() + ".class");
            System.out.println("Páncél: " + f.getOwnArmour() + "/" + initArmour);

            Field tmpWField = new Field(w.getOwnPosition().getCoordinateRow(), w.getOwnPosition().getCoordinateColumn());
            Field tmpFField = new Field(f.getOwnPosition().getCoordinateRow(), f.getOwnPosition().getCoordinateColumn());

            int wAction = w.action();
            int fAction = f.action();

            boolean wolfDefendNorth = (wAction == 9 && fAction == 7) && (w.getOwnPosition().getCoordinateColumn() == f.getOwnPosition().getCoordinateColumn()) && (w.getOwnPosition().getCoordinateRow() - 1 == f.getOwnPosition().getCoordinateRow());
            boolean wolfDefendEast = (wAction == 10 && fAction == 8) && (w.getOwnPosition().getCoordinateRow() == f.getOwnPosition().getCoordinateRow()) && (w.getOwnPosition().getCoordinateColumn() + 1 == f.getOwnPosition().getCoordinateColumn());
            boolean wolfDfendSouth = (wAction == 11 && fAction == 5) && (w.getOwnPosition().getCoordinateColumn() == f.getOwnPosition().getCoordinateColumn()) && (w.getOwnPosition().getCoordinateRow() + 1 == f.getOwnPosition().getCoordinateRow());
            boolean wolfDefendWest = (wAction == 12 && fAction == 6) && (w.getOwnPosition().getCoordinateRow() == f.getOwnPosition().getCoordinateRow()) && (w.getOwnPosition().getCoordinateColumn() - 1 == f.getOwnPosition().getCoordinateColumn());
            if (wolfDefendNorth || wolfDefendEast || wolfDfendSouth || wolfDefendWest) {
                w.setOwnArmour(w.getOwnArmour() + 1);
            }

            boolean foxDefendNorth = (fAction == 9 && wAction == 7) && (f.getOwnPosition().getCoordinateColumn() == w.getOwnPosition().getCoordinateColumn()) && (f.getOwnPosition().getCoordinateRow() - 1 == w.getOwnPosition().getCoordinateRow());
            boolean foxDefendEast = (fAction == 10 && wAction == 8) && (f.getOwnPosition().getCoordinateRow() == w.getOwnPosition().getCoordinateRow()) && (f.getOwnPosition().getCoordinateColumn() + 1 == w.getOwnPosition().getCoordinateColumn());
            boolean foxDfendSouth = (fAction == 11 && wAction == 5) && (f.getOwnPosition().getCoordinateColumn() == w.getOwnPosition().getCoordinateColumn()) && (f.getOwnPosition().getCoordinateRow() + 1 == w.getOwnPosition().getCoordinateRow());
            boolean foxDefendWest = (fAction == 12 && wAction == 6) && (f.getOwnPosition().getCoordinateRow() == w.getOwnPosition().getCoordinateRow()) && (f.getOwnPosition().getCoordinateColumn() - 1 == w.getOwnPosition().getCoordinateColumn());
            if (foxDefendNorth || foxDefendEast || foxDfendSouth || foxDefendWest) {
                f.setOwnArmour(f.getOwnArmour() + 1);
            }

            if ((w.getOwnPosition().getCoordinateRow() == f.getOwnPosition().getCoordinateRow()) && (w.getOwnPosition().getCoordinateColumn() == f.getOwnPosition().getCoordinateColumn())) {
                w.setOwnPosition(tmpWField);
                f.setOwnPosition(tmpFField);
            } else {
                a.setField(tmpWField.getCoordinateRow(), tmpWField.getCoordinateColumn(), ".");
                w.setPositionInArena(a);
                a.setField(tmpFField.getCoordinateRow(), tmpFField.getCoordinateColumn(), ".");
                f.setPositionInArena(a);
            }

            counter++;
            System.out.println("");
            System.out.println("Nyomjon \"ENTER\"-t a következő fordulóhoz!");
            sc.nextLine();
        }

        System.out.println(counter + ". kör");
        a.draw();
        System.out.println("");
        System.out.println("\"A\" robot: " + w.getClass().getSimpleName() + ".class");
        System.out.println("Páncél: " + w.getOwnArmour() + "/" + initArmour);
        System.out.println("");
        System.out.println("\"B\" robot: " + f.getClass().getSimpleName() + ".class");
        System.out.println("Páncél: " + f.getOwnArmour() + "/" + initArmour);

        System.out.println("");
        if (w.getOwnArmour() == 0) {
            System.out.println("A \"B\" robot nyert!");
        } else if (f.getOwnArmour() == 0) {
            System.out.println("Az \"A\" robot nyert!");
        } else if (w.getOwnArmour() > f.getOwnArmour()) {
            System.out.println("Az \"A\" robot nyert!");
        } else if (w.getOwnArmour() < f.getOwnArmour()) {
            System.out.println("A \"B\" robot nyert!");
        } else {
            System.out.println("A mérkőzés döntetlen!");
        }
    }

}
