/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     January 5, 2026
 **************************************************************************** */

import java.util.Arrays;
import java.util.Objects;

public class Bar implements Comparable<Bar> {
    private final String name;
    private final int value;
    private final String category;

    // Creates a new bar.
    public Bar(String name, int value, String category) {
        if (Objects.isNull(name))
            throw new IllegalArgumentException("name can't be null.");
        if (value < 0)
            throw new IllegalArgumentException("value can't be negative.");
        if (Objects.isNull(category))
            throw new IllegalArgumentException("category can't be null.");
        this.name = name;
        this.value = value;
        this.category = category;
    }

    // Returns the name of this bar.
    public String getName() {
        return name;
    }

    // Returns the value of this bar.
    public int getValue() {
        return value;
    }

    // Returns the category of this bar.
    public String getCategory() {
        return category;
    }

    // Compare two bars by value.
    public int compareTo(Bar that) {
        if (Objects.isNull(that)) throw new NullPointerException();
        if (this.value < that.value) return -1;
        if (this.value > that.value) return 1;
        return 0;
    }

    // Sample client (see below).
    public static void main(String[] args) {
        // create an array of 10 bars
        Bar[] bars = new Bar[10];
        bars[0] = new Bar("Beijing", 22674, "East Asia");
        bars[1] = new Bar("Cairo", 19850, "Middle East");
        bars[2] = new Bar("Delhi", 27890, "South Asia");
        bars[3] = new Bar("Dhaka", 19633, "South Asia");
        bars[4] = new Bar("Mexico City", 21520, "Latin America");
        bars[5] = new Bar("Mumbai", 22120, "South Asia");
        bars[6] = new Bar("Osaka", 20409, "East Asia");
        bars[7] = new Bar("São Paulo", 21698, "Latin America");
        bars[8] = new Bar("Shanghai", 25779, "East Asia");
        bars[9] = new Bar("Tokyo", 38194, "East Asia");

        // sort in ascending order by weight
        Arrays.sort(bars);
        for (Bar bar : bars) {
            System.out.printf("%s %d %s\n", bar.getName(), bar.getValue(), bar.getCategory());
        }
    }

}
