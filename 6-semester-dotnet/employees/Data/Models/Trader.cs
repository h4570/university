using Data.Enums;

namespace Data.Models
{
    public class Trader : Employee
    {
        public int Commission { get; set; }
        public EfectivenessType Efectiveness { get; set; }
    }
}
