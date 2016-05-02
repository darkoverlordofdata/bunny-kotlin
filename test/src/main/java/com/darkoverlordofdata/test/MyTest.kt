package com.darkoverlordofdata.test

import com.darkoverlordofdata.bunny.Bunny

class MyTest() : Bunny() {
    init {

        describe("Bunny Unit Tests")

        test("Smoke Test Bunny::expect") {

            expect(10).to.equal(5+5)
        }

        test("Smoke Test Bunny::assert") {

            assert.equal(1, 0)
        }


    }

}

