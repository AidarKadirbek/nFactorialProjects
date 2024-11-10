public class RandomWalkers {
    // comment
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        double totalSquaredDistance = 0;
        for (int i = 0; i < trials; i++) {
            int x = 0, y = 0;
            for (int j = 0; j < n; j++) {
                double r = Math.random();
                if (r < 0.25)
                    x++;
                else if (r < 0.50)
                    y--;
                else if (r < 0.75)
                    x--;
                else if (r < 1)
                    y++;

            }
            totalSquaredDistance += (x * x + y * y);

        }
        System.out.println("mean squared distance = " + totalSquaredDistance / trials);
    }
}
