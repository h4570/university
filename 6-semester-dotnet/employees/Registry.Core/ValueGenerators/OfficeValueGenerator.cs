using Data.Models;

namespace Registry.Core.ValueGenerators
{
    internal class OfficeValueGenerator : EmployeeValueGenerator<Office>
    {
        protected override int GetValueInternal(Office employee)
            => employee.YearsOfExperience * employee.Iq;
    }
}
