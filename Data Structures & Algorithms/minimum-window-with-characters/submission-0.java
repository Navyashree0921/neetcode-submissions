class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()){
            return "";
        }
        int freq[] = new int[128];
        for(int i=0; i<t.length(); i++){
            freq[t.charAt(i)]++;
        }
        int left = 0;
        int start = 0;
        int count = 0;
        int minlen = Integer.MAX_VALUE;
        for(int right=0; right<s.length(); right++){
            if(freq[s.charAt(right)]>0){
                count++;
            }
            freq[s.charAt(right)]--;
            while(count==t.length()){
                if(right-left+1 < minlen){
                    minlen = right-left+1;
                    start = left;
                }
                freq[s.charAt(left)]++;
                if(freq[s.charAt(left)]>0){
                    count--;
                   }
                left++;
            }
        }
        if(minlen==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start, start+minlen);
    }
}
