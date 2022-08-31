namespace Data.Models
{
    public abstract class Employee
    {
        public int Id { get; set; }
        public string FirstName { get; set; } = default!;
        public string LastName { get; set; } = default!;
        public int Age { get; set; } = default!;
        public int YearsOfExperience { get; set; } = default!;
        public EmployeeAddress Address { get; set; } = default!;
    }
}
