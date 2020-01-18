package shapes_02;

public class Circle extends Shape {
    private Double radius;

    public final Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double calculatePerimeter() {
        return Math.PI * radius * 2;
    }

    @Override
    public Double calculateArea() {
        return Math.PI * radius * radius;
    }
}
