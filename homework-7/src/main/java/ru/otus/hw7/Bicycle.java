package ru.otus.hw7;

public class Bicycle implements Transport {

    @Override
    public boolean move(int distance, TerrainType terrain) {
        System.out.println("Ошибка: используйте move с водителем для велосипеда");
        return false;
    }

    public boolean move(int distance, TerrainType terrain, Human driver) {
        if (terrain == TerrainType.SWAMP) {
            System.out.println("Велосипед не может ехать по болоту");
            return false;
        }

        int staminaNeeded = distance;
        if (driver.getStamina() < staminaNeeded) {
            System.out.println("Водителю не хватает сил для поездки на велосипеде. Нужно: " + staminaNeeded + ", осталось: " + driver.getStamina());
            return false;
        }

        driver.reduceStamina(staminaNeeded);
        System.out.println("Велосипед проехал " + distance + " км по местности " + terrain + ". Осталось сил у водителя: " + driver.getStamina());
        return true;
    }
}
