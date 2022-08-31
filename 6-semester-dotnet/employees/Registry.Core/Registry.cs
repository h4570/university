using Registry.Core.Structs;
using Data;
using Data.Models;

namespace Registry.Core;

public class Registry
{
    private readonly EmployeesContext _context;

    public Registry()
    {
        _context = new EmployeesContext();
    }

    public void Add(Employee employee)
        => _context.Add(employee);

    public IEnumerable<Employee> AddRange(IEnumerable<Employee> employee)
        => _context.AddRange(employee);

    public Office? RemoveOfficeByBadge(int badgeNumber)
        => _context.RemoveBy<Office>(c => c.BadgeNumber == badgeNumber);

    public IEnumerable<Employee> GetByCity(string city)
        => _context.Where(c => c.Address.City == city);

    public IEnumerable<Employee> GetAllSorted()
        => _context.OrderByDescending(c => c.YearsOfExperience).ThenBy(c => c.Age).ThenBy(c => c.LastName);

    public IEnumerable<EmployeeValue> GetValued()
        => _context.Select(c => new EmployeeValue(c));
}
