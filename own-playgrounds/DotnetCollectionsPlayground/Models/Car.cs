using System;

namespace DotnetCollectionsPlayground.Models
{
    public class Car : IComparable<Car>
    {

        public Car(int id, string name, string vin, int year)
        {
            Id = id;
            Name = name;
            Vin = vin;
            Year = year;
        }

        public int Id { get; }
        public string Name { get; }
        public string Vin { get; }
        public int Year { get; }
        public string Owner { get; set; }

        public override bool Equals(object? obj)
        {
            return obj is Car other && other.Id == Id && other.Name == Name && other.Year == Year;
        }

        public override int GetHashCode()
        {
            unchecked
            {
                var hash = 17;
                hash *= 23 + Id.GetHashCode();
                hash *= 23 + Year.GetHashCode();
                hash = Name != null ? hash * 23 + Name.GetHashCode() : hash;
                hash = Vin != null ? hash * 23 + Vin.GetHashCode() : hash;
                return hash;
            }
        }

        /// <exception cref="T:System.ArgumentException"></exception>
        /// <exception cref="T:System.NotSupportedException"><see cref="T:System.StringComparison" /> is not supported.</exception>
        public int CompareTo(Car other)
        {
            if (ReferenceEquals(this, other)) return 0;
            if (ReferenceEquals(null, other)) return 1;
            var idComparison = Id.CompareTo(other.Id);
            if (idComparison != 0) return idComparison;
            var nameComparison = string.Compare(Name, other.Name, StringComparison.Ordinal);
            if (nameComparison != 0) return nameComparison;
            var vinComparison = string.Compare(Vin, other.Vin, StringComparison.Ordinal);
            if (vinComparison != 0) return vinComparison;
            var yearComparison = Year.CompareTo(other.Year);
            if (yearComparison != 0) return yearComparison;
            return string.Compare(Owner, other.Owner, StringComparison.Ordinal);
        }
    }
}
