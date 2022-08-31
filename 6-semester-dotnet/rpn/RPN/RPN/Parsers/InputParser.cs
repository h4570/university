using Autofac.Features.Indexed;
using System.Collections.Generic;
using System.Linq;
using RpnCalc.Parsers.BLL.Enums;
using RpnCalc.Parsers.BLL;

namespace RpnCalc.Parsers
{
    internal class InputParser
    {
        private readonly IIndex<ParserType, IParser> _parsers;
        private readonly ParserTypeMapper _mapper;

        public InputParser(IIndex<ParserType, IParser> parsers, ParserTypeMapper mapper)
        {
            _parsers = parsers;
            _mapper = mapper;
        }

        public IEnumerable<string> GetParts(string input)
        {
            var dirtyParts = input.Split(' ');
            var result = new List<string>();

            foreach (var part in dirtyParts)
            {
                var firstCharUppercase = part.Trim().ToUpper()[0];

                if (_mapper.InputCharacters.Contains(firstCharUppercase))
                {
                    var parserType = _mapper.ToEnum(firstCharUppercase);
                    var parser = _parsers[parserType];
                    var converted = parser.Execute(part);
                    result.Add(converted.ToString());
                    continue;
                }

                result.Add(part);
            }

            return result;
        }
    }
}
