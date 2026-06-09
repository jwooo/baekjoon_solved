import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreTotal = new HashMap<>();
        Map<String, List<Song>> genreSongs = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            
            genreTotal.put(genre,
                          genreTotal.getOrDefault(genre, 0) + plays[i]);
            
            genreSongs
                .computeIfAbsent(genre, k -> new ArrayList<>())
                .add(new Song(i, plays[i]));
        }
        
        List<String> sortedGenres = new ArrayList<>(genreTotal.keySet());
        sortedGenres.sort((a, b) -> genreTotal.get(b) - genreTotal.get(a));
        
        List<Integer> answer = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<Song> songs = genreSongs.get(genre);
            songs.sort((s1, s2) -> {
                if (s1.play == s2.play) {
                    return s1.index - s2.index;
                }
                
                return s2.play - s1.play;
            });
            
            answer.add(songs.get(0).index);
            
            if (songs.size() > 1) {
                answer.add(songs.get(1).index);
            }
        }
        
        return answer.stream()
            	.mapToInt(Integer::intValue)
            	.toArray();
    }
    
    static class Song {
        int index;
        int play;
        
        Song (int index, int play) {
            this.index = index;
            this.play = play;
        }
    }
    
}