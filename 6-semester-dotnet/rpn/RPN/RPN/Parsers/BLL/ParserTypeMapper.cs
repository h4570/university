using Autofac.Features.Indexed;
using System;
using System.Collections.Generic;
using System.Linq;
using RpnCalc.Parsers.BLL.Enums;

namespace RpnCalc.Parsers.BLL
{
    internal class ParserTypeMapper
    {
        private readonly IReadOnlyDictionary<char, ParserType> _parsers;

        public ParserTypeMapper(IIndex<ParserType, IParser> operations)
        {
            var operationTypes = (ParserType[])Enum.GetValues(typeof(ParserType));
            var dictionary = new Dictionary<char, ParserType>(operationTypes.Length);

            foreach (var opType in operationTypes)
            {
                dictionary.Add(operations[opType].InputCharacter, opType);
            }

            _parsers = dictionary;
        }

        public IEnumerable<char> InputCharacters => _parsers.Keys;
        public ParserType ToEnum(char prefix) => _parsers[prefix];
        public char ToChar(ParserType type) => _parsers.Single(c => c.Value == type).Key;
    }
}
