using Autofac;
using RpnCalc.Operations.BLL;
using RpnCalc.Parsers.BLL.Enums;
using RpnCalc.Parsers.BLL;
using RpnCalc.Parsers.BLL.Types;

namespace RpnCalc.Parsers
{
    internal class ParsersModule : Module
    {
        protected override void Load(ContainerBuilder builder)
        {
            builder.RegisterType<InputParser>().AsSelf().InstancePerLifetimeScope();
            builder.RegisterType<ParserTypeMapper>().AsSelf().SingleInstance();

            LoadTypes(builder);
        }

        protected void LoadTypes(ContainerBuilder builder)
        {
            builder.RegisterType<BinaryParser>().Keyed<IParser>(ParserType.Binary).InstancePerLifetimeScope();
            builder.RegisterType<HexParser>().Keyed<IParser>(ParserType.Hexadecimal).InstancePerLifetimeScope();
            builder.RegisterType<DecimalParser>().Keyed<IParser>(ParserType.Decimal).InstancePerLifetimeScope();
        }
    }
}
