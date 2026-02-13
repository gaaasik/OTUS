package ru.otus.hw7;

public class Horse implements Transport {
    private int stamina;

    public Horse(int stamina) {
        this.stamina = stamina;
    }

    @Override
    public boolean move(int distance, TerrainType terrain) {
        if (terrain == TerrainType.SWAMP) {
            System.out.println("Лошадь не может идти по болоту");
            return false;
        }

        int staminaNeeded = distance;
        if (stamina < staminaNeeded) {
            System.out.println("Лошади не хватает сил. Нужно: " + staminaNeeded + ", осталось: " + stamina);
            return false;
        }

        stamina = stamina - staminaNeeded;
        System.out.println("Лошадь прошла " + distance + " км по местности " + terrain + ". Осталось сил: " + stamina);
        return true;
    }
}
