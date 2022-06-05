package programmers.hash;

import java.util.*;

public class 베스트앨범 {

    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        Map<String, ArrayList<Music>> map = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            // 재생 카운트 추가
            Integer count = countMap.getOrDefault(genres[i], 0);
            countMap.put(genres[i], count + plays[i]);

            // 음악 추가
            ArrayList<Music> musics = map.getOrDefault(genres[i], new ArrayList<>());
            musics.add(new Music(i, plays[i]));
            map.put(genres[i], musics);
        }

        ArrayList<Genre> list = new ArrayList<>();

        for (Map.Entry<String, ArrayList<Music>> entry : map.entrySet()) {
            ArrayList<Music> musics = entry.getValue();

            // 재생순위 정렬 (내림차순)
            Collections.sort(musics, (a, b) -> {
                if (b.count - a.count == 0) {
                    return a.seq - b.seq;
                }
                return b.count - a.count;
            });

            // 재생순위 상위 2개 고유 번호 추가
            ArrayList<Integer> seqs = new ArrayList<>();
            if (musics.size() < 2) {
                for (int i = 0; i < musics.size(); i++)
                    seqs.add(musics.get(i).seq);
            } else {
                seqs.add(musics.get(0).seq);
                seqs.add(musics.get(1).seq);
            }

            list.add(new Genre(countMap.get(entry.getKey()), seqs));
        }

        Collections.sort(list, (a, b) -> {
            return b.count - a.count;
        });

        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).seqs.size(); j++) {
                answer.add(list.get(i).seqs.get(j));
            }
        }
        return answer;
    }

    static class Genre {
        int count;
        ArrayList<Integer> seqs;

        public Genre(int count, ArrayList<Integer> seqs) {
            this.count = count;
            this.seqs = seqs;
        }
    }

    static class Music {
        int seq;
        int count;

        public Music(int seq, int count) {
            this.seq = seq;
            this.count = count;
        }

        @Override
        public String toString() {
            return "[" + seq + "]" + " -> " + count;
        }
    }
}
