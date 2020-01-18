package class_box_01;


import static someValidations.Validator.validateSide;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    private void setLength(double length) {
        validateSide("Length", length);
        this.length = length;
    }

    private void setWidth(double width) {
        validateSide("Width", width);
        this.width = width;
    }

    private void setHeight(double height) {
        validateSide("Height", height);
        this.height = height;
    }

    public double calculateVolume() {
        return getWidth() * getLength() * getHeight();
    }

    public double calculateLateralSurfaceArea() {
        return (2 * (getLength() * getHeight()))
                + (2 * (getWidth() * getHeight()));
    }

    public double calculateSurfaceArea() {
        return (2 * (getLength() * getHeight()))
                + (2 * (getHeight() * getWidth()))
                + (2 * (getLength() * getWidth()));
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f%n" +
                "Lateral Surface Area - %.2f%n" +
                "Volume – %.2f", calculateSurfaceArea(), calculateLateralSurfaceArea(), calculateVolume());
    }
}

