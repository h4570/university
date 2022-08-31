using System;

namespace RpnCalc.Parsers.BLL.Types
{
    internal class HexParser : IParser
    {
        public char InputCharacter => '#';

        public string Execute(string input)
        {
            var fixedPart = input.Substring(1);
            var converted = Convert.ToInt32(fixedPart, 16);
            return converted.ToString();
        }
    }
}
