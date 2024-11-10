public class RollDice {
    // comment
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int sides = 6;
        int NUMBER_OF_DICE = 10;
        int[] tally = new int[sides * NUMBER_OF_DICE + 1];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < NUMBER_OF_DICE; j++) {
                int r = (int) (Math.random() * sides) + 1;
                sum += r;
            }
            tally[sum]++;
        }
        for (int i = 0; i < tally.length; i++) {
            System.out.println(i + " " + tally[i]);
        }
        for (int k = 10; k < tally.length; k++) {
            System.out.printf("%2d: ", k);
            for (int l = 0; l < tally[k]; l++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
