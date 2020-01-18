package shapes_02;

public class Rectangle extends Shape {
    private  double width;
    private double height;

    public Rectangle(double wight, double height) {
        this.width = wight;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public Double calculateArea() {

        Double area = width * height;
        super.setArea(area);
        return area;

    }

    @Override
    public Double calculatePerimeter() {
        Double perimeter = 2 * (width + height);
        super.setPerimeter(perimeter);
        return perimeter;
    }
}
