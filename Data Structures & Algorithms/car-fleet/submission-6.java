class Solution {
    private class FleetInfo{
        public int position;
        public double timeArrived;

        FleetInfo(int position, double timeArrived){
            this.position = position;
            this.timeArrived = timeArrived;
        }

        public boolean willPass(FleetInfo other){
            return Double.compare(this.timeArrived, other.timeArrived) <= 0;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        /*
            Sort the cars based on position.
            Calculate the number of steps a fleet takes to reach destination
            Break ties by calculating the final position
        */

        List<FleetInfo> fleets = new ArrayList<FleetInfo>(position.length);
        for (int i = 0; i < position.length; ++i){
            fleets.add(new FleetInfo(position[i], (target - position[i]) / (double) speed[i]));
        }
        Collections.sort(fleets, (FleetInfo a, FleetInfo b) -> b.position - a.position);

        Deque<FleetInfo> stack = new ArrayDeque<FleetInfo>(fleets.size());
        for (FleetInfo fleet: fleets){
            if (stack.isEmpty() || !fleet.willPass(stack.peekFirst())){
                stack.addFirst(fleet);
            }
        }

        return stack.size();
    }
}
