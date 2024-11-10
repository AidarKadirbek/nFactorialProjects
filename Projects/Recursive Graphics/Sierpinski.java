public class Sierpinski {

    //  Height of an equilateral triangle whose sides are of the specified length.
    public static double height(double length) {
        double height = length * Math.sqrt(3.0) / 2.0;
        return height;
    }

    //  Draws a filled equilateral triangle whose bottom vertex is (x, y)
    //  of the specified side length.
    public static void filledTriangle(double x, double y, double length) {
        double x0 = x - length / 2.0, x1 = x + length / 2.0;
        double y0 = y + length * Math.sqrt(3.0) / 2.0, y1 = y
                + length * Math.sqrt(3.0) / 2.0;
        double[] xx = { x0, x, x1 };
        double[] yy = { y0, y, y1 };
        StdDraw.filledPolygon(xx, yy);
    }

    //  Draws a Sierpinski triangle of order n, such that the largest filled
    //  triangle has bottom vertex (x, y) and sides of the specified length.
    public static void sierpinski(int n, double x, double y, double length) {
        if (n == 0) return; // base case
        filledTriangle(x, y, length);

        sierpinski(n - 1, x - length / 2, y, length / 2);
        sierpinski(n - 1, x, y + Math.sqrt(3) / 2 * length, length / 2);
        sierpinski(n - 1, x + length / 2, y, length / 2);
    }

    //  Takes an integer command-line argument n;
    //  draws the outline of an equilateral triangle (pointed upwards) of length 1;
    //  whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and
    //  draws a Sierpinski triangle of order n that fits snugly inside the outline.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double length = 1.0;
        StdDraw.line(0.0, 0.0, 1.0, 0.0);
        StdDraw.line(1.0, 0.0, 0.5, height(length));
        StdDraw.line(0.5, height(length), 0.0, 0.0);
        sierpinski(n, 0.5, 0.0, 0.5);
    }
}
