package exercise;

// BEGIN
class Segment {
    private Point start;
    private Point end;

    public Segment(Point startP, Point endP) {
        start = startP;
        end = endP;
    }

    public Point getBeginPoint() {
        return start;
    }

    public Point getEndPoint() {
        return end;
    }

    public Point getMidPoint() {
        int x = (start.getX() + end.getX())/2;
        int y = (start.getY() + end.getY())/2;
        return new Point(x, y);
    }
}
// END
