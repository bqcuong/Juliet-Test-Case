/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__long_rand_postinc_52c.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-52c.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: rand Set data to result of rand()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: increment
 *    GoodSink: Ensure there will not be an overflow before incrementing data
 *    BadSink : Increment data, which can cause an overflow
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow.s06;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__long_rand_postinc_52c
{
    public void badSink(long data ) throws Throwable
    {

        /* POTENTIAL FLAW: if data == Long.MAX_VALUE, this will overflow */
        data++;
        long result = (long)(data);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(long data ) throws Throwable
    {

        /* POTENTIAL FLAW: if data == Long.MAX_VALUE, this will overflow */
        data++;
        long result = (long)(data);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(long data ) throws Throwable
    {

        /* FIX: Add a check to prevent an overflow from occurring */
        if (data < Long.MAX_VALUE)
        {
            data++;
            long result = (long)(data);
            IO.writeLine("result: " + result);
        }
        else
        {
            IO.writeLine("data value is too large to increment.");
        }

    }
}
