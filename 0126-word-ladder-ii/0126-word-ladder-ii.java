class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        
        Set<String> dict = new HashSet<>(wordList);
        
        if (!dict.contains(endWord)) return result;

        Map<String, List<String>> parent = new HashMap<>();

        Map<String, Integer> distance = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);

        int shortestDistance = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int currentDistance = distance.get(current);

            if (currentDistance > shortestDistance) continue;

            char[] chars = current.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                char original = chars[i];

                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == original) continue;

                    chars[i] = c;
                    String next = new String(chars);

                    if (!dict.contains(next)) continue;

                    int nextDistance = currentDistance + 1;

                    if (!distance.containsKey(next)) {
                        distance.put(next, nextDistance);
                        queue.offer(next);

                        parent.put(next, new ArrayList<>());
                        parent.get(next).add(current);
                    } else if (distance.get(next) == nextDistance) {
                        parent.get(next).add(current);
                    }

                    if (next.equals(endWord)) {
                        shortestDistance = nextDistance;
                    } 
                }

                chars[i] = original;
            }
        }

        if (!distance.containsKey(endWord)) return result;

        List<String> path = new ArrayList<>();
        path.add(endWord);

        dfs(endWord, beginWord, parent, path, result);

        return result;
    }

    private void dfs(String current, String beginWord, Map<String, List<String>> parent, List<String> path, List<List<String>> result) {
        if (current.equals(beginWord)) {
            List<String> sequence = new ArrayList<>(path);
            Collections.reverse(sequence);
            result.add(sequence);
            return;
        }

        for (String previous : parent.getOrDefault(current, Collections.emptyList())) {
            path.add(previous);
            dfs(previous, beginWord, parent, path, result);
            path.remove(path.size() - 1);
        }
    }


}