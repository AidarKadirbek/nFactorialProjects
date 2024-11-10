public class Transform2D {
    public static void scale(double[] x, double[] y, double alpha) {
        for (int i = 0; i < x.length; i++) {
            x[i] = alpha * x[i];
            y[i] = alpha * y[i];
        }
    }

    // Translates the polygon by (dx, dy).
    public static void translate(double[] x, double[] y, double dx, double dy) {
        for (int i = 0; i < x.length; i++) {
            x[i] = x[i] + dx;
            y[i] = y[i] + dy;
        }
    }

    // Returns a new array object that is an exact copy of the given array.
    // The given array is not mutated.
    public static double[] copy(double[] array) {
        double[] copyarray = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            copyarray[i] = array[i];
        }
        return copyarray;
    }

    // Rotates the polygon theta degrees counterclockwise, about the origin.
    public static void rotate(double[] x, double[] y, double theta) {
        for (int i = 0; i < x.length; i++) {
            theta = Math.toRadians(theta);
            x[i] = (x[i] * Math.cos(theta)) - (y[i] * Math.sin(theta));
            y[i] = (y[i] * Math.cos(theta)) + (x[i] * Math.sin(theta));
        }
    }

    // Tests each of the API methods by directly calling them.
    public static void main(String[] args) {
        StdDraw.setScale(-5.0, +5.0);
        double[] x = { 0, 1, 1, 0 };
        double[] y = { 0, 0, 2, 1 };

        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.polygon(x, y);

        rotate(x, y, 45.0);

        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.polygon(x, y);


    }

}
