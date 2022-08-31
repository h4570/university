using Data.Models;

namespace Registry.Core.ValueGenerators
{
    internal class PhysicalValueGenerator : EmployeeValueGenerator<Physical>
    {
        protected override int GetValueInternal(Physical employee)
            => employee.YearsOfExperience * (employee.Strength / employee.Age);
    }
}
