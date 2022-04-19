package vn.techmaster.ex01.model;

public class BmiStat {
    private double weight;
    private double height;

    public BmiStat() {
    }

    public BmiStat(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
