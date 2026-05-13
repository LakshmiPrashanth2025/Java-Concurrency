import java.util.concurrent.*;

class SumTask extends RecursiveTask<Integer> {

    int start, end;

    SumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    protected Integer compute() {

        if (end - start <= 5) {

            int sum = 0;

            for (int i = start; i <= end; i++) {
                sum += i;
            }

            return sum;
        }

        int mid = (start + end) / 2;

        SumTask left =
                new SumTask(start, mid);

        SumTask right =
                new SumTask(mid + 1, end);

        left.fork();

        return right.compute() + left.join();
    }
}

public class ForkJoinExample {

    public static void main(String[] args) {

        ForkJoinPool pool =
                new ForkJoinPool();

        System.out.println(
                pool.invoke(new SumTask(1, 100)));
    }
}
