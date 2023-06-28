import pytest


def test_sum_listelements(list1):
    sum = 0
    for i in range(11):
        sum = sum + int(list1[i])
    assert sum==55
