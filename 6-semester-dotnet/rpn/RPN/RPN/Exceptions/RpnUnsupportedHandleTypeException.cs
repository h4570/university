using System;

namespace RpnCalc.Exceptions
{
    [Serializable]
    public class RpnUnsupportedHandleTypeException : RpnException
    {
        public RpnUnsupportedHandleTypeException() : base("Unsupported handle type") { }
    }
}
