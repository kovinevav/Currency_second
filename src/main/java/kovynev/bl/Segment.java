package kovynev.bl;

public class Segment {
    final double ax1;
    final double ay1;
    final double ax2;
    final double ay2;

    public Segment(double x1, double y1, double x2, double y2) {
        this.ax1 = x1;
        this.ay1 = y1;
        this.ax2 = x2;
        this.ay2 = y2;
    }

    public double getX1() {
        return ax1;
    }

    public double getY1() {
        return ay1;
    }

    public double getX2() {
        return ax2;
    }

    public double getY2() {
        return ay2;
    }

    public boolean intersection(Segment segment) {
        double bx1 = segment.getX1();
        double by1 = segment.getY1();
        double bx2 = segment.getX2();
        double by2 = segment.getY2();



        double v1 = (bx2 - bx1) * (ay1 - by1) - (by2 - by1) * (ax1 - bx1);
        double v2 = (bx2 - bx1) * (ay2 - by1) - (by2 - by1) * (ax2 - bx1);
        double v3 = (ax2 - ax1) * (by1 - ay1) - (ay2 - ay1) * (bx1 - ax1);
        double v4 = (ax2 - ax1) * (by2 - ay1) - (ay2 - ay1) * (bx2 - ax1);
        boolean result  =(v1 * v2 < 0) && (v3 * v4 < 0);
        if(result) System.out.println("Тренды пересекаются");
        else System.out.println("Тренды не пересекаются");
        return result;


    }
}
