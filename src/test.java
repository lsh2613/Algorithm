import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.remove(0);
        int size = list.size();
        System.out.println("현재 요소 개수: " + size);
    }
}
