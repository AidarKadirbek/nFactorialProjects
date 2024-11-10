public class GreatCircle {
    // comment
    public static void main(String[] args) {
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));
        double a = Math.acos(Math.sin(x1) * Math.sin(x2) + Math.cos(x1) *
                Math.cos(x2) * Math.cos(y1 - y2));
        a = Math.toDegrees(a);
        double dis = 60 * a;
        System.out.println("Princeton to Paris " + dis + " nautical miles");
        System.out.println("Paris to Princeton " + dis + " nautical miles");
    }
}
