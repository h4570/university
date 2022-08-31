using System.Collections.Generic;
using System.Linq;

namespace RpnCalc.Operations.BLL.Types
{
    internal class FactorialOperation : Operation
    {
        public override int ParametersCount => 1;
        public override char Operator => '!';

        protected override long CalculateInternal(IEnumerable<long> parameters)
        {
            var inputFactorial = parameters.ElementAt(0);

            var result = 1L;

            for (long i = 1; i <= inputFactorial; i++)
            {
                result *= i;
            }

            return result;
        }
    }
}

