using System;

namespace RpnCalc.Exceptions
{
    [Serializable]
    public class RpnStackNotEmptyException : RpnException
    {
        public RpnStackNotEmptyException() : base("Stack is not empty. Internal RPN error") { }
    }
}
