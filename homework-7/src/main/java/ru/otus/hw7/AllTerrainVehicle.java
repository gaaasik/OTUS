package ru.otus.hw7;

public class AllTerrainVehicle implements Transport {
    private int fuel;

    public AllTerrainVehicle(int fuel) {
        this.fuel = fuel;
    }

    @Override
    public boolean move(int distance, TerrainType terrain) {
        int fuelNeeded = distance;
        if (fuel < fuelNeeded) {
            System.out.println("Вездеходу не хватает бензина. Нужно: " + fuelNeeded + ", осталось: " + fuel);
            return false;
        }

        fuel = fuel - fuelNeeded;
        System.out.println("Вездеход проехал " + distance + " км по местности " + terrain + ". Осталось бензина: " + fuel);
        return true;
    }
}
