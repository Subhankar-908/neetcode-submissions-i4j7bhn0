class Solution {
    public boolean isPalindrome(String s) {
        int n=s.length();
        int l=0;
        int r=n-1;

        while(l<r){
            

            while(l<r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while(l<r && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }
            char c1=Character.toLowerCase(s.charAt(l));
            char c2=Character.toLowerCase(s.charAt(r));
            if(c1!=c2) return false;
            l++;
            r--;
        }
        return true;
    }
}
