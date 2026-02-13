package ru.otus.hw7;

public class Car implements Transport {
    private int fuel;

    public Car(int fuel) {
        this.fuel = fuel;
    }

    @Override
    public boolean move(int distance, TerrainType terrain) {
        if (terrain == TerrainType.DENSE_FOREST || terrain == TerrainType.SWAMP) {
            System.out.println("Машина не может ехать по местности: " + terrain);
            return false;
        }

        int fuelNeeded = distance;
        if (fuel < fuelNeeded) {
            System.out.println("Машине не хватает бензина. Нужно: " + fuelNeeded + ", осталось: " + fuel);
            return false;
        }

        fuel = fuel - fuelNeeded;
        System.out.println("Машина проехала " + distance + " км по местности " + terrain + ". Осталось бензина: " + fuel);
        return true;
    }
}
