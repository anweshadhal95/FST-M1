import pytest


def test_addition():
    num1 = 10
    num2 = 25
    sum = num1 + num2
    assert sum == 35


def test_subtraction():
    num1 = 50
    num2 = 35
    diff = num1 - num2
    assert diff == 16


def test_multiplication():
    num1 = 50
    num2 = 20
    prod = num1 * num2
    assert prod == 1000


def test_division():
    num1 = 100
    num2 = 5
    quot = num1 / num2
    assert quot == 2
