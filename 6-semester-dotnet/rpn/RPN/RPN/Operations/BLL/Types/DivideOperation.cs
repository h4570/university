using System;
using System.Collections.Generic;
using System.Linq;

namespace RpnCalc.Operations.BLL.Types
{
    internal class DivideOperation : Operation
    {
        public override int ParametersCount => 2;
        public override char Operator => '/';

        protected override long CalculateInternal(IEnumerable<long> parameters)
        {
            var secondElement = parameters.ElementAt(1);

            if (secondElement == 0)
            {
                throw new DivideByZeroException($"Cant divide {parameters.ElementAt(0)} by {secondElement}");
            }

            return parameters.ElementAt(0) / secondElement;
        }
    }
}

