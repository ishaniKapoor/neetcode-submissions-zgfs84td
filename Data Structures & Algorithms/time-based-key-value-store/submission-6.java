class TimeMap {

    HashMap<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
        .add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> values = map.getOrDefault(key, new ArrayList<>());
        String res = "";
        if (values.size() == 0) return "";
        int l = 0, r = values.size() - 1;
        while (l <= r){
            int mid = (l + r) / 2;
            if (values.get(mid).key <= timestamp){
                res = values.get(mid).value;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    private class Pair<K, V> {
        private final K key;
        private final V value;

        private Pair(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
}
