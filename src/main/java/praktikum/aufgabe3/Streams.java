package praktikum.aufgabe3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        List<Ding> dings = Arrays.asList(new Ding(6, "ist "),
                                          new Ding(9, "Frage."),
                                          new Ding (8, "die "),
                                          new Ding(3, "sein"),
                                          new Ding(4, ", "),
                                          new Ding(2, "nicht "),
                                          new Ding(1, "oder "),
                                          new Ding(7, "hier "),
                                          new Ding(0, "Sein "),
                                          new Ding(5, "das "));
        Stream<Ding> stream = dings.stream();
        String res = stream.sorted(Ding::compareTo).map(Ding::getZeichenkette).limit(10).collect(Collectors.joining());
        //String ans = stream.sorted(Ding::compareTo).map(Ding::getZeichenkette).collect(Collectors.joining());
        System.out.println(res);
    }
}
