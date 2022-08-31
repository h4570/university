namespace RpnCalc.Parsers.BLL.Types
{
    internal class DecimalParser : IParser
    {
        public char InputCharacter => 'D';

        public string Execute(string input)
        {
            var fixedPart = input.Substring(1);
            return fixedPart;
        }
    }
}
