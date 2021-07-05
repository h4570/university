using System;
using System.Linq;
using System.Linq.Expressions;

namespace DotnetPlayground.ExpressionTrees
{

    public static class MinDateFilter
    {

        public static IQueryable<T> FilterByMinDate<T>(
            this IQueryable<T> items,
            Expression<Func<T, DateTime>> propSelector,
            DateTime from)
            where T : class
        {
            return items.Where(GetPredicate(propSelector, from));
        }

        private static Expression<Func<T, bool>> GetPredicate<T>(
            Expression<Func<T, DateTime>> propSelector,
            DateTime from)
            where T : class
        {
            from = from.Date.AddDays(-1);
            from = new DateTime(from.Year, from.Month, from.Day, 23, 59, 59, 999);

            var prop = Expression.Property(Expression.Constant(new { Value = from }), "Value");
            var memberExpression = (MemberExpression)propSelector.Body;
            var parameter = Expression.Parameter(typeof(T), "item");
            var exp = Expression.MakeMemberAccess(parameter, memberExpression.Member);
            var operation = Expression.GreaterThan(exp, prop);
            return Expression.Lambda<Func<T, bool>>(operation, parameter);
        }

    }
}
