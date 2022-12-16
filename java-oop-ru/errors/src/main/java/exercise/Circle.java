package exercise;

// BEGIN
class Circle {
    private Point p;
    private int r;

    public Circle (Point p, int r) {
        this.p = p;
        this.r = r;
    }

    public int getRadius() {
        return this.r;
    }

    public double getSquare() throws NegativeRadiusException {
        if (r < 0) {
            throw new NegativeRadiusException("Circle radius less than zero");
        }
        double area = Math.PI * (r * r);
        return area;
    }
}
// END
