package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice {

    public static void main(String[] args) {
        List<String> studentName = new ArrayList<>();
        studentName.add("Rahul");
        studentName.add("Akash");
        studentName.add("Ajay");
        studentName.add("Ankitt");
        //System.out.println(studentName);
        List<String> lowercase = new ArrayList<>();
        for(String a:studentName){
            lowercase.add(a.toLowerCase());
        }
        //System.out.println(lowercase);
        List<Integer> test1 = new ArrayList<>();
        test1.add(11);
        test1.add(12);
        test1.add(13);
        test1.add(45);

       List<String> lower =  studentName.stream().map(String::toLowerCase).collect(Collectors.toList());
      // List<String> chota = test1.stream().map(s-> s.).collect(Collectors.toList());
       // System.out.println(chota);
     //   System.out.println(lower);
        List<String> city = new ArrayList<>();
        Stream<String>  str = city.stream().filter(e -> e.startsWith("R"));


        List<String> cities = List.of("Rahul", "Ajay", "Sachin", "Rohit");
        Stream<String> newCities = cities.stream().filter(e -> e.startsWith("R")).collect(Collectors.toCollection());

        System.out.println(newCities);


    }
}

