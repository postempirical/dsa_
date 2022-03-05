// https://leetcode.com/problems/find-the-winner-of-the-circular-game/
class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> friends = new ArrayList<>();
        for (int i = 1; i <= n; i++) friends.add(i);
        int index = 0;
        return josephus(k, n, index, friends);
    }
    
    int josephus(int k, int n, int index, List<Integer> friends) {
        if (friends.size() == 1) return friends.get(0);
        index = (index + k - 1) % friends.size();
        friends.remove(index);
        return josephus(k, n, index, friends);
    }
}
