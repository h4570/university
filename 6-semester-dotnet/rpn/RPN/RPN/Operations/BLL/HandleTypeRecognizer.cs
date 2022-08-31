using System;
using System.Linq;
using RpnCalc.Exceptions;
using RpnCalc.Operations.Enums;

namespace RpnCalc.Operations.BLL
{
    internal class HandleTypeRecognizer
    {
        private readonly OperationTypeMapper _mapper;

        public HandleTypeRecognizer(OperationTypeMapper mapper)
        {
            _mapper = mapper;
        }

        public HandleType Check(string input)
        {
            if (IsNumber(input))
            {
                return HandleType.Number;
            }
            else if (IsOperator(input))
            {
                return HandleType.Operator;
            }

            throw new RpnUnsupportedLiteralException(input);
        }

        private bool IsNumber(string input) => long.TryParse(input, out _);

        private bool IsOperator(string input) => input.Length == 1 && _mapper.Operators.Contains(input[0]);
    }
}
