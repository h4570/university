using System;
using System.Collections.Generic;
using DotnetCollectionsPlayground.Models;

namespace DotnetCollectionsPlayground
{
    public class Utils
    {

        /// <exception cref="T:System.IO.IOException">An I/O error occurred.</exception>
        public static void PrintCars(IEnumerable<Car> cars)
        {
            Console.WriteLine("Cars");
            foreach (var car in cars)
                Console.WriteLine($"Car: {car.Id}, {car.Name}, {car.Year}, {car.Vin}");
            Console.WriteLine("---");
        }

    }
}
