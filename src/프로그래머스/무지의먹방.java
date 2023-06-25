package 프로그래머스;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 무지의먹방 {
    class Food{
        int time;
        int idx;

        Food(int t, int i) {
            time = t;
            idx = i;
        }
    }


    public int solution(int[] food_times, long k) {
        List<Food> foods = new ArrayList<>();
        int n = food_times.length;
        for (int i = 0; i < n; i++) {
            foods.add(new Food(food_times[i], i + 1));
        }

        foods.sort(new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return o1.time - o2.time;
            }
        });

        int prev = 0;
        int i = 0;
        for (Food f : foods) {
            long diff = f.time - prev;
            if (diff != 0) {
                long spend = diff * n;
                if (spend <= k) {
                    k -= spend;
                } else {
                    k %= n;
                    foods.subList(i, food_times.length).sort(new Comparator<Food>() {
                        @Override
                        public int compare(Food o1, Food o2) {
                            return o1.idx - o2.idx;
                        }
                    });
                    return foods.get(i+(int)k).idx;

                }
            }
            i++;
            n--;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
