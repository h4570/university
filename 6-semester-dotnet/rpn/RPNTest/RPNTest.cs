using NUnit.Framework;
using System;
using RPNCalc;
using RpnCalc.Exceptions;

namespace RPNTest
{
    [TestFixture]
    public class RPNTest
    {
        private Rpn _sut;

        [SetUp]
        public void Setup()
        {
            _sut = new Rpn();
        }

        [Test]
        public void CheckIfTestWorks()
        {
            Assert.Pass();
        }

        [Test]
        public void CheckIfCanCreateSut()
        {
            Assert.That(_sut, Is.Not.Null);
        }

        [Test]
        public void SingleDigitOneInputOneReturn()
        {
            var result = _sut.EvalRPN("1");

            Assert.That(result, Is.EqualTo(1));

        }

        [Test]
        public void SingleDigitOtherThenOneInputNumberReturn()
        {
            var result = _sut.EvalRPN("2");

            Assert.That(result, Is.EqualTo(2));

        }

        [Test]
        public void TwoDigitsNumberInputNumberReturn()
        {
            var result = _sut.EvalRPN("12");

            Assert.That(result, Is.EqualTo(12));

        }

        [Test]
        public void TwoNumbersGivenWithoutOperator_ThrowsExcepton()
        {
            Assert.Throws<RpnStackNotEmptyException>(() => _sut.EvalRPN("1 2"));
        }

        [Test]
        public void OperatorPlus_AddingTwoNumbers_ReturnCorrectResult()
        {
            var result = _sut.EvalRPN("1 2 +");

            Assert.That(result, Is.EqualTo(3));
        }

        [Test]
        public void OperatorTimes_AddingTwoNumbers_ReturnCorrectResult()
        {
            var result = _sut.EvalRPN("2 2 *");

            Assert.That(result, Is.EqualTo(4));
        }

        [Test]
        public void OperatorTimes_DividingBy0_ShouldThrowException()
        {
            Assert.Throws<DivideByZeroException>(() => _sut.EvalRPN("0 2 /"));
        }

        [Test]
        public void OperatorMinus_SubstractingTwoNumbers_ReturnCorrectResult()
        {
            var result = _sut.EvalRPN("1 2 -");

            Assert.That(result, Is.EqualTo(1));
        }

        [Test]
        public void ComplexExpression()
        {
            var result = _sut.EvalRPN("15 7 1 1 + - / 3 * 2 1 1 + + -");

            Assert.That(result, Is.EqualTo(4));
        }

        // ---

        [Test]
        public void ComplexExpressionWithPrefixes_ReturnCorrectResult()
        {
            var result = _sut.EvalRPN("#F B111 1 1 + - / #3 * B10 1 1 + + -");

            Assert.That(result, Is.EqualTo(4));
        }

        [Test]
        public void FactorialOf9_ReturnCorrectResult()
        {
            var result = _sut.EvalRPN("9 !");

            Assert.That(result, Is.EqualTo(362880));
        }

        [Test]
        public void FactorialOf14_ReturnCorrectResult()
        {
            var result = _sut.EvalRPN("14 !");

            Assert.That(result, Is.EqualTo(87178291200));
        }

        [Test]
        public void InvalidOperator_ShouldThrowException()
        {
            Assert.Throws<RpnUnsupportedLiteralException>(() => _sut.EvalRPN("0 2 $"));
        }

        [Test]
        public void InvalidOperator2_ShouldThrowException()
        {
            Assert.Throws<RpnUnsupportedLiteralException>(() => _sut.EvalRPN("1 2 - lololo"));
        }
    }
}