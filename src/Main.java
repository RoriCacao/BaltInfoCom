import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("resources/lng.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                list.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        list = list.stream().distinct().filter(x -> x.size() == 3).collect(Collectors.toList());

        list.forEach(System.out::println);

        List<List<List<String>>> groups = new ArrayList<>();
        List<List<String>> group = new ArrayList<>();
        long n = 0;

        for (int i = 0; i < list.size(); i++) {

            for (int j = i + 1; j < list.size() - i; j++) {
                //group.add(list.get(i));

                for (int k = 0; k < list.get(i).size(); k++) {
                    if (list.get(i).get(k) != "" && list.get(i).get(k).equals(list.get(j).get(k))) {
                        group.add(list.get(j));
                    }
                }

            }
            System.out.println(n++);
            groups.add(group);
            group.clear();
        }

        groups.forEach(System.out::println);


    }
}
