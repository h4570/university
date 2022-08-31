using RpnCalc.Exceptions;
using System.Collections.Generic;
using System.Linq;

namespace RpnCalc.Operations.BLL
{
    internal abstract class Operation
    {
        public abstract int ParametersCount { get; }
        public abstract char Operator { get; }

        public long Calculate(IEnumerable<long> parameters)
        {
            if (parameters.Count() != ParametersCount)
            {
                throw new RpnWrongParametersCountException();
            }

            return CalculateInternal(parameters);
        }

        protected abstract long CalculateInternal(IEnumerable<long> parameters);
    }
}
