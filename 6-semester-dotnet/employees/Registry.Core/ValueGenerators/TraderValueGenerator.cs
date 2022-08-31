using Data.Models;

namespace Registry.Core.ValueGenerators
{
    internal class TraderValueGenerator : EmployeeValueGenerator<Trader>
    {
        protected override int GetValueInternal(Trader employee)
            => employee.YearsOfExperience * (int)employee.Efectiveness;
    }
}
