class Solution {
    String beg;
    List<List<String>> res;
    HashMap<String, Integer> map;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        map = new HashMap<>();

        beg = beginWord;

        q.add(beginWord);
        map.put(beginWord, 1);

        Set<String> words = new HashSet<>(wordList);
        words.remove(beginWord);

        while (!q.isEmpty()) {
            String word = q.poll();
            int steps = map.get(word);

            if (word.equals(endWord))
                break;

            StringBuilder sb = new StringBuilder(word);
            for (int i = 0; i < word.length(); i++) {
                char og = word.charAt(i);
                for (char c = 'a'; c <= 'z'; c++) {
                    sb.setCharAt(i, c);
                    String modified = sb.toString();

                    if (words.contains(modified)) {
                        q.add(modified);
                        words.remove(modified);
                        map.put(modified, steps + 1);
                    }
                }
                sb.setCharAt(i, og);
            }
        }

        // System.out.println(map);
        if (map.containsKey(endWord)) {
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord, seq);
        }

        return res;
    }

    private void dfs(String word, List<String> seq) {
        if (word.equals(beg)) {
            List<String> dup = new ArrayList<>(seq);
            Collections.reverse(dup);
            res.add(dup);
            return;
        }

        int steps = map.get(word);

        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < word.length(); i++) {
            char og = word.charAt(i);
            for (char c = 'a'; c <= 'z'; c++) {
                sb.setCharAt(i, c);
                String modified = sb.toString();

                if (map.containsKey(modified) && map.get(modified)+1 == steps) {
                    seq.add(modified);
                    dfs(modified, seq);
                    seq.remove(modified);
                }
            }
            sb.setCharAt(i, og);
        }
    }
}