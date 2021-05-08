using System;
using System.Collections.Concurrent;
using System.Threading.Tasks;
using DotnetCollectionsPlayground.Models;

namespace DotnetCollectionsPlayground
{
    public class ConcurrentBagPlayground
    {
        /// <exception cref="T:System.IO.IOException">An I/O error occurred.</exception>
        /// <exception cref="T:System.ArgumentNullException">The <paramref name="tasks" /> argument was <see langword="null" />.</exception>
        /// <exception cref="T:System.ArgumentException">The <paramref name="tasks" /> array contained a <see langword="null" /> task.</exception>
        public static async Task Run()
        {
            Console.WriteLine("Created \"ConcurrentBag\".");
            var cars = new ConcurrentBag<Car>();

            var task1 = Task.Run(() =>
            {
                cars.Add(new Car(1, "Audi", "123", 2013));
                cars.Add(new Car(2, "Volkswagen", "234", 2011));
            });

            var task2 = Task.Run(() =>
            {
                cars.Add(new Car(3, "Audi", "345", 2013));
                cars.Add(new Car(4, "Audi", "456", 2010));
            });

            await Task.WhenAll(task1, task2);
            Utils.PrintCars(cars);
        }

    }

}
