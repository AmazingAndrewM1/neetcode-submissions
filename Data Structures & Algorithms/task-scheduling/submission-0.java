class Solution {
    private class TaskInfo{
        public int frequency;
        public int timeCanRun;

        public TaskInfo(){
            this.frequency = 0;
            this.timeCanRun = 1;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, TaskInfo> taskMap = new HashMap<Character, TaskInfo>();
        for (char task: tasks){
            if (!taskMap.containsKey(task)){
                taskMap.put(task, new TaskInfo());
            }
            taskMap.get(task).frequency++;
        }

        PriorityQueue<TaskInfo> maxHeap = new PriorityQueue<TaskInfo>(
            (a, b) -> Integer.compare(b.frequency, a.frequency)
        );
        maxHeap.addAll(taskMap.values());

        Deque<TaskInfo> cooldownTasks = new ArrayDeque<TaskInfo>(n);

        int time = 0;
        while (!maxHeap.isEmpty() || !cooldownTasks.isEmpty()){
            ++time;
            if (!cooldownTasks.isEmpty() && cooldownTasks.getFirst().timeCanRun <= time){
                maxHeap.offer(cooldownTasks.removeFirst());
            }
            
            TaskInfo currentTask = null;
            if (!maxHeap.isEmpty()){
                currentTask = maxHeap.poll();
                currentTask.frequency--;
                currentTask.timeCanRun = time + n + 1;
            }
            if (currentTask != null && currentTask.frequency > 0){
                cooldownTasks.addLast(currentTask);
            }
        }
        return time;
    }
}
