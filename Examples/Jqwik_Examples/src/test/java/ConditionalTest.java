import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.constraints.StringLength;
import net.jqwik.api.stateful.Action;
import net.jqwik.api.stateful.ActionSequence;
import org.assertj.core.api.Assertions;

public class ConditionalTest {

    /*
        @Property
        boolean prop_positivePlusOne(@ForAll @IntRange() String string1, @ForAll @StringLength(min = 1, max = 10) String string2) {
            Assume.that(!string1.equals(string2));

            return string1.compareTo(string2) != 0;
        }
        */

}
