using System;
using System.Collections.Generic;
using DotnetCollectionsPlayground.Models;

namespace DotnetCollectionsPlayground
{
    public class StackPlayground
    {

        /// <exception cref="T:System.IO.IOException">An I/O error occurred.</exception>
        /// <exception cref="T:System.InvalidOperationException">The <see cref="T:System.Collections.Generic.Stack`1" /> is empty.</exception>
        public static void Run()
        {
            Console.WriteLine("Created \"Stack\".");

            var cars = new Stack<Car>();

            Console.WriteLine("Push car 1.");
            cars.Push(new Car(1, "Audi", "123", 2013));
            Utils.PrintCars(cars);

            Console.WriteLine("Push car 2");
            cars.Push(new Car(2, "Volkswagen", "234", 2011));
            Utils.PrintCars(cars);

            Console.WriteLine("Pop car 2");
            cars.Pop();
            Utils.PrintCars(cars);

            Console.WriteLine("Push car 3");
            cars.Push(new Car(3, "BMW", "456", 2011));
            Utils.PrintCars(cars);
        }

    }

}
