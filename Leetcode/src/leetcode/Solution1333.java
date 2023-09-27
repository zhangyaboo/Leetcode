package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution1333 {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        int len = restaurants.length;
        ArrayList<Integer> list = new ArrayList<>();
        //判断
        for (int i = 0; i < len; i++) {
            if (restaurants[i][2] >= veganFriendly && restaurants[i][3] <= maxPrice && restaurants[i][4] <= maxDistance) {
                list.add(i + 1);
            }
        }
        list.sort(((o1, o2) -> {
            if (restaurants[o1 - 1][1] > restaurants[o2 - 1][1]) return -1;
            if (restaurants[o1 - 1][1] == restaurants[o2 - 1][1] && restaurants[o1 - 1][0] > restaurants[o2 - 1][0])
                return -1;
            if (restaurants[o1 - 1][1] == restaurants[o2 - 1][1] && restaurants[o1 - 1][0] == restaurants[o2 - 1][0])
                return 0;
            return 1;
        }));
        ArrayList<Integer> results = new ArrayList<>();
        for (Integer e : list) {
            results.add(restaurants[e - 1][0]);
        }

        return results;
    }
}