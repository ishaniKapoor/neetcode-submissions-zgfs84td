/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        /*
         sort intervals with first elem
         check two intervals if start time elems don't conflict move on to
        end times and then move on to next intervals
        */
        intervals.sort(Comparator.comparingInt(i -> i.start));
        for (int i = 1; i < intervals.size(); i++){
            if (intervals.get(i - 1).end > intervals.get(i).start){
                return false;
            }
        }
        return true;
    }
}
