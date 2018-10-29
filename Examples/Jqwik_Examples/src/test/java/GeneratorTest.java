import net.jqwik.api.*;

import org.assertj.core.api.Assertions;

import java.util.Random;

public class GeneratorTest {

    @Property
    boolean testingGenerators(@ForAll("names") String name, @ForAll("oddNumbers") int num) {
        Statistics.collect(name);
        return num % 2 == 1;
    }

    @Provide
    Arbitrary<String> names() {
        return Arbitraries.frequency(
                Tuple.of(1, "John"),
                Tuple.of(5, "Jack"),
                Tuple.of(10, "Jordan")
        );
    }

    @Provide
    Arbitrary<Integer> oddNumbers() {
        return Arbitraries.integers().filter(i -> i % 2 == 1);
    }

    /*
    @Property
    boolean concatenatingStringWithInt(
            @ForAll("shortStrings") String aShortString,
            @ForAll("10 to 99") int aNumber
    ) {
        String concatenated = aShortString + aNumber;
        return concatenated.length() > 2 && concatenated.length() < 11;
    }

    @Provide
    Arbitrary<String> shortStrings() {
        return Arbitraries.strings().withCharRange('a', 'z')
                .ofMinLength(1).ofMaxLength(8);
    }

    @Provide("10 to 99")
    Arbitrary<Integer> numbers() {
        return Arbitraries.integers().between(10, 99);
    }

    @Provide
    Arbitrary<Integer> primesGenerated() {
        return Arbitraries.randomValue(random -> generatePrime(random));
    }

    private Integer generatePrime(Random random) {
        int candidate;
        do {
            candidate = random.nextInt(10000) + 2;
        } while (!isPrime(candidate));
        return candidate;
    }

    @Provide
    Arbitrary<String> alphaNumericStringsWithMinLength5() {
        return Arbitraries.strings().ofMinLength(5).alpha().numeric();
    }

    @Provide
    Arbitrary<List<Integer>> fixedSizedListOfPositiveIntegers() {
        return Arbitraries.integers().greaterOrEqual(0).list().ofSize(17);
    }*/

}
