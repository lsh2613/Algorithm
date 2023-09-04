import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Test{
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(Arrays.asList(7, 8));
        System.out.println(integers.remove(7));
        System.out.println(integers);
    }
}