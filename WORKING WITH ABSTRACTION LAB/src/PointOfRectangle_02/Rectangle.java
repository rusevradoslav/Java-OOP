package PointOfRectangle_02;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(int bottomLeftX, int bottomLeftY, int topRightX, int topRightY) {
        this.bottomLeft = new Point(bottomLeftX, bottomLeftY);
        this.topRight = new Point(topRightX, topRightY);
    }

    public boolean contains(Point toCheck) {
        if (!(toCheck.getX() >= bottomLeft.getX() && toCheck.getX() <= topRight.getX())) {
            return false;
        }
        if (!(toCheck.getY() >= bottomLeft.getY() && toCheck.getY() <= topRight.getY())) {
            return false;
        }
        return true;
    }
}
