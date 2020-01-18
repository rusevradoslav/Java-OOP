package shapes_02;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    public Double setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
        return perimeter;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPerimeter() {
        return perimeter;
    }

    public Double getArea() {
        return area;
    }

    public abstract Double calculatePerimeter();
    public abstract Double calculateArea();



}
