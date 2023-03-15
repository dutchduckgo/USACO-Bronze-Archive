import java.util.*;

public class TestCompare {


    private static class person implements Comparable<person> {
        int height;
        int weight;
        int index;

        public person(int h, int w, int i) {
            height = h;
            weight = w;
            index = i;

        }

        public int compareTo(person p) {

            return Integer.compare(height, p.height);

        }

        public void print() {
            System.out.println("Person: "+ index + " Height is: " + height + " Weight is: " + weight);
        }
    }
    public static void main(String[]args) {


        person[] person = new person[5];
        ArrayList<person> personList = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 5; i ++) {
            person[i] = new person(r.nextInt(200), r.nextInt(300), i);
        }
        for (int i = 0; i < 50; i ++) {
            person temp = new person(r.nextInt(200), r.nextInt(300), i);
            personList.add(temp);
        }

        Arrays.sort(person);
        for (person p: person) {
            p.print();
        }
    }
}
