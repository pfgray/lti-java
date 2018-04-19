package net.paulgray.lti.launch;

import java.util.HashMap;
import java.util.Map;

public class LaunchHelpers {

    public static <K, V> Map<K, V> mapOf(Map.Entry<K, V>... entries) {
        Map<K, V> map = new HashMap<>();
        for (Map.Entry<K, V> e : entries) {
            map.put(e.getKey(), e.getValue());
        }
        return map;
    }

    public static <K, V> Map.Entry<K, V> e(K k, V v) {
        return new SimpleEntry<>(k, v);
    }

    public static class SimpleEntry<K, V> implements Map.Entry<K, V> {
        private K key;
        private V value;

        public SimpleEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }
    }
}
