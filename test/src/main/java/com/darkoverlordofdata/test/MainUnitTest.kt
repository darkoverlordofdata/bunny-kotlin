package com.darkoverlordofdata.test

import com.darkoverlordofdata.bunny.UnitTest

fun main(args: Array<String>) {
    MyTest().run()
}


class MyTest : UnitTest("This is the test") {

    init {

        var x = 0

        beforeEach { x += 1 }

        should("test1") {
            assert.equal(0, 0)
        }

        should("test2") {
            assert.equal(1, 0)
        }

        done {
            println("that's all $x")
        }
    }
}
