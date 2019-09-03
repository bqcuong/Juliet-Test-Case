/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__byte_console_readLine_postdec_51b.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-51b.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: decrement
 *    GoodSink: Ensure there will not be an underflow before decrementing data
 *    BadSink : Decrement data, which can cause an Underflow
 * Flow Variant: 51 Data flow: data passed as an argument from one function to another in different classes in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow.s04;
import testcasesupport.*;

public class CWE191_Integer_Underflow__byte_console_readLine_postdec_51b
{
    public void badSink(byte data ) throws Throwable
    {

        /* POTENTIAL FLAW: if data == Byte.MIN_VALUE, this will overflow */
        data--;
        byte result = (byte)(data);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(byte data ) throws Throwable
    {

        /* POTENTIAL FLAW: if data == Byte.MIN_VALUE, this will overflow */
        data--;
        byte result = (byte)(data);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(byte data ) throws Throwable
    {

        /* FIX: Add a check to prevent an underflow from occurring */
        if (data > Byte.MIN_VALUE)
        {
            data--;
            byte result = (byte)(data);
            IO.writeLine("result: " + result);
        }
        else
        {
            IO.writeLine("data value is too small to decrement.");
        }

    }
}
