import net.jqwik.api.*;
import net.jqwik.api.stateful.Action;
import net.jqwik.api.stateful.ActionSequence;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;

public class StatefulTest {

    class MyList {
        private ArrayList<String> list = new ArrayList<>();

        public void add(String element) { list.add(element); }
        public int size() { return list.size(); }

        public void remove() {
            if (size() > 0 && !list.contains("10"))
                list.remove(0);
        }
    }

    class AddAction implements Action<MyList> {

        private String str;

        AddAction(String str) {
            this.str = str;
        }

        @Override
        public MyList run(MyList list) {
            int beforeSize = list.size();
            list.add(str);
            Assertions.assertThat(list.size()).isEqualTo(beforeSize + 1);
            return list;
        }

        @Override
        public String toString() { return String.format("add(%s)", str); }
    }

    class RemoveAction implements Action<MyList> {
        @Override
        public MyList run(MyList list) {
            int beforeSize = list.size();
            list.remove();
            Assertions.assertThat(list.size()).isEqualTo(Math.max(beforeSize - 1, 0));
            return list;
        }

        @Override
        public String toString() { return String.format("remove"); }
    }

    @Property
    void checkList(@ForAll("listActionSequences") ActionSequence<MyList> actions) {
        actions.run(new MyList());
    }

    @Provide
    Arbitrary<ActionSequence<MyList>> listActionSequences() {
        return Arbitraries.sequences(
                Arbitraries.oneOf(
                        Arbitraries.integers().between(0, 100).map(Object::toString).map(AddAction::new),
                        Arbitraries.constant(new RemoveAction())
                )
        );
    }

}
