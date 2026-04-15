class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone: stones) pq.offer(stone);

        // 6, 4, 3, 2, 2
        while (pq.size() > 1){
            int y = pq.poll(), x = pq.poll();
            if (x < y) {
                int diff = y - x;
                pq.offer(diff);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
