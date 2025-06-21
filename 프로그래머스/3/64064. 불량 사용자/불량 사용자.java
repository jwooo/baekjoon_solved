import java.util.*;

class Solution {

    static int answer = 0;
    static boolean[] visitedUserId;
    static Set<String> useIds = new HashSet<>();
    static List<String> users = new ArrayList<>();

    public int solution(String[] user_id, String[] banned_id) {
        visitedUserId = new boolean[user_id.length];

        dfs(0, user_id, banned_id);

        return answer;
    }

    private void dfs(int depth, String[] userIds, String[] bannedIds) {
        if (depth == bannedIds.length) {
            Collections.sort(users);

            StringBuilder answerBuilder = new StringBuilder();
            for (int i = 0; i < users.size(); i++) {
                answerBuilder.append(users.get(i)).append("_");
            }

            String result = answerBuilder.toString();
            if (!useIds.contains(result)) {
                useIds.add(result);
                answer++;
            }

            return;
        }

        String bannedId = bannedIds[depth];

        for (int i = 0; i < userIds.length; i++) {
            if (!visitedUserId[i]) {
                if (isBannedId(userIds[i], bannedId)) {
                    visitedUserId[i] = true;
                    users.add(userIds[i]);

                    dfs(depth + 1, userIds, bannedIds);

                    visitedUserId[i] = false;
                    users.remove(userIds[i]);
                }
            }
        }
    }

    private boolean isBannedId(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) return false;

        for (int i = 0; i < userId.length(); i++) {
            char userChar = userId.charAt(i);
            char bannedChar = bannedId.charAt(i);

            if (bannedChar == '*') continue;
            if (userChar != bannedChar) return false;
        }

        return true;
    }
}