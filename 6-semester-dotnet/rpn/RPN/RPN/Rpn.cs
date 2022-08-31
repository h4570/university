using Autofac;
using RpnCalc;
using RpnCalc.Operations;
using RpnCalc.Parsers;
using RpnCalc.Exceptions;

namespace RPNCalc
{
    public class Rpn
    {
        private readonly Stack<long> _stack = new Stack<long>();

        public long EvalRPN(string input)
        {
            using (var scope = AutofacManager.CreateScope())
            {
                var handler = scope.Resolve<OperationHandler>();
                var inputParser = scope.Resolve<InputParser>();

                var parts = inputParser.GetParts(input);

                foreach (var part in parts)
                {
                    var calculated = handler.Execute(part, _stack.Pop);
                    _stack.Push(calculated);
                }

                var result = _stack.Pop();

                if (!_stack.IsEmpty)
                {
                    throw new RpnStackNotEmptyException();
                }

                return result;
            }
        }
    }
}