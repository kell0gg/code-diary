package math;

public class GreatestCommonDivisor {

    public long gcd(long a, long b) {
        long min = Math.min(a, b);
        long result = 1;
        for (long i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                result = i;
            }
        }
        return result;
    }

    public long gcdWithEuclid(long a, long b) {
        /*
         * 1. 두 수중에 큰 수를 두 수 중에 작은 수로 나눈 나머지로 변경함
         * 2. 둘 중 하나가 0이 될 때까지 반복함
         * 3. 이렇게 변경해도 최대공약수는 변하지 않음
         * 4. 시간복잡도 O(log(A+B)) 인데 증명을 봐도 이해가 잘 안감
         */
        while (a >= 1 && b >= 1) {
            if (a < b) {
                b = b % a;
            } else {
                a = a % b;
            }
        }

        if (a >= 1) return a;
        else return b;
    }
}
