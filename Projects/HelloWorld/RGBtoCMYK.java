public class RGBtoCMYK {
    // comment
    public static void main(String[] args) {
        double red = Double.parseDouble(args[0]);
        double green = Double.parseDouble(args[1]);
        double blue = Double.parseDouble(args[2]);
        double r2 = (red / 255);
        double g2 = (green / 255);
        double b2 = (blue / 255);
        double max1 = Math.max(r2, g2);
        double white = Math.max(max1, b2);
        double cyan = (white - r2) / white;
        double magenta = (white - g2) / white;
        double yellow = (white - b2) / white;
        double black = 1 - white;
        System.out.println((int) red);
        System.out.println((int) green);
        System.out.println((int) blue);
        System.out.println(cyan);
        System.out.println(magenta);
        System.out.println(yellow);
        System.out.println(black);
    }
}
