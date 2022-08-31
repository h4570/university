using System;

namespace RpnCalc.Exceptions
{
    [Serializable]
    public abstract class RpnException : Exception
    {
        public RpnException(string message) : base(message) { }
    }
}
