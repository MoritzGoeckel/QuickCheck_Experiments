import net.jqwik.api.*;

import java.util.Random;

public class FrequencyTest {

    @Property
    void abcdWithFrequencies(@ForAll("abcdWeighted") String aString) {
        Statistics.collect(aString);
    }

    @Provide
    Arbitrary<String> abcdWeighted() {
        return Arbitraries.frequency(
                Tuple.of(1, "a"),
                Tuple.of(5, "b"),
                Tuple.of(10, "c"),
                Tuple.of(20, "d")
        );
    }

}
