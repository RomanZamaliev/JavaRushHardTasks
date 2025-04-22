package com.javarush.task.task36.task3610;


import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        int size = 0;
        for(Map.Entry<K, List<V>> entry: map.entrySet()){
            for(V elem: entry.getValue()){
                size++;
            }
        }
        return size;
        //напишите тут ваш код
    }

    @Override
    public V put(K key, V value) {
        //напишите тут ваш код
        if(map.containsKey(key)){
            List<V> currList = map.get(key);
            if(currList.size() == repeatCount){
                currList.add(value);
                currList.remove(0);
                return currList.get(repeatCount - 2);
            }
            else{
                currList.add(value);
                return currList.get(currList.size() - 2);
            }
        }
        else{
            List<V> newList = new ArrayList<>(1);
            newList.add(value);
            map.put(key, newList);
            return null;
        }
    }

    @Override
    public V remove(Object key) {
        if (map.get(key) != null) {
            List<V> list = map.get(key);
            V temp = list.remove(0);
            if (list.isEmpty()) {
                map.remove(key);
            }
            return temp;
        } else {
            return null;
        }
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        List<V> allValues = new ArrayList<>(map.size());
        for(Map.Entry<K, List<V>> entry: map.entrySet()) {
            allValues.addAll(entry.getValue());
        }
        return allValues;

    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        return values().contains(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}