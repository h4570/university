using System;

namespace DotnetCollectionsPlayground
{
    class Program
    {

        static void Main(string[] args)
        {
            OwnListPlayground.Run();
            Console.Write("\n\n=================================\n\n");

            SortedListPlayground.Run();
            Console.Write("\n\n=================================\n\n");

            ConcurrentBagPlayground.Run().GetAwaiter().GetResult();
            Console.Write("\n\n=================================\n\n");

            StackPlayground.Run();
            Console.Write("\n\n=================================\n\n");
        }

    }
}
