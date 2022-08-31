using Autofac;
using RpnCalc.Operations;
using RpnCalc.Parsers;

namespace RpnCalc
{
    internal class AutofacManager
    {
        public static ILifetimeScope CreateScope()
        {
            var builder = new ContainerBuilder();

            builder.RegisterModule<OperationsModule>();
            builder.RegisterModule<ParsersModule>();

            var result = builder.Build();
            return result;
        }
    }
}
