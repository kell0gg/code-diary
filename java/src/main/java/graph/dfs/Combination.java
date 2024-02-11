package graph.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Combination {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> elements = new ArrayDeque<>();
        dfs(elements, 5, 1, 3, result);
        result.forEach(System.out::println);
    }

    private static void dfs(Deque<Integer> elements, int count, int start, int remainingCount, List<List<Integer>> result) {
        if (remainingCount == 0) {
            result.add(new ArrayList<>(elements));
            return;
        }

        // permutation 과는 다르게 시작하는 지점이 변경됨
        for (int i = start; i <= count; i++) {
            elements.addLast(i);
            dfs(elements, count, i + 1, remainingCount - 1, result);
            elements.pollLast();
        }
    }
    /* 
    k 가 고정되어있다면 대충 for loop 돌려도 됨
    public static void printCombinations(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int l = j + 1; l <= n; l++) {
                    System.out.println(i + " " + j + " " + l);
                }
            }
        }
    }
     */
}


