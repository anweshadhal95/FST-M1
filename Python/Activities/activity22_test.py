import pytest


def test_addition():
    num1 = 10
    num2 = 20
    result = num1 + num2
    assert result == 30


def test_subtraction():
    num1 = 100
    num2 = 50
    result = num1 - num2
    assert result == 50


@pytest.mark.activity
def test_multiplication():
    num1 = 10
    num2 = 10
    result = num1 * num2
    assert result == 100


@pytest.mark.activity
def test_division():
    num1 = 49
    num2 = 7
    result = num1 / num2
    assert result == 7
