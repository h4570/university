using System.ComponentModel.DataAnnotations.Schema;

namespace DotnetPlayground.Models
{
    public class InvoiceItem
    {
        public int Id { get; set; }
        public string Code { get; set; }
        public int InvoiceId { get; set; }

        [ForeignKey("InvoiceId")]
        public virtual Invoice Invoice { get; set; }
    }
}
