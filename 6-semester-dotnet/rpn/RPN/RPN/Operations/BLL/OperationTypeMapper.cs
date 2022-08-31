using Autofac.Features.Indexed;
using System;
using System.Collections.Generic;
using System.Linq;
using RpnCalc.Operations.Enums;

namespace RpnCalc.Operations.BLL
{
    internal class OperationTypeMapper
    {
        private readonly IReadOnlyDictionary<char, OperationType> _operations;

        public OperationTypeMapper(IIndex<OperationType, Operation> operations)
        {
            var operationTypes = (OperationType[])Enum.GetValues(typeof(OperationType));
            var dictionary = new Dictionary<char, OperationType>(operationTypes.Length);

            foreach (var opType in operationTypes)
            {
                dictionary.Add(operations[opType].Operator, opType);
            }

            _operations = dictionary;
        }

        public IEnumerable<char> Operators => _operations.Keys;
        public OperationType ToEnum(char prefix) => _operations[prefix];
        public char ToChar(OperationType type) => _operations.Single(c => c.Value == type).Key;
    }
}
