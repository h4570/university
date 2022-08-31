namespace Data.Models
{
    public class EmployeeAddress
    {
        public string Street { get; set; } = default!;
        public string BuildingNumber { get; set; } = default!;
        public string? FlatNumber { get; set; }
        public string City { get; set; } = default!;
    }
}
