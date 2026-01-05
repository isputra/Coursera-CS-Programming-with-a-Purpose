/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     January 5, 2026
 **************************************************************************** */

public class Clock {
    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOUR = 60;
    private int hours;
    private int minutes;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < 0 || h >= HOURS_PER_DAY)
            throw new IllegalArgumentException("the hours must be between 0 and 23");
        if (m < 0 || m >= MINUTES_PER_HOUR)
            throw new IllegalArgumentException("the minutes must be between 0 and 59");
        hours = h;
        minutes = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (s.length() != 5 || s.charAt(2) != ':')
            throw new IllegalArgumentException("wrong format");
        String hString = s.substring(0, 2);
        String mString = s.substring(3, 5);
        int h = Integer.parseInt(hString);
        int m = Integer.parseInt(mString);
        if (h < 0 || h >= HOURS_PER_DAY)
            throw new IllegalArgumentException("the hours must be between 0 and 23");
        if (m < 0 || m >= MINUTES_PER_HOUR)
            throw new IllegalArgumentException("the minutes must be between 0 and 59");
        hours = h;
        minutes = m;
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        String h = hours < 10 ? "0" + hours : String.valueOf(hours);
        String m = minutes < 10 ? "0" + minutes : String.valueOf(minutes);
        return h + ":" + m;
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (hours < that.hours) return true;
        if (hours == that.hours && minutes < that.minutes) return true;
        return false;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        toc(1);
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) throw new IllegalArgumentException("the minutes must be positive integer");
        int addHours = (minutes + delta) / MINUTES_PER_HOUR;
        hours = (hours + addHours) % HOURS_PER_DAY;
        minutes = (minutes + delta) % MINUTES_PER_HOUR;
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock clock1 = new Clock(23, 59);
        Clock clock2 = new Clock("11:34");
        Clock clock3 = new Clock(0, 0);
        Clock clock4 = new Clock(9, 9);
        System.out.println("clock1 " + clock1);
        System.out.println("clock2 " + clock2);
        System.out.println("clock1 is earlier than clock2 " + clock1.isEarlierThan(clock2));
        System.out.println("clock2 is earlier than clock1 " + clock2.isEarlierThan(clock1));
        System.out.println("clock2 " + clock2);
        System.out.println("clock3 " + clock3);
        System.out.println("clock4 " + clock4);
        System.out.println("clock1 " + clock1);
        clock1.tic();
        System.out.println("clock1 tic " + clock1);
        clock1.toc(61);
        System.out.println("clock1 toc 61 " + clock1);
        System.out.println("clock2 " + clock2);
        clock2.tic();
        System.out.println("clock2 tic " + clock2);
        clock1.toc(86440);
        System.out.println("clock2 toc 86440 " + clock2);
    }
}
