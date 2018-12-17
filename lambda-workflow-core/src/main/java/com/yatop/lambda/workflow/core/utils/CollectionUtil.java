package com.yatop.lambda.workflow.core.utils;

import com.google.common.collect.SetMultimap;
import com.yatop.lambda.base.utils.LambdaRootModel;
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

    public static <M extends Map<K, V>, K, V> List<V> toList(M map) {
        if(DataUtil.isNull(map) || map.isEmpty())
            return null;

        List<V> vlist = new ArrayList<V>(map.size());
        for(Map.Entry<K, V> entry : map.entrySet()) {
            vlist.add(entry.getValue());
        }

        return vlist;
    }

    public static <M extends Map<K, V>, K, V extends IRichModel> void clear(M map) {
        if(DataUtil.isNull(map))
            return;

        for(Map.Entry<K, V> entry : map.entrySet()) {
            entry.getValue().clear();
        }

        map.clear();
    }

    public static <M extends SetMultimap<K, V>, K, V> List<V> toList(M map) {
        if(DataUtil.isNull(map) || map.isEmpty())
            return null;

        List<V> vlist = new ArrayList<V>(map.size());
        for(Map.Entry<K, V> entry : map.entries()) {
            vlist.add(entry.getValue());
        }

        return vlist;
    }

    public static <L extends List<IRichModel>> void clear(L list) {
        if(DataUtil.isNull(list))
            return;

        for(IRichModel model : list) {
            model.clear();
        }

        list.clear();
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

    public static <S extends Set<K>, K> List<K> toList(S set) {
        if(DataUtil.isNull(set) || set.isEmpty())
            return null;

        List<K> vlist = new ArrayList<K>(set.size());
        for(K key : set) {
            vlist.add(key);
        }

        return vlist;
    }
}
