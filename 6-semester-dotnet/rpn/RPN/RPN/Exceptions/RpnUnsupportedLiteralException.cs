using System;

namespace RpnCalc.Exceptions
{
    [Serializable]
    public class RpnUnsupportedLiteralException : RpnException
    {
        public RpnUnsupportedLiteralException(string value) : base($"Unsupported literal found in input. Value: \"{value}\"") { }
    }
}
