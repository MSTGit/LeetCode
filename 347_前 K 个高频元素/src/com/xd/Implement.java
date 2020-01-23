package com.xd;

import java.util.*;

public class Implement {


    /*
    * 使用桶排序思路进行优化。空间换时间
    * */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        //使用hashMap来保存每一个num的出现频次
        for (Integer num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        List<Map.Entry<Integer,Integer>>[] buckets = new List[nums.length + 1];//
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int count = entry.getValue();//获取出来的就是当前数字出现的次数
            List<Map.Entry<Integer,Integer>> bucket = buckets[count];//桶的索引为当前数字出现的次数
            //当前的桶获取出来，可能是空的
            if (bucket == null) {
                bucket = new LinkedList<>();
                buckets[count] = bucket;//将新建的桶，保存到桶数组中
            }
            bucket.add(entry);
        }
        List<Integer> result = new LinkedList<>();
        for (int i = nums.length; i > 0 && result.size() < k; i--) {
            if (buckets[i] == null) continue;
            List<Map.Entry<Integer,Integer>> bucket = buckets[i];
            for (Map.Entry<Integer,Integer> entry : bucket) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
    /*
    * 使用优先级队列：小顶堆
    * */
    public List<Integer> topKFrequent2(int[] nums, int k){
        Map<Integer,Integer> map = new HashMap<>();
        //使用hashMap来保存每一个num的出现频次
        for (Integer num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        //创建一个小顶堆，并设置大小比较关系,即比较的是value大小
        PriorityQueue<Integer> queue = new PriorityQueue<>((Integer i1,Integer i2) -> {
           return map.get(i1) - map.get(i2);
        });
        //map中所有的元素，进行入队
        for (Integer num : map.keySet()) {
            if (queue.size() < k){
                //队列中还没有key个元素
                queue.offer(num);
            } else if (map.get(num) > map.get(queue.peek())) {
                //堆中现在已经有k个元素，并且现在的堆顶元素频次大于准备入队元素的频次时，就将现在的堆顶元素移除，然后存入频次更大的元素
                //把堆顶元素移除
                queue.poll();
                //将新的元素加入队列中
                queue.offer(num);
            }
        }
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            result.add(0,queue.poll());
        }
        return result;

    }

    /*
    * 方法一：全排序
    * */
    public List<Integer> topKFrequent1(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        //使用hashMap来保存每一个num的出现频次
        for (Integer num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        Map.Entry<Integer,Integer>[] entries = new Map.Entry[map.size()];
        map.entrySet().toArray(entries);
        Arrays.sort(entries,(Map.Entry<Integer,Integer> e1,Map.Entry<Integer,Integer> e2) ->{
            return e2.getValue() - e1.getValue();
        });
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(entries[i].getKey());
        }
        return result;
    }
}
