public class RandomWalker {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            double r = Math.random();
            System.out.println(r);
            if (r < 0.25)
                x++;
            else if (r < 0.50)
                y--;
            else if (r < 0.75)
                x--;
            else if (r < 1)
                y++;
            System.out.println("(" + x + ", " + y + ")");
        }
        System.out.println("squared distance = " + (x * x + y * y));
    }
}
