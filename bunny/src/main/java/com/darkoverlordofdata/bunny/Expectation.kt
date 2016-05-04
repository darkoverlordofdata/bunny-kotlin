package com.darkoverlordofdata.bunny

class Expectation(actual:Any) {
    companion object static {
        var result = false
        var actual:Any? = null
        var expected:Any? = null

    }
    val actual = actual

}
