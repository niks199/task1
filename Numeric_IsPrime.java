    public boolean isPrime(int num)
    {
        if (num <= 1)
        {
            return false;
        }

        for (int i = 2; i < num; ++i)
        {
            if (num % i == 0)
            {
                return false;
            }
        }

        return true;
    }

    public void test27()
    {
        int num = 110;

        boolean result = isPrime(num);

        System.out.println( num + " " + result );
    }
