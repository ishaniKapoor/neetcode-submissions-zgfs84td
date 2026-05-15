class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        /**
            cars at different positions each with speed
            no passing
            fast car can only catch up, once it does
            we combine to a single fleet
            count distinct groups (fleets) arriving at target

            sort cars by position descending
            fleets = 0
            Stack<Integer> prevTime
            for each car:
                time = (target - position) / speed
                if (time > prevTime.peek()):
                    fleet++
                    stack.push(time)
                else
                    stack.pop    
        **/

        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> prev = new Stack<>();
        for (int[] car: cars){
            double time = (double)(target - car[0]) / car[1];
            if (prev.isEmpty() || time > prev.peek()){
                prev.push(time);
            }
        }
        return prev.size();
    }
}
