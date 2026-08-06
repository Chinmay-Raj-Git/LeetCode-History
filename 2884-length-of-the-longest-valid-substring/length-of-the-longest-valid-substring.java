class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {

        HashSet<String> fs = new HashSet<>(forbidden);

        int left = 0;
        int ans = 0;

        for (int right = 0; right < word.length(); right++) {

            for (int start = right; start >= Math.max(left, right - 9); start--) {

                if (fs.contains(word.substring(start, right + 1))) {
                    left = start + 1;
                    break;
                }
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}