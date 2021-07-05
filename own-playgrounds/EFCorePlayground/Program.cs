using DotnetPlayground.EF;
using DotnetPlayground.ExpressionTrees;
using DotnetPlayground.Models;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;

namespace DotnetPlayground
{
    class Program
    {
        static void Main(string[] args)
        {
            var options = new DbContextOptionsBuilder<AppDbContext>()
                .UseInMemoryDatabase(databaseName: "Test")
                .UseLazyLoadingProxies()
                .Options;
            FeedDatabase(options);

            //EFPlayground.Run(options);
            //Console.WriteLine("---");

            ETPlayground.Run(options);
            Console.WriteLine("---");
        }

        private static int FeedDatabase(DbContextOptions<AppDbContext> options)
        {
            using (var context = new AppDbContext(options))
            {
                var invoice1 = new Invoice { Date = DateTime.Now };
                var invoice2 = new Invoice { Date = DateTime.Now.AddDays(-30) };
                var customer1 = new Customer
                {
                    FirstName = "Adam",
                    LastName = "Kowalski",
                    EntryDate = DateTime.Now,
                    Address = "Grunwaldzka 1",
                    Invoices = new List<Invoice> { invoice1 }
                };
                var customer2 = new Customer
                {
                    FirstName = "Jan",
                    LastName = "Szymański",
                    EntryDate = DateTime.Now.AddDays(-30),
                    Address = "Grunwaldzka 2",
                    Invoices = new List<Invoice> { invoice2 }
                };
                var customers = new List<Customer>()
                {
                    customer1,
                    customer2
                };
                context.Customers.AddRange(customers);
                context.SaveChanges();
                return customer1.Id;
            }
        }

    }
}
