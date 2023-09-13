class LFUCache {
    private int capacity;
    private Map<Integer, Integer> keyToValue;
    private Map<Integer, Integer> keyToFrequency;
    private Map<Integer, LinkedHashSet<Integer>> frequencyToKeys;
    private int minFrequency;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.keyToValue = new HashMap<>();
        this.keyToFrequency = new HashMap<>();
        this.frequencyToKeys = new HashMap<>();
        this.minFrequency = 0;
    }

    public int get(int key) {
        if (!keyToValue.containsKey(key)) {
            return -1; // Key not found
        }

        int frequency = keyToFrequency.get(key);
        keyToFrequency.put(key, frequency + 1);

        // Remove key from current frequency and update minFrequency if needed
        LinkedHashSet<Integer> keysWithSameFrequency = frequencyToKeys.get(frequency);
        keysWithSameFrequency.remove(key);
        if (frequency == minFrequency && keysWithSameFrequency.isEmpty()) {
            minFrequency++;
        }

        // Add key to the next frequency
        frequencyToKeys.computeIfAbsent(frequency + 1, k -> new LinkedHashSet<>()).add(key);

        return keyToValue.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return; // Capacity is zero, so no operation can be performed.
        }

        if (keyToValue.containsKey(key)) {
            // Key already exists, update its value and increase its frequency
            keyToValue.put(key, value);
            get(key); // Increment frequency
        } else {
            if (keyToValue.size() >= capacity) {
                // Evict the least frequently used item
                LinkedHashSet<Integer> keysWithMinFrequency = frequencyToKeys.get(minFrequency);
                int keyToRemove = keysWithMinFrequency.iterator().next();
                keysWithMinFrequency.remove(keyToRemove);
                keyToValue.remove(keyToRemove);
                keyToFrequency.remove(keyToRemove);
            }

            // Insert the new key with frequency 1
            keyToValue.put(key, value);
            keyToFrequency.put(key, 1);
            frequencyToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);

            // Since a new key is inserted, minFrequency becomes 1
            minFrequency = 1;
        }
    }
}
