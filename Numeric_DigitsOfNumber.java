    public void test25()
    {
        int number = 1234567;

        while (number > 0)
        {
            int nexNumber = number % 10;

            System.out.println( nexNumber );

            number = number / 10;
        }
    }
