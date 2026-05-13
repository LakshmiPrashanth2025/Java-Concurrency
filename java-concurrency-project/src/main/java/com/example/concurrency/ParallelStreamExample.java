import java.util.List;

public class ParallelStreamExample {

    public static void main(String[] args) {

        List<Integer> nums =
                List.of(1,2,3,4,5,6,7,8,9,10);

        nums.parallelStream()
                .forEach(System.out::println);
    }
}
