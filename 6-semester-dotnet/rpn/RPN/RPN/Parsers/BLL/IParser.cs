namespace RpnCalc.Parsers.BLL
{
    internal interface IParser
    {
        char InputCharacter { get; }
        string Execute(string input);
    }
}
