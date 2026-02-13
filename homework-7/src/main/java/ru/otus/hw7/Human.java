package ru.otus.hw7;

public class Human {
    private String name;
    private Transport currentTransport;
    private int stamina;

    public Human(String name, int stamina) {
        this.name = name;
        this.stamina = stamina;
    }

    public int getStamina() {
        return stamina;
    }

    public void reduceStamina(int amount) {
        stamina = stamina - amount;
    }

    public void setTransport(Transport transport) {
        this.currentTransport = transport;
        String preposition = getPreposition(transport);
        System.out.println(name + " сел " + preposition + " " + getTransportName(transport));
    }

    public void removeTransport() {
        if (currentTransport != null) {
            String preposition = getPrepositionFrom(currentTransport);
            String transportName = getTransportNameFrom(currentTransport);
            this.currentTransport = null;
            System.out.println(name + " вышел " + preposition + " " + transportName);
        }
    }

    private String getPreposition(Transport transport) {
        if (transport instanceof Car || transport instanceof AllTerrainVehicle) {
            return "в";
        } else {
            return "на";
        }
    }

    private String getPrepositionFrom(Transport transport) {
        if (transport instanceof Car || transport instanceof AllTerrainVehicle) {
            return "из";
        } else {
            return "с";
        }
    }

    private String getTransportName(Transport transport) {
        if (transport instanceof Car) {
            return "машину";
        } else if (transport instanceof Horse) {
            return "лошадь";
        } else if (transport instanceof Bicycle) {
            return "велосипед";
        } else if (transport instanceof AllTerrainVehicle) {
            return "вездеход";
        } else {
            return "транспорт";
        }
    }

    private String getTransportNameFrom(Transport transport) {
        if (transport instanceof Car) {
            return "машины";
        } else if (transport instanceof Horse) {
            return "лошади";
        } else if (transport instanceof Bicycle) {
            return "велосипеда";
        } else if (transport instanceof AllTerrainVehicle) {
            return "вездехода";
        } else {
            return "транспорта";
        }
    }

    public boolean move(int distance, TerrainType terrain) {
        if (currentTransport == null) {
            System.out.println(name + " идет пешком " + distance + " км по местности " + terrain);
            return true;
        } else {
            if (currentTransport instanceof Bicycle) {
                return ((Bicycle) currentTransport).move(distance, terrain, this);
            } else {
                return currentTransport.move(distance, terrain);
            }
        }
    }
}
