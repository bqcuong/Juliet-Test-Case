/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__byte_rand_predec_73b.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-73b.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: rand Set data to result of rand()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: decrement
 *    GoodSink: Ensure there will not be an underflow before decrementing data
 *    BadSink : Decrement data, which can cause an Underflow
 * Flow Variant: 73 Data flow: data passed in a LinkedList from one method to another in different source files in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow.s05;
import testcasesupport.*;
import java.util.LinkedList;

public class CWE191_Integer_Underflow__byte_rand_predec_73b
{
    public void badSink(LinkedList<Byte> dataLinkedList ) throws Throwable
    {
        byte data = dataLinkedList.remove(2);

        /* POTENTIAL FLAW: if data == Byte.MIN_VALUE, this will overflow */
        byte result = (byte)(--data);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2BSink(LinkedList<Byte> dataLinkedList ) throws Throwable
    {
        byte data = dataLinkedList.remove(2);

        /* POTENTIAL FLAW: if data == Byte.MIN_VALUE, this will overflow */
        byte result = (byte)(--data);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2GSink(LinkedList<Byte> dataLinkedList ) throws Throwable
    {
        byte data = dataLinkedList.remove(2);

        /* FIX: Add a check to prevent an underflow from occurring */
        if (data > Byte.MIN_VALUE)
        {
            byte result = (byte)(--data);
            IO.writeLine("result: " + result);
        }
        else
        {
            IO.writeLine("data value is too small to decrement.");
        }

    }
}
