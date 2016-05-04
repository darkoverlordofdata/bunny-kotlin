package com.darkoverlordofdata.bunny

class Assert {

    fun equal(actual:Any, expected:Any):Boolean {
        if (actual.equals(expected)) {
            Expectation.result = true
        } else {
            Expectation.result = false
            Expectation.actual = actual
            Expectation.expected = expected
        }
        return Expectation.result;
    }
}