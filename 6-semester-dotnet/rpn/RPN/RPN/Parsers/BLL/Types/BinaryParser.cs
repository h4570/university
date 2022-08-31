using System;

namespace RpnCalc.Parsers.BLL.Types
{
    internal class BinaryParser : IParser
    {
        public char InputCharacter => 'B';

        public string Execute(string input)
        {
            var fixedPart = input.Substring(1);
            var converted = Convert.ToInt32(fixedPart, 2);
            return converted.ToString();
        }
    }
}
