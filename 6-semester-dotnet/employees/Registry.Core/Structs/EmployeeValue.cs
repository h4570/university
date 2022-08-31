using Registry.Core.ValueGenerators;
using Data.Models;

namespace Registry.Core.Structs
{
    public struct EmployeeValue
    {
        public readonly Employee Employee;
        public readonly int Value;

        public EmployeeValue(Employee employee)
        {
            var generator = EmployeeValueGenerator<Employee>.GetByEmployee(employee);
            Employee = employee;
            Value = generator.GetValue(employee);
        }
    }
}
