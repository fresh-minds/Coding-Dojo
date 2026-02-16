import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {

    record Bridge(LinkedList<Integer> personsLeft, LinkedList<Integer> personsRight) {
        @SuppressWarnings("unchecked")
        Bridge leftReturns() {
            var newLeft = (LinkedList<Integer>) personsLeft.clone();
            var newRight = (LinkedList<Integer>) personsRight().clone();
            newRight.add(newLeft.remove(1));

            newLeft.sort(Integer::compareTo);
            newRight.sort(Integer::compareTo);
            return new Bridge(newLeft, newRight);
        }

        @SuppressWarnings("unchecked")
        Bridge rightReturns() {
            var newLeft = (LinkedList<Integer>) personsLeft.clone();
            var newRight = (LinkedList<Integer>) personsRight().clone();
            newRight.add(newLeft.removeLast());
            newRight.add(newLeft.removeLast());
            newLeft.add(newRight.pop());

            newLeft.sort(Integer::compareTo);
            newRight.sort(Integer::compareTo);
            return new Bridge(newLeft, newRight);
        }

        @Override
        public String toString() {
            return "%s - %s".formatted(personsLeft, personsRight);
        }


    }

    public static void main(String[] args) {
        var personTimes = Arrays.stream(args)
                .map(Integer::parseInt)
                .sorted()
                .toList();

        System.out.println(solve(new Bridge(new LinkedList<>(personTimes), new LinkedList<>()), new HashMap<>()));
    }

    public static int solve(Bridge bridge, Map<Bridge, Integer> memory) {
        var fromMemory = memory.get(bridge);
        if (fromMemory != null) {
            return fromMemory;
        }

        var fastestPersonLeft = bridge.personsLeft.peek();

        if (bridge.personsLeft.isEmpty()) {
            return 0;
        }

        if (bridge.personsLeft.size() == 1) {
            return fastestPersonLeft;
        }

        var leftReturns = bridge.personsLeft.get(0) + bridge.personsLeft.get(1);
        if (bridge.personsLeft.size() == 2) {
            var slowestLeft = bridge.personsLeft.get(1);
            return slowestLeft;
        }


        var optionLeft = bridge.leftReturns();
        var timeOptionLeft = solve(optionLeft,  memory) + leftReturns;

        if (bridge.personsRight.isEmpty()) {
            return timeOptionLeft;
        }

        var optionRight = bridge.rightReturns();
        var rightReturns = bridge.personsLeft.getLast() + bridge.personsRight.getFirst();
        var timeOptionRight = solve(optionRight, memory) + rightReturns;

        if (timeOptionLeft < timeOptionRight) {
            memory.put(bridge, timeOptionLeft);
            return timeOptionLeft;
        } else {
            memory.put(bridge, timeOptionRight);
            return timeOptionRight;
        }
    }
}
