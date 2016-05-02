package com.darkoverlordofdata.test

import com.darkoverlordofdata.bunny.Bunny

fun main(args: Array<String>) {
    MyTest().run()
}
class MyTest : Bunny() {
    init {

        describe("this is a test")

        test("Smoke Test Bunny::expect")
        {
            expect(10).to.equal(5+5)
        }

        test("Smoke Test Bunny::assert")
        {
            assert.equal(0, 1 - 1)
        }


    }
}

