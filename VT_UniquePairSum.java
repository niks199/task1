    public void test26()
    {
        int[] numArray = {1, 2, 3, 4, 5, 6};

        int k = 8;

        HashSet numSet = new HashSet();

        for (int i = 0; i < numArray.length; ++i)
        {
            for (int j = 0; j < numArray.length; ++j)
            {
                if ( i != j && numArray[ i ] + numArray[ j ] == k)
                {
                    if (!numSet.contains( numArray[ j ] ))
                    {
                        numSet.add( numArray[ i ] );

                        System.out.println( numArray[ i ] + " " + numArray[ j ] );
                    }
                }
            }
        }
    }
