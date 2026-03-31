class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        for(int[] interval: intervals){
            int[] last = merged.get(merged.size() - 1);
            int start = interval[0];
            int end = interval[1];
            if (last[1] >= start){
                last[1] = Math.max(last[1], end);
            } else {
                merged.add(new int[]{start, end});
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
