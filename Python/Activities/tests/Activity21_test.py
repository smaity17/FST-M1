import pytest
import math

def test_sum():
   num1 = 25
   num2 = 30
   sum = num1+num2
   assert sum == 55

def test_diff():
   num1 = 7
   num2 = 5
   assert num1-num2 == 2

def test_mul():
   num1 = 5
   num2 = 2
   assert num1*num2 == 10

def test_division():
   num1 = 10
   num2 = 2
   assert num1/num2 == 5