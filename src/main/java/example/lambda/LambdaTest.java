package example.lambda;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;


@Slf4j
public class LambdaTest {

    @Test
    public void runnable() {
        // Traditional way
        new Thread(
            new Runnable() {
                @Override
                public void run() {
                    log.info("Running thread");
                }
            }
        ).start();

        // With lambda
        new Thread(() -> log.info("Running thread")).start();
    }


    @Test
    public void comparatorSort() {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Diana");

        // Sort alphabetically
        names.sort((a, b) -> a.compareTo(b));

        // Sort by length
        names.sort((a, b) -> a.length() - b.length());
    }


    @Test
    public void iterationForEach() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Print all numbers
        numbers.forEach(n -> log.info("{}", n));

        // Print only even numbers
        numbers.forEach(n -> {
            if (n % 2 == 0) {
                log.info("{}", n);
            }
        });
    }


    @Test
    public void streamFilter() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Get even numbers
        List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        log.info("evens: {}", evens);

        // Get numbers greater than 3
        List<Integer> greaterThan3 = numbers.stream()
                .filter(n -> n > 3)
                .collect(Collectors.toList());
        log.info("greaterThan3: {}", greaterThan3);
    }


    @Test
    public void streamMap() {
        List<String> names = Arrays.asList("John", "Alice", "Bob");

        // Convert to uppercase
        List<String> upperNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        log.info("upperNames: {}", upperNames);

        // Get name lengths
        List<Integer> nameLengths = names.stream()
                .map(name -> name.length())
                .collect(Collectors.toList());
        log.info("nameLengths: {}", nameLengths);
    }


    @Test
    public void predicateInterface() {
        Predicate<String> startsWithJ = s -> s.startsWith("J");
        List<String> names = Arrays.asList("John", "Jack", "Emily");

        // Filter names starting with J
        List<String> jNames = names.stream()
                .filter(startsWithJ)
                .collect(Collectors.toList());
        log.info("jNames: {}", jNames);
    }


    @Test
    public void functionInterface() {
        Function<Integer, String> intToString = num -> Integer.toString(num);
        String numStr = intToString.apply(42);  // "42"
        log.info("numStr: {}", numStr);
    }


    @Test
    public void supplierInterface() {
        Supplier<Double> randomSupplier = () -> Math.random();
        Double randValue = randomSupplier.get();
        log.info("randValue: {}", randValue);
    }


    @Test
    public void consumerInterface() {
        Consumer<String> printConsumer = s -> log.info(s);
        printConsumer.accept("Hello World");
    }


    @Test
    public void methodReference() {
        List<String> names = Arrays.asList("John", "Alice", "Bob");

        // Equivalent to: s -> log.info(s)
        names.forEach(log::info);

        // Equivalent to: s -> s.toUpperCase()
        List<String> upperNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        log.info("upperNames: {}", upperNames);
    }


    @Test
    public void staticMethodReference() {
        // Lambda
        Function<String, Integer> parser1 = s -> Integer.parseInt(s);

        // Method reference
        Function<String, Integer> parser2 = Integer::parseInt;
    }


    @Test
    public void instanceMethodWithOneParameter() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Lambda
        names.forEach(s -> log.info(s));

        // Method reference
        names.forEach(log::info);
        // Must use lambda (can't do with method reference)
        names.forEach(s -> log.info("Name: " + s));
    }


    @Test
    public void instanceMethodOfClassWithoutSpecificInstance() {
        // Lambda
        Function<String, String> upper1 = s -> s.toUpperCase();

        // Method reference
        Function<String, String> upper2 = String::toUpperCase;
    }


    @Test
    public void constructorReference() {
        // Lambda
        Supplier<List<String>> supplier1 = () -> new ArrayList<>();

        // Constructor reference
        Supplier<List<String>> supplier2 = ArrayList::new;
    }
    
    
    @Test
    public void computeIfAbsent() {
        Map<Integer, List<String>> listMap = new HashMap<>();

        List<String> list = listMap.computeIfAbsent(1, k -> new ArrayList<>());
        list.add("a");
        list.add("A");

        List<String> list2 = listMap.computeIfAbsent(2, k -> new ArrayList<>());
        list2.add("b");
        list2.add("B");

        log.info("result: {}", listMap);
    }

}
