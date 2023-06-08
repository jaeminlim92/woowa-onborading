package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Problem3 {

    private static List<Integer> integerList = Arrays.asList(3, 6, 9);

    public static int solution(int number) {
        int answer = 0;

        for (int index = 1; index <= number; index++) {

            answer += countIncludeArray(index);

        }

        return answer;
    }

    private static int countIncludeArray(int index) {
        int count = 0;
        int[] splitIndex = Stream.of(String.valueOf(index)
                .split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < splitIndex.length; i++) {
            if (integerList.contains(splitIndex[i])) {
                count++;
            }
        }

        return count;
    }
}
