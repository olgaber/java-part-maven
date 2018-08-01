/*
package com.academy.lesson6;

import com.academy.lesson6.task.Currency;

public class CurrencyTests {
    public static void main(String[] args) {
        CurrencyTests test = new CurrencyTests();

        System.out.println("Constructor Test:");//done
        test.constructorTest();
        System.out.println();

        System.out.println("Copy Constructor Test: ");
        test.copyConstructorTest();
        System.out.println();

        System.out.println("Is Equal Test: "); //done
        test.isEqualTest();
        System.out.println();

        System.out.println("Add Test: ");//done
        test.addTest();
        System.out.println();

        System.out.println("Add Object Test: "); //done
        test.addTestObj();
        System.out.println();

        System.out.println("Subtract Test: "); //done
        test.subtractTest();
        System.out.println();

        System.out.println("Subtract Object Test: "); //done
        test.subtractTestObj();
        System.out.println();

        System.out.println("Divide Test: ");
        test.divideTest();
        System.out.println();

        System.out.println("Multiply Test: ");
        test.multiplyTest();
        System.out.println();
    }

    public void constructorTest() {//test data in array to improve!!
        //test data
        int[] values = {10, 0, -5};
        String[] names = {"руб", "&", "грн."};
        //test logic

        Currency cur = new Currency(10, "руб.");


        for (int i = 0; i < values.length; i++) {
            Currency cur2 = new Currency(values[i], names[i]);

            assert cur2.getValue() == values[i];
            assert cur2.getName() == names[i];

        }

        //assert cur.getValue() == 10;
       */
/* if (cur.getValue() == 10)
            System.out.println("Test 1 is successful");
        assert cur.getName().equals("руб.");
        if (cur.getName().equals("руб."))
            System.out.println("Test 2 is successful");*//*

    }

    public void copyConstructorTest(Currency cur) {

        Currency curCopy= new Currency(cur);

        assert cur.getName() == curCopy.getName();
        assert cur.getValue() == curCopy.getValue();



    }

    public void isEqualTest() {
        Currency cur1 = new Currency(10, "руб");
        Currency cur2 = new Currency(10, "руб");
        Currency cur3 = new Currency(11, "руб");

        assert cur1.isEqual(cur2);
        if (cur1.isEqual(cur2))
            System.out.println("Test 1 is successful");
        assert !cur1.isEqual(cur3);
        if (!cur1.isEqual(cur3))
            System.out.println("Test 2 is successful");
    }

    public void addTest(){
        Currency cur1 = new Currency(150, "грн.");
        cur1.add(30, "грн.");

        assert cur1.getName().equals("грн.");
        if (cur1.getName().equals("грн."))
            System.out.println("Test 1 is successful");
        assert !cur1.getName().equals("руб.");
        if (!cur1.getName().equals("руб."))
            System.out.println("Test 2 is successful");
     }

    public void addTestObj(){
        Currency cur1 = new Currency(10, "руб.");
        Currency cur2 = new Currency(30, "руб.");
        cur1.add(cur2);

        assert cur1.getName().equals("руб.");
        if (cur1.getName().equals("руб."))
            System.out.println("Test 1 is successful");
        assert !cur2.getName().equals("$");
        if (!cur2.getName().equals("$"))
            System.out.println("Test 2 is successful");
    }

    public void subtractTest(){
        Currency cur1 = new Currency(150, "грн.");
        cur1.add(30, "грн.");

        assert cur1.getName().equals("грн.");
        if (cur1.getName().equals("грн."))
            System.out.println("Test 1 is successful");
        assert !cur1.getName().equals("$");
        if (!cur1.getName().equals("$"))
            System.out.println("Test 2 is successful");
    }

    public void subtractTestObj(){
        Currency cur1 = new Currency(10, "руб.");
        Currency cur2 = new Currency(30, "руб.");
        cur1.add(cur2);

        assert cur1.getName().equals("руб.");
        if (cur1.getName().equals("руб."))
            System.out.println("Test 1 is successful");
        assert !cur2.getName().equals("грн.");
        if (!cur2.getName().equals("$"))
            System.out.println("Test 2 is successful");
    }

    public void divideTest(){
        Currency cur1 = new Currency(10, "руб.");

        assert cur1.getValue() == 10.0/5.78;

        cur1.divide(5.78);
        cur1.divide(0.00);

    }

    public void multiplyTest(){
        Currency cur1 = new Currency(10, "руб.");

        cur1.multiply(1.258);

    }
}*/

