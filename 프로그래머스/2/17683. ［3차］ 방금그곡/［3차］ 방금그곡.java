import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String melody = replaceSharp(m);
        List<Music> musics = new ArrayList<>();

        for (int i = 0; i < musicinfos.length; i++) {
            String[] musicInfo = musicinfos[i].split(",");

            int musicTime = getTimeDifference(musicInfo[0], musicInfo[1]);
            String musicName = musicInfo[2];
            String musicMelody = musicInfo[3];
            
            int index = 0;
            int count = musicTime;
            StringBuilder sb = new StringBuilder();
            while (count > 0) {
                sb.append(musicMelody.charAt(index % musicMelody.length()));

                char next = (musicMelody.charAt((index + 1) % musicMelody.length()));
                if (next == '#') {
                    sb.append(next);
                    index++;
                }

                index++;
                count--;
            }

            String playedMusic = replaceSharp(sb.toString());
            if (playedMusic.contains(melody)) musics.add(new Music(musicName, musicTime));
        }

        if (musics.isEmpty()) return "(None)";
        Collections.sort(musics);

        return musics.get(0).name;
    }
    
    private int getTimeDifference(String startTime, String endTime) {
        return extractTime(endTime) - extractTime(startTime);
    }

    private int extractTime(String strTime) {
        String[] times = strTime.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }

    private String replaceSharp(String melody) {
        return melody.replaceAll("C#", "c")
            .replaceAll("D#", "d")
            .replaceAll("F#", "f")
            .replaceAll("G#", "g")
            .replaceAll("A#", "a")
            .replaceAll("E#", "e")
            .replaceAll("B#", "b");
    }

    static class Music implements Comparable<Music> {
        String name;
        int time;
        
        public Music(String name, int time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public int compareTo(Music other) {
            return other.time - this.time;
        }
    }
}