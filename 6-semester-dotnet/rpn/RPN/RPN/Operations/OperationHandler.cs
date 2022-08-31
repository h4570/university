using Autofac.Features.Indexed;
using System.Collections.Generic;
using RpnCalc.Operations.BLL;
using RpnCalc.Operations.Enums;
using RpnCalc.Exceptions;

namespace RpnCalc.Operations
{
    internal class OperationHandler
    {
        public delegate long PopDelegate();

        private readonly IIndex<OperationType, Operation> _operations;
        private readonly OperationTypeMapper _mapper;
        private readonly HandleTypeRecognizer _handleTypeRecognizer;

        public OperationHandler(
            IIndex<OperationType, Operation> operations,
            OperationTypeMapper mapper,
            HandleTypeRecognizer operationResultRecognizer)
        {
            _operations = operations;
            _mapper = mapper;
            _handleTypeRecognizer = operationResultRecognizer;
        }

        public long Execute(string part, PopDelegate pop)
        {
            var handleType = _handleTypeRecognizer.Check(part);

            switch (handleType)
            {
                case HandleType.Number:
                    return long.Parse(part);
                case HandleType.Operator:
                    var operationType = _mapper.ToEnum(part[0]);
                    var operation = _operations[operationType];
                    var inputList = GetInputParameters(operation, pop);
                    return operation.Calculate(inputList);
            }

            throw new RpnUnsupportedHandleTypeException();
        }

        private IEnumerable<long> GetInputParameters(Operation operation, PopDelegate pop)
        {
            var result = new List<long>(operation.ParametersCount);

            for (long i = 0; i < operation.ParametersCount; i++)
            {
                var popped = pop();
                result.Add(popped);
            }

            return result;
        }
    }
}
