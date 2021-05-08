using System;
using DotnetCollectionsPlayground.Lists;
using DotnetCollectionsPlayground.Models;

namespace DotnetCollectionsPlayground
{
    public class OwnListPlayground
    {

        /// <exception cref="T:System.IO.IOException">An I/O error occurred.</exception>
        public static void Run()
        {
            Console.WriteLine("Created \"UniqueCarList\" (hashset).");
            var cars = new UniqueCarList()
            {
                new Car(1, "Audi", "123", 2013),
                new Car(1, "Audi", "123", 2013),
                new Car(2, "Volkswagen", "234", 2011),
                new Car(3, "Audi", "345", 2013),
                new Car(4, "Audi", "456", 2010)
            };
            Console.WriteLine("Added 5 cars (1 duplicated).");
            Console.WriteLine("Result:");
            cars.Print(); // 2nd skipped
            Console.WriteLine("---");
            var car1 = new Car(1, "Audi", "123", 2013);
            var car2 = new Car(1, "Audi", "123", 2013);
            // ReSharper disable once PossibleUnintendedReferenceComparison
            Console.WriteLine($"car1 == car2 (same) => {car1 == car2}"); // False
            Console.WriteLine($"car1.GetHashCode() == car2.GetHashCode() => {car1.GetHashCode() == car2.GetHashCode()}"); // True
            Console.Write($"car1.Equals(car2) => {car1.Equals(car2)}"); // True
        }
    }

}
