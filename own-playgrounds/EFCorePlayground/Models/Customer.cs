using System;
using System.Collections.Generic;

namespace DotnetPlayground.Models
{
    public class Customer
    {
        public int Id { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string Address { get; set; }
        public DateTime EntryDate { get; set; }
        public virtual List<Invoice> Invoices { get; set; }
    }
}
