class Solution {
    public String solution(String new_id) {
        StringBuilder passwordBuilder = new StringBuilder(new_id);
        
        transformLowerCase(passwordBuilder);
        passwordBuilder = removeSpecialCharacter(passwordBuilder);
        passwordBuilder = reducePeriod(passwordBuilder);
        removeEndPoint(passwordBuilder);
        
        if (passwordBuilder.length() == 0) {
            passwordBuilder.append('a');
        }
        
        if (passwordBuilder.length() >= 16) {
            passwordBuilder = new StringBuilder(passwordBuilder.substring(0, 15));
            removeEndPoint(passwordBuilder);
        }
        
        if (passwordBuilder.length() <= 2) {
            int length = passwordBuilder.length();
            
            int loops = 3 - length;
            char lastCharacter = passwordBuilder.charAt(length - 1);
            
            
            for (int i = 0; i < loops; i++) {
                passwordBuilder.append(lastCharacter);
            }
        }
        
        return passwordBuilder.toString();
    }
    
    private void transformLowerCase(StringBuilder passwordBuilder) {
        for (int i = 0; i < passwordBuilder.length(); i++) {
            char now = passwordBuilder.charAt(i);
         
            if (Character.isUpperCase(now)) {
                passwordBuilder.setCharAt(i, Character.toLowerCase(now));
            }
        }
    }
    
    private StringBuilder removeSpecialCharacter(StringBuilder passwordBuilder) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < passwordBuilder.length(); i++) {
            char now = passwordBuilder.charAt(i);
            
            if (Character.isLetterOrDigit(now) || now == '-' || now == '_' || now == '.') {
                result.append(now);
            }
        }
        
        return result;
    }
    
    private StringBuilder reducePeriod(StringBuilder passwordBuilder) {
        StringBuilder result = new StringBuilder();
        int periodCount = 0;
        
        for (int i = 0; i < passwordBuilder.length(); i++) {
            char now = passwordBuilder.charAt(i);
         
            if (periodCount != 0 && now != '.') {
                result.append('.').append(now);
                periodCount = 0;
            } else if (now == '.') {
                periodCount++;
            } else {
                result.append(now);
            }
        }
        
        return result;
    }
    
    private void removeEndPoint(StringBuilder passwordBuilder) {
        if (passwordBuilder.length() > 0 && passwordBuilder.charAt(0) == '.') {
            passwordBuilder.deleteCharAt(0);
        }
        
        
        int lastIndex = passwordBuilder.length() - 1;
        if (passwordBuilder.length() > 0 && passwordBuilder.charAt(lastIndex) == '.') {
            passwordBuilder.deleteCharAt(lastIndex);
        }
    }
    
}