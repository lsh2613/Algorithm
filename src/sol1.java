import java.util.*;

class Genre{
    String name;
    int cnt;
    int idx;

    int getCnt(){
        return cnt;
    }

    Genre(String n, int c){
        name=n;
        cnt=c;
    }
    Genre(int i, int c){
        idx=i;
        cnt=c;
    }
}

class sol1 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        StringBuilder sb = new StringBuilder();

        // 장르별 재생횟수 합계
        Map<String, Integer> genreTotal = new HashMap<>();
        // 장르별 각 노래들의 정보
        Map<String, ArrayList<Genre>> genre_songs = new HashMap<>();

        // map 초기화
        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int playCnt = plays[i];

            if(genreTotal.containsKey(genre))
                genreTotal.put(genre, genreTotal.get(genre)+playCnt);
            else
                genreTotal.put(genre, playCnt);

            if(genre_songs.containsKey(genre)){
                ArrayList<Genre> songs= genre_songs.get(genre);
                songs.add(new Genre(i, playCnt));
                genre_songs.put(genre, songs);
            }
            else{
                ArrayList<Genre> songs= new ArrayList<>();
                songs.add(new Genre(i, playCnt));
                genre_songs.put(genre, songs);
            }
        }

        ArrayList<Genre> genreList = new ArrayList<>();
        for(String genre : genreTotal.keySet()){
            genreList.add(new Genre(genre, genreTotal.get(genre)));
        }

        // 내림차순 정렬
        genreList.sort(Comparator.comparingInt(Genre::getCnt).reversed());

        // 재생 횟수가 많은 장르부터 탐색
        for (Genre genre : genreList) {
            String name = genre.name;
            ArrayList<Genre> songs = genre_songs.get(name);
            songs.sort((a,b)->{
                if(a.cnt==b.cnt)
                    return a.idx-b.idx;
                return b.cnt-a.cnt;
            });

            // 최대2개
            int len=0;
            if(songs.size()%2==1){
                len= songs.size()-1;
            }
            else len=songs.size();

            for (int i = 0; i < len; i++) {
                sb.append(songs.get(i).idx+" ");
            }

        }

        answer = Arrays.stream(sb.toString().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        return answer;
    }

}



