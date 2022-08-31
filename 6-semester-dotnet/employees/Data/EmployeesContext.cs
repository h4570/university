using Data.Models;
using System.Collections;

namespace Data;
public class EmployeesContext : ICollection<Employee>
{
    private readonly Dictionary<int, Employee> _dataSet = new();
    private int LatestId = 1;

    public int Count => _dataSet.Count;
    public bool IsReadOnly => false;

    public void Add(Employee employee)
    {
        var newId = LatestId++;
        employee.Id = newId;
        _dataSet.Add(newId, employee);
    }

    public IEnumerable<Employee> AddRange(IEnumerable<Employee> employee)
    {
        foreach (var emp in employee)
            Add(emp);

        return employee;
    }

    public void Clear()
    {
        _dataSet.Clear();
        LatestId = 1;
    }

    public bool Remove(Employee item)
    {
        var result = _dataSet.ContainsKey(item.Id);

        if (result)
        {
            _dataSet.Remove(item.Id);
        }

        return result;
    }

    public TClass? RemoveBy<TClass>(Func<TClass, bool> func)
        where TClass : Employee
    {
        var toRemove = this.OfType<TClass>().SingleOrDefault(func);

        if (toRemove != null)
            Remove(toRemove);

        return toRemove;
    }

    public bool Contains(Employee item) => _dataSet.TryGetValue(item.Id, out var _);
    public IEnumerator<Employee> GetEnumerator() => _dataSet.Values.GetEnumerator();
    IEnumerator IEnumerable.GetEnumerator() => _dataSet.Values.GetEnumerator();
    public void CopyTo(Employee[] array, int arrayIndex)
    {
        for (var i = arrayIndex; i < array.Length; i++)
            array[i] = _dataSet.Values.ElementAt(i);
    }
}
