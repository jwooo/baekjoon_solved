import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {

    static class Page {
        String url;
        int basicScore;
        int linkCount;
        double linkScore;

        Page(String url, int basicScore, int linkCount) {
            this.url = url;
            this.basicScore = basicScore;
            this.linkCount = linkCount;
        }

        double getMatchingScore() {
            return basicScore + linkScore;
        }
    }

    public int solution(String word, String[] pages) {
        int n = pages.length;

        Page[] pageInfo = new Page[n];
        Map<String, Integer> urlToIndex = new HashMap<>();

        Pattern urlPattern =
                Pattern.compile("<meta property=\"og:url\" content=\"(.*?)\"");

        Pattern linkPattern =
                Pattern.compile("<a href=\"(.*?)\">");

        Pattern wordPattern =
                Pattern.compile("[a-zA-Z]+");

        word = word.toLowerCase();

        for (int i = 0; i < n; i++) {
            String page = pages[i];

            Matcher urlMatcher = urlPattern.matcher(page);
            urlMatcher.find();

            String url = urlMatcher.group(1);

            int basicScore = 0;

            Matcher wordMatcher = wordPattern.matcher(page);

            while (wordMatcher.find()) {
                if (wordMatcher.group().equalsIgnoreCase(word)) {
                    basicScore++;
                }
            }

            int linkCount = 0;

            Matcher linkMatcher = linkPattern.matcher(page);

            while (linkMatcher.find()) {
                linkCount++;
            }

            pageInfo[i] = new Page(url, basicScore, linkCount);
            urlToIndex.put(url, i);
        }

        for (int i = 0; i < n; i++) {
            Matcher matcher = linkPattern.matcher(pages[i]);

            while (matcher.find()) {
                String targetUrl = matcher.group(1);

                if (!urlToIndex.containsKey(targetUrl)) {
                    continue;
                }

                int targetIndex = urlToIndex.get(targetUrl);
                Page source = pageInfo[i];

                pageInfo[targetIndex].linkScore +=
                        (double) source.basicScore / source.linkCount;
            }
        }

        int answer = 0;
        double maxScore = -1;

        for (int i = 0; i < n; i++) {
            double score = pageInfo[i].getMatchingScore();

            if (score > maxScore) {
                maxScore = score;
                answer = i;
            }
        }

        return answer;
    }
}