package com.academy.tests.lesson06;


import com.academy.lesson06.Currency;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CurrencyTests {

    @Test
    public void constructorTest() {
        // ******test data******
        // 1 Способ - используем сырой массив

//        int[] values = {10, 0, -3};
//        String[] names = {"руб", "грн", "$"};

        // 2 Способ - используем вспомогательный класс 'CurrencyTestData'
        CurrencyTestData[] positiveTestData = new CurrencyTestData[]{
                new CurrencyTestData(10, "руб"),
                new CurrencyTestData(0, "грн"),
                new CurrencyTestData(-3, "$")
        };

        CurrencyTestData[] negativeTestData = new CurrencyTestData[]{
                new CurrencyTestData(10, ""),
                new CurrencyTestData(0, "@"),
                new CurrencyTestData(-3, "euro")
        };

        // test logic
        for (int i = 0; i < positiveTestData.length; i++) {
//            Currency cur = new Currency(values[i], names[i]);
//            assert cur.getValue() == values[i];
//            assert cur.getName().equals(names[i]);

            String name = positiveTestData[i].getName();
            double value = positiveTestData[i].getValue();

            Currency cur = new Currency(value, name);
            Assert.assertEquals(cur.getValue(), value);
            Assert.assertEquals(cur.getName(), name);
            Assert.assertEquals((double) 1, 1.0);
            Assert.assertTrue(cur.isValid());
        }

        System.out.println("Check negative: ");
        for (int i = 0; i < negativeTestData.length; i++) {
//            Currency cur = new Currency(values[i], names[i]);
//            assert cur.getValue() == values[i];
//            assert cur.getName().equals(names[i]);

            String name = negativeTestData[i].getName();
            double value = negativeTestData[i].getValue();

            System.out.println("Name: " + name);
            System.out.println("Value: " + value);

            Currency cur = new Currency(value, name);
            assert !cur.isValid();

        }
    }

    public void copyConstructorTest() {
    }

    public void isEqualTest() {
        Currency cur1 = new Currency(10, "руб");
        Currency cur2 = new Currency(10, "руб");
        Currency cur3 = new Currency(11, "руб");

        assert cur1.isEqual(cur2);
        assert !cur1.isEqual(cur3);
    }

    public void testConstructorUsingObject() {
        // ******test data******
        // 1 Способ - используем сырой массив

//        int[] values = {10, 0, -3};
//        String[] names = {"руб", "грн", "$"};

        // 2 Способ - используем полиморфизм
//        Object[] arr1 = {10, "руб"};
//        Object[] arr2 = {0, "грн"};
//        Object[] arr3 = {-3, "$"};
//
//        Object[][] data_old = {
//                arr1,
//                arr2,
//                arr3
//        };

        Object[][] positiveTestData = {
                {10, "руб"},
                {0, "грн"},
                {-3, "$"}
//            new Object[] {-3, "$"},
        };

        Object[][] negativeTestData = {
                {10, "@"},
                {0, ""},
                {-3.0, "uah"}
//            new Object[] {-3, "$"},
        };

        // test logic
        for (int i = 0; i < positiveTestData.length; i++) {
//            Currency cur = new Currency(values[i], names[i]);
//            assert cur.getValue() == values[i];
//            assert cur.getName().equals(names[i]);

            String name = (String)positiveTestData[i][1];
            double value =  ((Number)positiveTestData[i][0]).doubleValue();

            Currency cur = new Currency(value, name);
            assert cur.getValue() == value;
            assert cur.getName().equals(name);
            assert cur.isValid();
        }

        for (int i = 0; i < negativeTestData.length; i++) {
//            Currency cur = new Currency(values[i], names[i]);
//            assert cur.getValue() == values[i];
//            assert cur.getName().equals(names[i]);

            String name = (String)negativeTestData[i][1];
            double value = ((Number)negativeTestData[i][0]).doubleValue();

            Currency cur = new Currency(value, name);
            assert !cur.isValid();

        }
    }
}
