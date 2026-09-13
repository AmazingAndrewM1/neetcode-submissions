class TimeMap {
    private record TimeInfo(int timestamp, String value){}
    private Map<String, List<TimeInfo>> timeMap;


    public TimeMap() {
        timeMap = new HashMap<String, List<TimeInfo>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!timeMap.containsKey(key)){
            timeMap.put(key, new ArrayList<TimeInfo>());
        }
        timeMap.get(key).add(new TimeInfo(timestamp, value));
    }
    
    public String get(String key, int timestamp){
        List<TimeInfo> timeInfos = timeMap.get(key);
        if (timeInfos == null || timestamp < timeInfos.get(0).timestamp()){
            return "";
        }

        int left = 0;
        int right = timeInfos.size() - 1;
        while (left < right){
            int mid = (left + right + 1) / 2;
            if (timeInfos.get(mid).timestamp() > timestamp){
                right = mid - 1;
            }
            else{
                left = mid;
            }
        }
        return timeInfos.get(left).value();
    }
}
