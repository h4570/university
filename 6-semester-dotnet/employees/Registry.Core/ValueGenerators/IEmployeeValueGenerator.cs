using Data.Models;

namespace Registry.Core.ValueGenerators
{
    internal interface IEmployeeValueGenerator
    {
        public int GetValue(Employee employee);
    }
}
