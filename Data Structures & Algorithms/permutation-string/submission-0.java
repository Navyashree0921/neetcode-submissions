class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int freq[] = new int[26];
        int left = 0;
        int count=0;
        for(int i=0; i<s1.length(); i++){
            freq[s1.charAt(i)-'a']++;
        }
        for(int right=0; right<s2.length(); right++){
            if(freq[s2.charAt(right)-'a']>0){
                count++;
            }
            freq[s2.charAt(right)-'a']--;

            if(right-left+1 > s1.length()){
                freq[s2.charAt(left)-'a']++;
                if(freq[s2.charAt(left)-'a']>0){
                    count--;
                }
                left++;
            }
            if(count==s1.length()){
                return true;
            }
        }
        return false;
    }
}
