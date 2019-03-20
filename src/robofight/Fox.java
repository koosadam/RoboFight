package robofight;

import java.util.Random;

public class Fox implements Robot {

    private Field ownPosition;
    private Arena arena;
    private Wolf enemyWolf;
    private int armour;

    public Fox() {
    }

    public Fox(Field ownPosition, Arena arena, Wolf enemyWolf, int armour) {
        this.ownPosition = ownPosition;
        this.arena = arena;
        this.enemyWolf = enemyWolf;
        this.armour = armour;
    }

    @Override
    public Field getOwnPosition() {
        return ownPosition;
    }

    public void setOwnPosition(Field newPosition) {
        ownPosition = newPosition;
    }

    @Override
    public Field getEnemyPosition() {
        return enemyWolf.getOwnPosition();
    }

    public void setEnemyPosition(Field newPosition) {
        enemyWolf.setOwnPosition(newPosition);
    }

    @Override
    public int[] getSizeArena() {
        int[] sizeArena = {arena.getSizeRow(), arena.getSizeColumn()};
        return sizeArena;
    }

    @Override
    public int getOwnArmour() {
        return armour;
    }

    public void setOwnArmour(int newArmour) {
        armour = newArmour;
    }

    @Override
    public int getEnemyArmour() {
        return enemyWolf.getOwnArmour();
    }

    public void setEnemyArmour(int newArmour) {
        enemyWolf.setOwnArmour(newArmour);
    }

    public Arena getArena() {
        return arena;
    }

    public void setArena(Arena arena) {
        this.arena = arena;
    }

    public Wolf getEnemyWolf() {
        return enemyWolf;
    }

    public void setEnemyWolf(Wolf enemyWolf) {
        this.enemyWolf = enemyWolf;
    }

    public void setPositionInArena(Arena arena) {
        arena.setField(ownPosition.getCoordinateRow(), ownPosition.getCoordinateColumn(), "B");
    }

    @Override
    public void move(Direction dir) {
        switch (dir) {
            case NORTH:
                if (ownPosition.getCoordinateRow() > 0) {
                    setOwnPosition(new Field(ownPosition.getCoordinateRow()-1, ownPosition.getCoordinateColumn()));
                }
                break;
            case EAST:
                if (ownPosition.getCoordinateColumn() < arena.getSizeColumn()-1) {
                    setOwnPosition(new Field(ownPosition.getCoordinateRow(), ownPosition.getCoordinateColumn()+1));
                }
                break;
            case SOUTH:
                if (ownPosition.getCoordinateRow() < arena.getSizeRow()-1) {
                    setOwnPosition(new Field(ownPosition.getCoordinateRow() + 1, ownPosition.getCoordinateColumn()));
                }
                break;
            case WEST:
                if (ownPosition.getCoordinateColumn() > 0) {
                    setOwnPosition(new Field(ownPosition.getCoordinateRow(), ownPosition.getCoordinateColumn()-1));
                }
                break;
        }
    }

    @Override
    public void attack(Direction dir) {
        switch (dir) {
            case NORTH:
                if ((ownPosition.getCoordinateRow() > 0) && (ownPosition.getCoordinateColumn() == enemyWolf.getOwnPosition().getCoordinateColumn()) && (ownPosition.getCoordinateRow()-1 == enemyWolf.getOwnPosition().getCoordinateRow())) {
                    setEnemyArmour(getEnemyArmour()-1);
                }
                break;
            case EAST:
                if ((ownPosition.getCoordinateColumn() < arena.getSizeColumn()-1) && (ownPosition.getCoordinateRow() == enemyWolf.getOwnPosition().getCoordinateRow()) && (ownPosition.getCoordinateColumn()+1 == enemyWolf.getOwnPosition().getCoordinateColumn())) {
                    setEnemyArmour(getEnemyArmour()-1);
                }
                break;
            case SOUTH:
                if ((ownPosition.getCoordinateRow() < arena.getSizeRow()-1) && (ownPosition.getCoordinateColumn() == enemyWolf.getOwnPosition().getCoordinateColumn()) && (ownPosition.getCoordinateRow()+1 == enemyWolf.getOwnPosition().getCoordinateRow())) {
                    setEnemyArmour(getEnemyArmour()-1);
                }
                break;
            case WEST:
                if ((ownPosition.getCoordinateColumn() > 0) && (ownPosition.getCoordinateRow() == enemyWolf.getOwnPosition().getCoordinateRow()) && (ownPosition.getCoordinateColumn()-1 == enemyWolf.getOwnPosition().getCoordinateColumn())) {
                    setEnemyArmour(getEnemyArmour()-1);
                }
                break;
        }
    }

    @Override
    public void defend(Direction dir) {
        switch (dir) {
            case NORTH:
                if ((ownPosition.getCoordinateRow() > 0) && (ownPosition.getCoordinateColumn() == enemyWolf.getOwnPosition().getCoordinateColumn()) && (ownPosition.getCoordinateRow()-1 == enemyWolf.getOwnPosition().getCoordinateRow())) {
                    
                }
                break;
            case EAST:
                if ((ownPosition.getCoordinateColumn() < arena.getSizeColumn()-1) && (ownPosition.getCoordinateRow() == enemyWolf.getOwnPosition().getCoordinateRow()) && (ownPosition.getCoordinateColumn()+1 == enemyWolf.getOwnPosition().getCoordinateColumn())) {
                    
                }
                break;
            case SOUTH:
                if ((ownPosition.getCoordinateRow() < arena.getSizeRow()-1) && (ownPosition.getCoordinateColumn() == enemyWolf.getOwnPosition().getCoordinateColumn()) && (ownPosition.getCoordinateRow()+1 == enemyWolf.getOwnPosition().getCoordinateRow())) {
                    
                }
                break;
            case WEST:
                if ((ownPosition.getCoordinateColumn() > 0) && (ownPosition.getCoordinateRow() == enemyWolf.getOwnPosition().getCoordinateRow()) && (ownPosition.getCoordinateColumn()-1 == enemyWolf.getOwnPosition().getCoordinateColumn())) {
                    
                }
                break;
        }
    }

    @Override
    public void stand() {

    }

    public int action() {
        Random rnd = new Random();
        int actionNumber = rnd.nextInt(13);
        switch (actionNumber) {
            case 0:
                stand();
                break;
            case 1:
                move(Direction.NORTH);
                break;
            case 2:
                move(Direction.EAST);
                break;
            case 3:
                move(Direction.SOUTH);
                break;
            case 4:
                move(Direction.WEST);
                break;
            case 5:
                attack(Direction.NORTH);
                break;
            case 6:
                attack(Direction.EAST);
                break;
            case 7:
                attack(Direction.SOUTH);
                break;
            case 8:
                attack(Direction.WEST);
                break;
            case 9:
                defend(Direction.NORTH);
                break;
            case 10:
                defend(Direction.EAST);
                break;
            case 11:
                defend(Direction.SOUTH);
                break;
            case 12:
                defend(Direction.WEST);
                break;
        }
        return actionNumber;
    }

}
