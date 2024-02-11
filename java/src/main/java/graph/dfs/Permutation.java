package graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation {
    public static void main(String[] args) {
        int[] targets = new int[]{1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> remainingElements = Arrays.stream(targets).boxed().collect(Collectors.toList());
        dfs(new ArrayList<>(), remainingElements, result);
        for (List<Integer> s : result) {
            for (Integer e : s) {
                System.out.print(e);
            }
            System.out.println();
        }
    }

    private static void dfs(List<Integer> generatedElements, List<Integer> remainingElements, List<List<Integer>> result) {
        if (remainingElements.isEmpty()) {
            result.add(new ArrayList<>(generatedElements));
            return;
        }

        for (Integer element : remainingElements) {
            List<Integer> elementToPermute = new ArrayList<>(remainingElements);
            elementToPermute.remove(element);
            generatedElements.add(element);
            dfs(generatedElements, elementToPermute, result);
            generatedElements.remove(element);
        }
    }
   /* 
    k 가 고정되어있다면 대충 for loop 돌려도 됨
    public static void printPermutation(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = i + 1; j <= size; j++) {
                for (int l = j + 1; l <= size; l++) {
                    for (int m = l + 1; m <= size; m++) {
                        for (int n = m + 1; n <= size; n++)
                            System.out.println(i + " " + j + " " + l + " " + m + " " + n);
                    }
                }
            }
        }
    }
     */
}
