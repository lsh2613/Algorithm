package custom;

import java.util.*;

public class 내림차순및Rank예시 {
    static class Person {
        int h;
        int w;
        int rank = 1;

        public Person(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person(170, 60));
        people.add(new Person(180, 70));
        people.add(new Person(160, 50));
        people.add(new Person(175, 65));

        // 키(h)를 기준으로 내림차순 정렬
        people.sort(Comparator.comparingInt((Person p) -> p.h).reversed());

        int currentRank = 1;
        int previousHeight = people.get(0).h;

        // 키가 동일한 경우 같은 순위로 설정
        for (int i = 0; i < people.size(); i++) {
            Person person = people.get(i);
            if (person.h < previousHeight) {
                currentRank = i + 1;
            }
            person.rank = currentRank;
            previousHeight = person.h;
        }

        // 결과 출력
        for (Person person : people) {
            System.out.println("키: " + person.h + ", 몸무게: " + person.w + ", 순위: " + person.rank);
        }
    }
}
