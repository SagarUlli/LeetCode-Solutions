class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, String s, List<String> path, List<String> result) {
        if (path.size() == 4) {
            if (index == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }

        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) break;

            String part = s.substring(index, index + len);

            if (part.length() > 1 && part.charAt(0) == '0') continue;

            int value = Integer.parseInt(part);
            if (value > 255) continue;

            path.add(part);
            backtrack(index + len, s, path, result);
            path.remove(path.size() - 1); 
        }
    }
}