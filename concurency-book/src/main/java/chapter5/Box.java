package chapter5;

public class Box {
    public int day;
    public int pills;

    public Box(int day, int pills) {
        this.day = day;
        this.pills = pills;
    }

    @Override
    public String toString() {
        return "Box{" +
                "day=" + day +
                ", pills=" + pills +
                '}';
    }
}
