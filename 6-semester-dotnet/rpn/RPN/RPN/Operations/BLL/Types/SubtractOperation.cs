using System.Collections.Generic;
using System.Linq;

namespace RpnCalc.Operations.BLL.Types
{
    internal class SubtractOperation : Operation
    {
        public override int ParametersCount => 2;
        public override char Operator => '-';

        protected override long CalculateInternal(IEnumerable<long> parameters)
        {
            return parameters.ElementAt(0) - parameters.ElementAt(1);
        }
    }
}

