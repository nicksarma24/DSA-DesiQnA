package DSA;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.lang.Runnable;
import java.lang.Thread;
import java.util.stream.*;

interface Bird{
    void canFly();
}

class Employee {
    /*
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', id=" + id + "}";
    }

    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    // Setter for id
    public void getName(String name) {
        this.name = name;
    }
}

public class Main {
    public static void main(String args[] ) throws Exception {
        //iteratorExamples();
        //methodsOfCollection();
        //functionalInterface();
        stream();
    }

    public static void stream(){
        //    List<Integer> list = Arrays.asList(1,2,3,4);
            
            Employee emp1 = new Employee("Alice", 104);
            Employee emp2 = new Employee("Alice", 101);
            Employee emp3 = new Employee("Bob", 102);
            Employee emp4 = new Employee("Charlie", 103);

             List<Employee> employees = Arrays.asList(emp1, emp2, emp3,emp4);
        //     list.stream().sorted().forEach((Integer x)-> System.out.println(x));

        //     int arr[] = {1,2,3,4,5};
        //     Arrays.stream(arr).forEach((int x)-> System.out.println(x));
            
        //     Stream.of(5,6,7,8).forEach((Integer x)-> System.out.println(x));
            
        //     list.stream().filter((Integer x)-> x>=3?true:false).forEach(x -> System.out.println(x));
        //     System.out.println(employees.stream().map((Employee e) -> {
        //         return e.getName();
        //     }).collect(Collectors.toList())); 

            List<List<String>> listTemp = Arrays.asList(Arrays.asList("1","2","3"),Arrays.asList("4","5","6","6"));
            listTemp.stream().flatMap((List<String> tempList) -> tempList.stream()).distinct().limit(2).forEach((x)-> System.out.println(x));

        //     employees.stream().sorted((Employee e1, Employee e2)-> e1.getId()-e2.getId()).forEach((e)->System.out.println(e.getId()));
            
            Optional<String> nameConcat = employees.stream().map((x)-> x.getName()).reduce((e1,e2)-> e1+e2);
            System.out.println(nameConcat.get());

           List<Integer> list = listTemp.stream().flatMap((List<String> tempList) -> tempList.stream()).mapToInt((x)-> Integer.parseInt(x)).boxed().collect(Collectors.toList());
            System.out.println(list);

            OptionalInt temp = listTemp.stream().flatMap((List<String> tempList) -> tempList.stream()).mapToInt((x)-> Integer.parseInt(x)).min();
            System.out.println(temp.getAsInt());

            int firstElement = listTemp.stream().flatMap((List<String> tempList) -> tempList.stream()).mapToInt((x)-> Integer.parseInt(x)).boxed().findFirst().get();
            int anyElement = listTemp.stream().flatMap((List<String> tempList) -> tempList.stream()).mapToInt((x)-> Integer.parseInt(x)).boxed().findAny().get();
            System.out.println(firstElement+" "+anyElement);
    }   
    
    public static void functionalInterface(){
        // Bird sparrow = new Bird(){

        //     @Override
        //     public void canFly() {
        //         System.out.println("Sparrow Flies");
        //     }
        // };

        // sparrow.canFly();

        // Bird vulture = ()->{
        //     System.out.println("Vulture Can't fly");
        // };

        // vulture.canFly();

        //Consumer Example
        Consumer<Integer> consumer = (Integer x)->{
            if(x%2==0)
                System.out.println("Even number: "+x);
        };
        consumer.accept(10);

        //Supplier
        Supplier<String> supplier = ()->{
            return "Supplier Example";
        };
        System.out.println(supplier.get());

        //Function example
        Function<Integer, String> function = (Integer x)->{
            if(x%2==0)
                return "Is Even";
            else return "Is Odd";
        };

        System.out.println(function.apply(5));

        //Predicate 
        Predicate<Integer> predicate = (Integer val)->{
            return (val%2==0);
        };


        System.out.println(predicate.test(17));


        Runnable runnable = ()->{
            System.out.println("Thread is running");
        };

        new Thread(runnable).start();
    }

    public static void methodsOfCollection(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        int size = list.size();
        boolean isEmpty = list.isEmpty();
        boolean contains = list.contains(1);
        Integer arr[] = list.toArray(new Integer[0]);
        
        System.out.println(size);
        System.out.println(isEmpty);
        System.out.println(contains);
        System.out.println(Arrays.toString(arr));
        
        list.remove(0);
        System.out.println(list);
    }
    
    public static void iteratorExamples(){
        List<Integer> list = Arrays.asList(1,2,3,4);

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
            iterator.next();
        }

        list.forEach((Integer i)->{
            System.out.print(" ForEach Example"+i);
        });
        System.out.println();
    } */

    public static int maxSubArraySum(int[] arr) {
        int maxSoFar = arr[0]; // Maximum sum found so far
        int maxEndingHere = arr[0]; // Maximum sum of subarray ending at current index

        // Start iterating from the second element since we initialized with the first element
        for (int i = 1; i < arr.length; i++) {
            // Update maxEndingHere to be the max of the current element or current element + previous subarray sum
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);

            // Update maxSoFar to be the maximum found so far
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Subarray Sum: " + maxSubArraySum(arr));  // Output: 6
    }
}