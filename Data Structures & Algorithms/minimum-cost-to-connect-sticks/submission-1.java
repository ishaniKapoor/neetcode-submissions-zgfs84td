class Solution {
    public int connectSticks(int[] sticks) {
        if (sticks.length <= 1) return 0;

        int res = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int stick: sticks) pq.add(stick);

        while (pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            int curr = a + b;
            res += curr;
            pq.add(curr);
        }
        return res;
    }
}
