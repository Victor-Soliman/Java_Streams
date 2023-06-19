package nasr.soliman;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // 1.Intermediate operations:

        // filter(Predicate): Filters elements based on a given predicate.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumbers); // Result: evenNumbers = [2, 4]

        // map(Function): Transforms elements using a given function.
        List<String> strings = Arrays.asList("Java", "Streams", "Tutorial");
        List<Integer> lengths = strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(lengths);  // Result: lengths = [4, 7, 8]

        // flatMap(Function): Transforms elements into Streams and flattens the resulting Streams.
        List<String> lines = Arrays.asList("Hello, world", "Java Streams");
        List<String> words = lines.stream()
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .collect(Collectors.toList());
        System.out.println(words);  // Result: words = ["Hello,", "world", "Java", "Streams"]

        // distinct(): Returns a Stream with unique elements.
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 2, 3, 3, 3);
        List<Integer> distinctNumbers = numbersWithDuplicates.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctNumbers);  // Result: distinctNumbers = [1, 2, 3]

        // sorted(Comparator): Sorts the elements based on a given comparator.
        List<String> unsortedStrings = Arrays.asList("banana", "apple", "cherry", "avocado");
        List<String> sortedStrings = unsortedStrings.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedStrings);  // Result: sortedStrings = ["apple", "avocado", "banana", "cherry"]

        // peek(Consumer): Performs an action on each element without modifying the Stream, useful for debugging.
        List<Integer> _numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> doubledNumbers = _numbers.stream()
                .peek(n -> System.out.println("Original: " + n))
                .map(n -> n * 2)
                .peek(n -> System.out.println("Doubled: " + n))
                .collect(Collectors.toList());
        // Result: doubledNumbers = [2, 4, 6, 8, 10]
        // Output: Original: 1
        //         Doubled: 2
        //         Original: 2
        //         Doubled: 4
        //         ...

        // 2.Terminal operations:

        // forEach(Consumer): Performs an action on each element.
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.stream().forEach(System.out::println);

        // toArray(): Collects elements into an array.
        List<String> nameList = Arrays.asList("Alice", "Bob", "Charlie");
        String[] namesArray = nameList.stream().toArray(String[]::new);
        System.out.println(Arrays.toString(namesArray));  // Result: [Alice, Bob, Charlie]

        // reduce(BinaryOperator): Reduces the elements to a single value.
        List<Integer> __numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> sum = __numbers.stream().reduce(Integer::sum);
        System.out.println(sum); // Result: sum = Optional[15]

        // collect(Collector): Collects elements into a mutable container.
        // min(Comparator), max(Comparator): Finds the minimum or maximum element.
        // count(): Counts the elements.

        // anyMatch(Predicate), allMatch(Predicate), noneMatch(Predicate):
        // Tests whether the predicates match the elements.

        // findFirst(), findAny(): Retrieves the first or any element that satisfies a given condition.
        List<Integer> numbers$ = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstGreaterThanThree = numbers$.stream()
                                                            .filter(n -> n > 3)
                                                            .findFirst();
        System.out.println(firstGreaterThanThree);  // Result: Optional[4]

        Optional<Integer> anyGreaterThenThree = numbers$.stream()
                                                        .filter(n -> n > 3)
                                                        .findAny();
        System.out.println(anyGreaterThenThree);  // Result: Optional[4] (may vary in parallel streams)

    }
}