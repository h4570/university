using Data.Models;

namespace Registry.Core.ValueGenerators
{
    internal abstract class EmployeeValueGenerator<T> : IEmployeeValueGenerator where T : Employee
    {
        public static IEmployeeValueGenerator GetByEmployee(Employee employee)
            => employee switch
            {
                Office => new OfficeValueGenerator(),
                Physical => new PhysicalValueGenerator(),
                Trader => new TraderValueGenerator(),
                _ => throw new NotSupportedException("Provided employee is not suported"),
            };

        public int GetValue(Employee employee)
            => GetValueInternal((T)employee);

        protected abstract int GetValueInternal(T employee);
    }
}
