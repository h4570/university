using Autofac;
using RpnCalc.Operations.BLL;
using RpnCalc.Operations.BLL.Types;
using RpnCalc.Operations.Enums;

namespace RpnCalc.Operations
{
    internal class OperationsModule : Module
    {
        protected override void Load(ContainerBuilder builder)
        {
            builder.RegisterType<OperationHandler>().AsSelf().InstancePerLifetimeScope();
            builder.RegisterType<HandleTypeRecognizer>().AsSelf().InstancePerLifetimeScope();
            builder.RegisterType<OperationTypeMapper>().AsSelf().SingleInstance();

            LoadTypes(builder);
        }

        protected void LoadTypes(ContainerBuilder builder)
        {
            builder.RegisterType<AddOperation>().Keyed<Operation>(OperationType.Add).InstancePerLifetimeScope();
            builder.RegisterType<DivideOperation>().Keyed<Operation>(OperationType.Divide).InstancePerLifetimeScope();
            builder.RegisterType<FactorialOperation>().Keyed<Operation>(OperationType.Factorial).InstancePerLifetimeScope();
            builder.RegisterType<MultiplyOperation>().Keyed<Operation>(OperationType.Multiply).InstancePerLifetimeScope();
            builder.RegisterType<SubtractOperation>().Keyed<Operation>(OperationType.Subtract).InstancePerLifetimeScope();
        }
    }
}
