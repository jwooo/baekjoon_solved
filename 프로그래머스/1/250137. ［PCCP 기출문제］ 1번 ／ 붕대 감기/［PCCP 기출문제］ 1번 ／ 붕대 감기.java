class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int nowTime = 0;
        int maxHealth = health;
        
        for (int i = 0; i < attacks.length; i++) {
            int attackTime = attacks[i][0];
            int damage = attacks[i][1];
            
            int timeGap = attackTime - nowTime - 1;
            
            int divideHealth = (timeGap / bandage[0]) * bandage[1] * bandage[0] + (timeGap / bandage[0]) * bandage[2];
            int modHealth = (timeGap % bandage[0]) * bandage[1];
            
            int recoveryHealth = divideHealth + modHealth;
            
            health = Math.min(maxHealth, health + recoveryHealth);
            
            health -= damage;
            nowTime = attackTime;
            
            if (health <= 0) return -1;
        }
        
        return health;
    }
}