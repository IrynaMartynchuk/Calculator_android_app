package com.example.calculator_app;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UnitTests extends MainActivity{

    @Test
    public void single_addition() {
        assertEquals("4.5", calculate("2.5+2"));
    }

    @Test
    public void single_subtraction() {
        assertEquals("3", calculate("5-2"));
    }

    @Test
    public void single_division() {
        assertEquals("4", calculate("8/2"));
    }

    @Test
    public void single_multiplication() {
        assertEquals("12", calculate("6×2"));
    }

    @Test
    public void addition_and_subtraction() {
        assertEquals("7", calculate("6+2-1"));
    }

    @Test
    public void multiplication_and_division() {
        assertEquals("40", calculate("8×10/2"));
    }

    @Test
    public void division_and_multiplication() {
        assertEquals("300", calculate("60/2×10"));
    }

    @Test
    public void division_addition_subtraction_and_multiplication() {
        assertEquals("144", calculate("1000/20+600/60×10-6"));
    }

    @Test
    public void contains_operator_in_the_end() {
        assertEquals("300", calculate("60/2×10/"));
    }

    @Test
    public void one_number() {
        assertEquals("60", calculate("60"));
    }

    @Test
    public void multiply_percentage() {
        assertEquals("1.84", calculate("80×2.3%"));
    }

    @Test
    public void divide_percentage() {
        assertEquals("4000", calculate("100/2.5%"));
    }

    @Test
    public void multiply_and_divide_percentage() {
        assertEquals("20", calculate("60/6%×2%"));
    }

    @Test
    public void add_percentage() {
        assertEquals("52.5", calculate("50+5%"));
    }

    @Test
    public void minus_percentage() {
        assertEquals("60.8", calculate("95-36%"));
    }

    @Test
    public void percentage_multiple_operations() {
        assertEquals("13156", calculate("1000-2.5%+65/1%+76%"));
    }

    @Test
    public void negative_number_first() {
        assertEquals("-93", calculate("-100+7"));
    }
}