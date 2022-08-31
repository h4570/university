using System;

namespace RpnCalc.Exceptions
{
    [Serializable]
    public class RpnWrongParametersCountException : RpnException
    {
        public RpnWrongParametersCountException() : base("Wrong parameters count") { }
    }
}
