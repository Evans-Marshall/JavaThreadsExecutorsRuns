package ThreadsExecsRuns;

import java.util.concurrent.*;

public class TERs {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.submit(() -> System.out.println("Wheee look at me run!"));

        Future<String> futureTask1 = executor.submit(() -> {
            System.out.println("I'm running in the future!");
            return ("I am the future and am here to warn you!");
        });

        try {

            otherTask("Slow down! You might Fall!");

           
            String result = futureTask1.get(5, TimeUnit.SECONDS);

            System.out.println(result + " You will need a Band-Aid soon!");

            otherTask("See! You fell down!");


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {

            
            executor.shutdown();

        }

    }

    private static void otherTask(String name) {
        System.out.println(name + " Be careful!");
    }
}
