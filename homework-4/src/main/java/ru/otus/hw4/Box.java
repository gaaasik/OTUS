package ru.otus.hw4;

public class Box {
    private final int width;
    private final int height;
    private final int depth;
    private String color;
    private boolean open;
    private String item;

    public Box(int width, int height, int depth, String color) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.color = color;
        this.open = false;
        this.item = null;
    }

    public void open() {
        if (!open) {
            open = true;
            System.out.println("Коробка открыта");
        } else {
            System.out.println("Коробка уже открыта");
        }
    }

    public void close() {
        if (open) {
            open = false;
            System.out.println("Коробка закрыта");
        } else {
            System.out.println("Коробка уже закрыта");
        }
    }

    public void repaint(String newColor) {
        this.color = newColor;
        System.out.println("Коробка перекрашена в цвет: " + color);
    }

    public void putItem(String newItem) {
        if (!open) {
            System.out.println("Нельзя положить предмет: коробка закрыта");
            return;
        }
        if (item != null) {
            System.out.println("В коробке уже есть предмет: " + item);
            return;
        }
        item = newItem;
        System.out.println("Положили предмет: " + item);
    }

    public void removeItem() {
        if (!open) {
            System.out.println("Нельзя выкинуть предмет: коробка закрыта");
            return;
        }
        if (item == null) {
            System.out.println("В коробке нет предмета");
            return;
        }
        System.out.println("Выкинули предмет: " + item);
        item = null;
    }

    public void printInfo() {
        System.out.println("Коробка: " + width + "x" + height + "x" + depth + ", цвет: " + color + ", открыта: " + open + ", предмет: " + (item == null ? "нет" : item));
    }
}
