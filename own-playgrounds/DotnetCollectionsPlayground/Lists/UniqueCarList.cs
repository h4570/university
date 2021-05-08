using System;
using System.Collections;
using System.Collections.Generic;
using DotnetCollectionsPlayground.Models;

namespace DotnetCollectionsPlayground.Lists
{
    class UniqueCarList : IList<Car>
    {

        private readonly HashSet<Car> _cars;

        public UniqueCarList()
        {
            _cars = new HashSet<Car>();
        }

        /// <exception cref="T:System.IO.IOException">An I/O error occurred.</exception>
        public void Print()
        {
            foreach (var car in _cars)
            {
                Console.WriteLine($"Car: {car.Id}, {car.Name}, {car.Year}, {car.Vin}");
            }
        }

        public IEnumerator GetEnumerator() { return _cars.GetEnumerator(); }

        IEnumerator<Car> IEnumerable<Car>.GetEnumerator() { return _cars.GetEnumerator(); }

        public void Add(Car item)
        {
            _cars.Add(item);
        }

        public void Clear()
        {
            throw new NotImplementedException();
        }

        public bool Contains(Car item)
        {
            throw new NotImplementedException();
        }

        public void CopyTo(Car[] array, int arrayIndex)
        {
            throw new NotImplementedException();
        }

        public bool Remove(Car item)
        {
            throw new NotImplementedException();
        }

        public int Count => _cars.Count;
        public bool IsReadOnly { get; }
        public int IndexOf(Car item)
        {
            throw new NotImplementedException();
        }

        public void Insert(int index, Car item)
        {
            throw new NotImplementedException();
        }

        public void RemoveAt(int index)
        {
            throw new NotImplementedException();
        }

        public Car this[int index]
        {
            get => throw new NotImplementedException();
            set => throw new NotImplementedException();
        }

    }
}
