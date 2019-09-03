/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__long_console_readLine_predec_81_goodG2B.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-81_goodG2B.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: decrement
 *    GoodSink: Ensure there will not be an underflow before decrementing data
 *    BadSink : Decrement data, which can cause an Underflow
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE191_Integer_Underflow.s05;
import testcasesupport.*;

public class CWE191_Integer_Underflow__long_console_readLine_predec_81_goodG2B extends CWE191_Integer_Underflow__long_console_readLine_predec_81_base
{
    public void action(long data ) throws Throwable
    {

        /* POTENTIAL FLAW: if data == Long.MIN_VALUE, this will overflow */
        long result = (long)(--data);

        IO.writeLine("result: " + result);

    }
}
