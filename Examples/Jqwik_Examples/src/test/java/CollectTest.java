import net.jqwik.api.*;

public class CollectTest {

    @Property
    void simpleStats(@ForAll int num) {
        Statistics.collect(num);
    }

}
