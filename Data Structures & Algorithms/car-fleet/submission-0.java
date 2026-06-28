class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();
        double[][] cars = new double[position.length][2];

        for(int i=0; i<position.length; i++){
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i])/speed[i];
        }

        Arrays.sort(cars, (a,b) -> Double.compare(a[0], b[0]));

        for(int i = position.length-1; i>=0; i--){
            stack.push(cars[i][1]);

            if(stack.size() >= 2 && stack.peek() <= stack.get(stack.size()-2)){
                stack.pop();
            }
        }

        return stack.size();
    }
}
