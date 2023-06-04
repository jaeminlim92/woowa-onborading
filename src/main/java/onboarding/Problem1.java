package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (validPage(pobi) || validPage(crong)) {
            return -1;
        }

        int pobiNumber = getMaxNumber(pobi);
        System.out.println("pobiNumber = " + pobiNumber);
        int crongNumber = getMaxNumber(crong);
        System.out.println("crongNumber = " + crongNumber);

        return  decideWinner(pobiNumber, crongNumber);
    }

    private static boolean validPage(List<Integer> integerList) {

        int leftPage = integerList.get(0);
        int rightPage = integerList.get(1);

        return !isNotFirstPage(leftPage) || !isNotLastPage(rightPage) || !isCorrectPages(leftPage,
            rightPage);
    }

    private static boolean isCorrectPages(int leftPage, int rightPage) {
        return leftPage+1 == rightPage;

    }

    private static boolean isNotLastPage(int rightPage) {
        return rightPage <= 400;
    }

    private static boolean isNotFirstPage(int leftPage) {
        return leftPage > 1;
    }

    public static int getMaxNumber(List<Integer> arrayList) {
        int result = 0;
        int resultByAdd = 0;
        int resultByProduct = 0;

        for (Integer pageNumber : arrayList) {

            resultByAdd = Stream.of(String.valueOf(pageNumber).split(""))
                .mapToInt(Integer::parseInt).reduce(0, Integer::sum);

            resultByProduct = Stream.of(String.valueOf(pageNumber).split(""))
                .mapToInt(Integer::parseInt).reduce(1, (a, b) -> a * b);

        }

        return Integer.max(resultByAdd, resultByProduct);
    }

    public static int decideWinner(final int pobiNumber, final int crongNumber) {

        if (crongNumber == pobiNumber) {
            return 0;
        }

        if (pobiNumber > crongNumber) {
            return 1;
        } else if (pobiNumber < crongNumber) {
            return 2;
        } else  {
            return -1;
        }

    }
}