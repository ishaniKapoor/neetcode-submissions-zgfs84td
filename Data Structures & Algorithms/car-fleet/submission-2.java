class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // make a pair of position and speed list of all position and speed
        // arrays.sort by using compare by position
        // Stack<Double> variable
        // for every pair in pairs, stack.push(current time for this pair)
        // while stack size is >=2 and stack's latest is less than the second last
        // pop the latest entry in stack
        // return stack.size

        int[][] pair = new int[position.length][2];
        for (int i = 0; i < position.length; i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();
        for (int[] p: pair){
            stack.push((double) (target - p[0])/ p[1]);
            while (stack.size() >= 2 &&
            stack.peek() <= stack.get(stack.size() - 2)){
                stack.pop();
            }
        }
        return stack.size();
    }
}
