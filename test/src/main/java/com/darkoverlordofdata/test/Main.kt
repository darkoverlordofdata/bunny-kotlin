package com.darkoverlordofdata.test

import com.darkoverlordofdata.bunny.TestIt

fun main(args: Array<String>) {
    var k1 = 0
    var k2 = 0
    var k3 = 0

    TestIt("this is the test suite")
    .beforeEach {
        k1 += 1
    }.afterEach {
        k2 += 1
    }.onDone {
        k3 = k1 + k2
    }.run {

        it("this is the test") {
            it.equals(1, 1)
        }

        it("this is another test") {
            it.equals("fred", 1)
        }

    }

}

/**

  	 this is the test suite
---------------------------------
PASS <=> this is the test
FAIL <=> this is another test
     expected [1]
       actual [fred]
---------------------------------
     <====> Pass: 1
     <====> Fail: 1


 */