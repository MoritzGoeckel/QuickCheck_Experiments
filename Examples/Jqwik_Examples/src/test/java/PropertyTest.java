import net.jqwik.api.*;
import net.jqwik.api.constraints.*;
import org.assertj.core.api.*;

import java.util.List;

public class PropertyTest {

    //@Property
    //boolean absoluteValueOfAllNumbersIsPositive(@ForAll int anInteger) {
    //    return Math.abs(anInteger) >= 0;
    //}

    @Property
    boolean prop_positivePlusOne(@ForAll @IntRange(min = 0, max = 100) int num) {
        Assume.that(num > 10);
        Statistics.collect(num);
        return num + 1 > 0;
    }

    @Property
    void lengthOfConcatenatedStringIsGreaterThanLengthOfEach(
            @ForAll String string1, @ForAll String string2
    ) {
        String conc = string1 + string2;
        Assertions.assertThat(conc.length()).isGreaterThanOrEqualTo(string1.length());
        Assertions.assertThat(conc.length()).isGreaterThanOrEqualTo(string2.length());
    }

    @Property
    void uniqueInList(@ForAll @Size(5) List<@IntRange(min = 0, max = 10) @Unique Integer> aList) {
        Assertions.assertThat(aList).doesNotHaveDuplicates();
        Assertions.assertThat(aList).allMatch(anInt -> anInt >= 0 && anInt <= 10);
    }

    @Property
    void aProperty(@ForAll @Size(min= 1) List<@StringLength(max=10) String> listOfStrings) {
    }

    @Property
    <T> boolean unboundedGenericTypesAreResolved(@ForAll List<T> items, @ForAll T newItem) {
        items.add(newItem);
        return items.contains(newItem);
    }

}
