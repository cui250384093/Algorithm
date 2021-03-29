package com.yl.greedy;

import java.util.*;

/**
 * @author candk
 * @Description
 * @date 3/27/21 - 2:45 PM
 */
public class GreedyAlgorithm {

    public static void main(String[] args) {
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();

        HashSet<String> broadcast1 = new HashSet<>();
        broadcast1.add("北京");
        broadcast1.add("上海");
        broadcast1.add("天津");

        HashSet<String> broadcast2 = new HashSet<>();
        broadcast2.add("广州");
        broadcast2.add("上海");
        broadcast2.add("深圳");

        HashSet<String> broadcast3 = new HashSet<>();
        broadcast3.add("成都");
        broadcast3.add("上海");
        broadcast3.add("杭州");

        HashSet<String> broadcast4 = new HashSet<>();
        broadcast4.add("上海");
        broadcast4.add("天津");

        HashSet<String> broadcast5 = new HashSet<>();
        broadcast5.add("杭州");
        broadcast5.add("大连");

        broadcasts.put("k1", broadcast1);
        broadcasts.put("k2", broadcast2);
        broadcasts.put("k3", broadcast3);
        broadcasts.put("k4", broadcast4);
        broadcasts.put("k5", broadcast5);

        String[] cities = new String[]{"北京", "上海", "天津", "广州",  "深圳"};
//        String[] cities = new String[]{"北京", "上海", "天津", "广州", "成都", "杭州", "大连", "深圳"};
        ArrayList<String> cityList = new ArrayList<>();
        Collections.addAll(cityList, cities);

        ArrayList<String> list = greedyAlgorithm(cityList, broadcasts);
        System.out.println(list);


    }

    public static ArrayList<String> greedyAlgorithm(ArrayList<String> cityList, HashMap<String, HashSet<String>> broadcasts) {
        ArrayList<String> requireBroads = new ArrayList<>();
        ArrayList<String> cities = new ArrayList<>(cityList);
        HashMap<String, HashSet<String>> broads = new HashMap<>();
        broads.putAll(broadcasts);


        while (cities.size() != 0) {
            String getCity = null;
            int[] value = new int[broads.size()];
            int index = 0;
            for (String key : broads.keySet()) {
                HashSet<String> broadCities = broads.get(key);
                for (String broadCity : broadCities) {
                    if (cities.contains(broadCity)) {
                        value[index]++;
                    }
                }

                if (index == 0) {
                    getCity = key;
                } else if (value[index] > value[index - 1]) {
                    getCity = key;
                }

                index++;
            }

            if (getCity != null) {
                requireBroads.add(getCity);
                HashSet<String> removeCities = broads.get(getCity);
                for (String removeCity : removeCities) {
                    cities.remove(removeCity);
                }
                broads.remove(getCity);
            }
        }

        return requireBroads;
    }
}
