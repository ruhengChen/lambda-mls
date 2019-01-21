package com.yatop.lambda.workflow.core.utils;

import com.google.common.collect.Multimap;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

import java.util.*;

public class CollectionUtil {

    public static <M extends Map<K, V>, K, V> V get(M map, K key) {
        if(DataUtil.isNull(map) || DataUtil.isNull(key))
            return null;

        return map.get(key);
    }

    public static <M extends Map<K, V>, K, V> boolean containsKey(M map, K key) {
        if(DataUtil.isNull(map) || DataUtil.isNull(key))
            return false;

        return map.containsKey(key);
    }

    public static <M extends Map<K, V>, K, V> void put(M map, K key, V value) {
        if(DataUtil.isNull(map) || DataUtil.isNull(key) || DataUtil.isNull(value))
            return;

        map.put(key, value);
    }

    public static <M extends Map<K, V>, K, V> V remove(M map, K key) {
        if(DataUtil.isNull(map) || DataUtil.isNull(key))
            return null;

        return map.remove(key);
    }

    public static <M extends Map<K, V>, K, V> List<V> toList(M map) {
        if(DataUtil.isNull(map) || map.isEmpty())
            return null;

        List<V> vlist = new ArrayList<V>(map.size());
        for(Map.Entry<K, V> entry : map.entrySet()) {
            vlist.add(entry.getValue());
        }

        return vlist;
    }

    public static <M extends Map<K, V>, K, V> void clear(M map) {
        if(DataUtil.isNull(map) || map.isEmpty())
            return;
        map.clear();
    }

    public static <M extends Map<K, V>, K, V extends IRichModel> void enhancedClear(M map) {
        if(DataUtil.isNull(map) || map.isEmpty())
            return;

        for(Map.Entry<K, V> entry : map.entrySet()) {
            entry.getValue().clear();
        }

        map.clear();
    }

    public static <M extends Map<K, List<V>>, K, V> void put4ChainMap(M map, K key, V value) {
        if(DataUtil.isNull(map) || DataUtil.isNull(key) || DataUtil.isNull(value))
            return;

        List<V> chainList = map.get(key);
        if(DataUtil.isNotEmpty(chainList)) {
            chainList.add(value);
        } else {
            chainList = new ArrayList<V>();
            chainList.add(value);
            map.put(key, chainList);
        }
    }

    public static <M extends Map<K, List<V>>, K, V> List<V> toList4ChainMap(M map) {
        if(DataUtil.isNull(map) || map.isEmpty())
            return null;

        TreeMap<K, V> mergeMap = new TreeMap<K, V>();
        for(Map.Entry<K, List<V>> entry : map.entrySet()) {
            for(V data : entry.getValue()) {
                mergeMap.put(entry.getKey(), data);
            }
        }
        return CollectionUtil.toList(mergeMap);
    }

    public static <M extends Multimap<K, V>, K, V> List<V> toList(M map) {
        if(DataUtil.isNull(map) || map.isEmpty())
            return null;

        List<V> vlist = new ArrayList<V>(map.size());
        for(Map.Entry<K, V> entry : map.entries()) {
            vlist.add(entry.getValue());
        }

        return vlist;
    }

    public static <M extends Multimap<K, V>, K, V> void clear(M map) {
        if(DataUtil.isNull(map) || map.isEmpty())
            return;
        map.clear();
    }

    public static <S extends Set<K>, K> boolean contains(S set, K key) {
        if(DataUtil.isNull(set) || DataUtil.isNull(key))
            return false;

        return set.contains(key);
    }

    public static <S extends Set<K>, K> void add(S set, K key) {
        if(DataUtil.isNull(set) || DataUtil.isNull(key))
            return;

        set.add(key);
    }

    public static <S extends Set<K>, K> void remove(S set, K key) {
        if(DataUtil.isNull(set) || DataUtil.isNull(key))
            return;

        set.remove(key);
    }

    public static <S extends Set<K>, K> List<K> toList(S set) {
        if(DataUtil.isNull(set) || set.isEmpty())
            return null;

        List<K> vlist = new ArrayList<K>(set.size());
        for(K key : set) {
            vlist.add(key);
        }

        return vlist;
    }

    public static <L extends List<V>, V> void add(L list, V value) {
        if(DataUtil.isNull(list) || DataUtil.isNull(value))
            return;

        list.add(value);
    }

    public static <L extends List<V>, V extends IRichModel> void enhancedClear(L list) {
        if(DataUtil.isEmpty(list))
            return;

        for(IRichModel model : list) {
            model.clear();
        }

        list.clear();
    }

    public static <L extends List<V>, V> boolean equals(L lhs, L rhs) {
        if(DataUtil.isEmpty(lhs) || DataUtil.isEmpty(rhs))
            return false;

        return lhs.equals(rhs);
    }

    public static <Q extends Deque<V>, V> void offerLast(Q queue, V value) {
        if(DataUtil.isNull(queue))
            return;
        queue.offerLast(value);
    }

    public static <Q extends Deque<V>, V> V pollLast(Q queue) {
        if(DataUtil.isNull(queue))
            return null;
        return queue.pollLast();
    }

    public static <C extends Collection<V>, V> void clear(C collection) {
        if(DataUtil.isEmpty(collection))
            return;
        collection.clear();
    }
}
