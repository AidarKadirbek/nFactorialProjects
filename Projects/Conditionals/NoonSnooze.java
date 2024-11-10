public class NoonSnooze {
    // comment
    public static void main(String[] args) {
        int snooze = Integer.parseInt(args[0]);
        int h = 12 + (snooze / 60);
        int m = 00 + snooze % 60;
        String ampm;
        if (h % 24 < 12) ampm = "am";
        else ampm = "pm";
        h = h % 12;
        if (h == 00) h = 12;
        System.out.printf("%d:%02d%s", h, m, ampm);
    }
}
