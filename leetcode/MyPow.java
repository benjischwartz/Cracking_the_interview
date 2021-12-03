class MyPow {
    public static double myPow(double x, int n) {
        if (n == -1) {
            return 1/x;
        }
        else if (n == 1) {
            return x;
        }
        else if (n == 0)  {
            return 1;
        }
        else if (n > 1) {
            if (n % 2 == 0) {
                return myPow(x, n/2)*myPow(x, n/2);
            }
            return x*myPow(x, (n-1));
        } 
        else {
            if (((-n) % 2) == 0) {
                return myPow(x, n/2)*myPow(x, n/2);
            }
            return (1/x)*(myPow(x, (n+1)));
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow(25, 3));
        System.out.println(myPow(2, 3));
        System.out.println(myPow(2, -3));
        System.out.println(myPow(1000, 100));
    }
}
