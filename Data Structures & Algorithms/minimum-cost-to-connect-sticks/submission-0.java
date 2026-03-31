class Solution {
    public int connectSticks(int[] sticks) {
        if (sticks.length <= 1) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : sticks) pq.add(s);

        int cost = 0;
        while (pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            int sum = a + b;
            cost += sum;
            pq.add(sum);
        }
        return cost;
    }
}
