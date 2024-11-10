public class NBody {
    // comment
    public static void main(String[] args) {
        // Step 1. Parse command-line arguments.
        double stoppingTime = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);

        // Step 2. Read universe from standard input.
        int n = StdIn.readInt();
        double radius = StdIn.readDouble();
        double[] fx = new double[n];
        double[] fy = new double[n];
        double[] ax = new double[n];
        double[] ay = new double[n];
        double[] vx = new double[n];
        double[] vy = new double[n];
        double[] px = new double[n];
        double[] py = new double[n];
        double[] mass = new double[n];
        String[] image = new String[n];
        double G = 6.67e-11;

        for (int i = 0; i < n; i++) {
            px[i] = StdIn.readDouble();
            py[i] = StdIn.readDouble();
            vx[i] = StdIn.readDouble();
            vy[i] = StdIn.readDouble();
            mass[i] = StdIn.readDouble();
            image[i] = StdIn.readString();
        }
        // Step 3. Initialize standard drawing.
        StdDraw.setXscale(-radius, +radius);
        StdDraw.setYscale(-radius, +radius);
        StdDraw.enableDoubleBuffering();

        // Step 4. Play music on standard audio.
        StdAudio.playInBackground("2001.wav");

        // Step 5. Simulate the universe.
        for (double t = 0; t < stoppingTime; t += dt) {
            // Step 5A. Calculate net forces.
            for (int i = 0; i < n; i++) {
                fx[i] = 0;
                fy[i] = 0;
            }
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    if (i != k) {
                        double dx = px[k] - px[i];
                        double dy = py[k] - py[i];
                        double r2 = dx * dx + dy * dy;
                        double f = G * mass[i] * mass[k] / r2;
                        fx[i] += f * dx / Math.sqrt(r2);
                        fy[i] += f * dy / Math.sqrt(r2);
                    }
                }
            }
            // Step 5B. Update velocities and positions.
            for (int i = 0; i < n; i++) {
                ax[i] = fx[i] / mass[i];
                ay[i] = fy[i] / mass[i];
                vx[i] += ax[i] * dt;
                vy[i] += ay[i] * dt;
                px[i] += vx[i] * dt;
                py[i] += vy[i] * dt;

            }
            // Step 5C. Draw universe to standard drawing.
            StdDraw.picture(0, 0, "starfield.jpg");
            for (int i = 0; i < n; i++) {
                StdDraw.picture(px[i], py[i], image[i]);
            }
            StdDraw.show();
            StdDraw.pause(20);

        }

        // Step 6.
        StdOut.printf("%d\n", n);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < n; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          px[i], py[i], vx[i], vy[i], mass[i], image[i]);
        }
    }
}
