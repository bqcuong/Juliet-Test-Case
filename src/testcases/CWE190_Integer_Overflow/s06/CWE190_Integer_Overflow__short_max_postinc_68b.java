/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__short_max_postinc_68b.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-68b.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: max Set data to the max value for short
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: increment
 *    GoodSink: Ensure there will not be an overflow before incrementing data
 *    BadSink : Increment data, which can cause an overflow
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow.s06;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__short_max_postinc_68b
{
    public void badSink() throws Throwable
    {
        short data = CWE190_Integer_Overflow__short_max_postinc_68a.data;

        /* POTENTIAL FLAW: if data == Short.MAX_VALUE, this will overflow */
        data++;
        short result = (short)(data);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink() throws Throwable
    {
        short data = CWE190_Integer_Overflow__short_max_postinc_68a.data;

        /* POTENTIAL FLAW: if data == Short.MAX_VALUE, this will overflow */
        data++;
        short result = (short)(data);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink() throws Throwable
    {
        short data = CWE190_Integer_Overflow__short_max_postinc_68a.data;

        /* FIX: Add a check to prevent an overflow from occurring */
        if (data < Short.MAX_VALUE)
        {
            data++;
            short result = (short)(data);
            IO.writeLine("result: " + result);
        }
        else
        {
            IO.writeLine("data value is too large to increment.");
        }

    }
}
