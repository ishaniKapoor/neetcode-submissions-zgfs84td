class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks){
            freq[c - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>
        (Collections.reverseOrder());
        for (int c: freq){
            if (c > 0) maxHeap.add(c);
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        while (!maxHeap.isEmpty() || !q.isEmpty()){
            time++;
            if (maxHeap.isEmpty()){
                time = q.peek()[1];
            } else {
                int c = maxHeap.poll() - 1;
                if (c > 0) {
                    q.add(new int[]{c, time + n});
                }
            }

            if (!q.isEmpty() && q.peek()[1] == time){
                maxHeap.add(q.poll()[0]);
            }
        }
        return time;

    }
}
