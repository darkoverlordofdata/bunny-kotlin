package com.darkoverlordofdata.bunny

class Expectation(actual:Any) {
    companion object static {
        var result = false
    }
    val actual = actual
    val to = To(this)

}
