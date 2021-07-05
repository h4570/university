using DotnetPlayground.Models;
using Microsoft.EntityFrameworkCore;
using System;
using System.Linq;

namespace DotnetPlayground.EF
{
    public static class EFPlayground
    {

        public static void Run(DbContextOptions<AppDbContext> options)
        {
            LazyLoadingTest(options);
            LinqQueries(options);
        }

        private static void LazyLoadingTest(DbContextOptions<AppDbContext> options)
        {
            using (var context = new AppDbContext(options))
            {
                var cus = context.Customers.First();
                Console.WriteLine($"CustomerId: {cus.Id}");
                Console.WriteLine($"InvoiceDate: {cus.Invoices[0].Date}");
                DisplayState(context, cus);

                // dynamic test = new { Name = 1 };
                // DisplayState(context, test); // Exception
                var test2 = new Customer();
                DisplayState(context, test2); // Detached
            }
        }

        private static void LinqQueries(DbContextOptions<AppDbContext> options)
        {
            using (var context = new AppDbContext(options))
            {
                var x = from customer in context.Customers
                        where customer.FirstName == "Adam"
                        select new
                        {
                            customer.Id
                        };
                Console.WriteLine($"CustomerId: { x.FirstOrDefault().Id }");
            }
        }

        private static void DisplayStates(AppDbContext dbContext)
        {
            foreach (var entry in dbContext.ChangeTracker.Entries())
                Console.WriteLine($"Entity: { entry.Entity.GetType().Name }, State: { entry.State }");
        }

        private static void DisplayState(AppDbContext dbContext, object entity)
        {
            var dbEntity = dbContext.Entry(entity);
            Console.WriteLine($"Entity: { dbEntity.Entity.GetType().Name }, State: { dbEntity.State }");
        }

    }
}
