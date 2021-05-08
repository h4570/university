using DotnetCollectionsPlayground.Models;
using System;
using System.Collections.Generic;
using System.Linq;

namespace DotnetCollectionsPlayground
{
    public class SortedListPlayground
    {

        /// <exception cref="T:System.IO.IOException">An I/O error occurred.</exception>
        public static void Run()
        {
            Console.WriteLine("Created \"SortedList\".");

            // List of car and insurance provider (string)
            var cars = new SortedList<Car, string>
            {
                { new Car(1, "Audi", "123", 2013), "Axa"},
                { new Car(2, "Volkswagen", "234", 2011), "Link4"},
                { new Car(3, "Audi", "345", 2013), "Axa"},
                { new Car(4, "Audi", "456", 2010), "Link4"}
            };

            try
            {
                var duplicate = new Car(1, "Audi", "123", 2013);
                cars.Add(duplicate, "Eks");
            }
            catch (ArgumentException)
            {
                Console.WriteLine("Cant add duplicate to SortedList");
            }

            Utils.PrintCars(cars.Select(c => c.Key));

        }
    }

}
