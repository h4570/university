using DotnetPlayground.Models;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;

namespace DotnetPlayground.ExpressionTrees
{
    public static class ETPlayground
    {

        public static void Run(DbContextOptions<AppDbContext> options)
        {
            Simple(options);
            ManualNotStronglyTyped(options);
            ManualStronglyTyped(options);
            ExtensionMethod(options);
            CreateUrl(options);
            ShowCustomerFirstName(options);
        }

        private static void Simple(DbContextOptions<AppDbContext> options)
        {
            // Lambda
            Func<string, string> toUpper = str => str.ToUpper();

            // Expression "the recipe"
            Expression<Func<string, string>> toUpperExpEasy = str => str.ToUpper();
            using (var context = new AppDbContext(options))
            {
                var cus = context.Customers.First();
                Console.WriteLine($"First name (simple): {toUpper(cus.FirstName)}");
            }
        }

        private static void ManualNotStronglyTyped(DbContextOptions<AppDbContext> options)
        {
            var prm = Expression.Parameter(typeof(string), "str");
            var toUpperRecipe = typeof(string).GetMethod("ToUpper", Type.EmptyTypes);
            var body = Expression.Call(prm, toUpperRecipe);
            var lambda = Expression.Lambda(body, prm);
            var compiled = lambda.Compile();

            using (var context = new AppDbContext(options))
            {
                var cus = context.Customers.First();
                Console.WriteLine($"First name (manual, not strongly typed): {compiled.DynamicInvoke(cus.FirstName)}");
            }
        }

        private static void ManualStronglyTyped(DbContextOptions<AppDbContext> options)
        {
            var prm = Expression.Parameter(typeof(string), "str");
            var toUpperRecipe = typeof(string).GetMethod("ToUpper", Type.EmptyTypes);
            var body = Expression.Call(prm, toUpperRecipe);
            var lambda = Expression.Lambda<Func<string, string>>(body, prm);
            var compiled = lambda.Compile();

            using (var context = new AppDbContext(options))
            {
                var cus = context.Customers.First();
                Console.WriteLine($"First name (manual, strongly typed): {compiled.Invoke(cus.FirstName)}");
            }
        }

        private static void ExtensionMethod(DbContextOptions<AppDbContext> options)
        {
            var fromDate = DateTime.Now.AddDays(-10);

            using (var context = new AppDbContext(options))
            {
                var customFiltered = context.Customers.FilterByMinDate(c => c.EntryDate, fromDate).ToList();
                Console.WriteLine($"Customer count (extension method): {customFiltered.Count}");
                // debug on real db
                // Console.WriteLine($"SQL: {context.Customers.FilterByMinDate(c => c.EntryDate, fromDate).ToSql()}"); 
            }
        }

        // ---
        private static void CreateUrl(DbContextOptions<AppDbContext> options)
        {
            using (var context = new AppDbContext(options))
            {
                var customer = context.Customers.First();
                var fullUrl = CreateURLWithCustomerProperties("www.contoso.com", c => c.FirstName, c => c.LastName, c => c.EntryDate);
                Console.WriteLine($"URL: {fullUrl}");
            }
        }

        private static string CreateURLWithCustomerProperties(string url, params Expression<Func<Customer, object>>[] props)
        {
            var fields = new List<string>();
            foreach (var prop in props)
            {
                var body = prop.Body;
                // typ expression napisac na podstawie body.NodeType + "Expression"
                // czasami jest to niesetty mylące
                if (body is MemberExpression me) // string
                    fields.Add(me.Member.Name.ToLower());
                else if (body is UnaryExpression ue) // number
                    fields.Add(((MemberExpression)ue.Operand).Member.Name.ToLower());
            }
            var joined = string.Join(",", fields);
            return $"{url}?show={joined}";
        }
        // ---

        // ---
        private static void ShowCustomerFirstName(DbContextOptions<AppDbContext> options)
        {
            using (var context = new AppDbContext(options))
            {
                var customer = context.Customers.First();
                var variableName = "FirstName";
                var variableContent = GetPropertyValueByName(customer, variableName);
                Console.WriteLine($"Class[{variableName}]={variableContent}");
            }
        }
        private static string GetPropertyValueByName<T>(T obj, string name) where T : class
        {
            // lewa strona                                param
            var param = Expression.Parameter(typeof(T));// =>
            // prawa strona                            param.Name
            var accessor = Expression.PropertyOrField(param, name);
            var lambda = Expression.Lambda<Func<T, string>>(accessor, false, param);
            var compiled = lambda.Compile();
            return compiled.Invoke(obj);
        }
        // ---

    }
}
