package math;

public class PrimeNumber {
    /*
     * 0. 1보다 큰 자연수 중에서 정확히 두 개의 양의 약수(1과 자기 자신)를 가지는 수가 소수
     * 1. N 이 합성수면 2 이상, N 이하의 약수가 존재해야함
     * 2. 이를 성립하지 않는다고 가정하면 N 이 합성수일 때, 약수는 √n 을 넘어야 함
     * 3. A * B = N 이라고 할 때, B = N / A, A = N / B 이고 이는 둘 다 N 보다 작음
     * 4. 가정이 성립하지 않으므로 N 이 합성수면 N 이하의 약수가 존재함
     * 5. 때문에 √n 이하의 정수로 나누어진다면 합성수로 볼 수 있고, 존재하지 않으면 소수로 볼 수 있음
     */
    public boolean isPrime(int n) {
        if (n <= 0) throw new IllegalArgumentException("n 은 1보다 크거나 같아야함");

        // 1은 소수가 아님
        if (n == 1) return false;

        double sqrtN = Math.sqrt(n);
        for (int i = 2; i <= sqrtN; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
