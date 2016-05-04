package com.darkoverlordofdata.test
import  com.darkoverlordofdata.bunny.Assert

fun main(args: Array<String>) {

    TestIt("this is the test suite") {
        it("this is the test") {
            it.equal(1, 1)
        }
        it("this is another test") {
            it.equal(2,2)
        }
    }.run()
}


class TestIt(name:String, proc:(func:(name:String, proc:(assert:Assert) -> Unit) -> Unit) -> Unit) {

    val name = name
    val proc = proc

    val assert = Assert()

    val test = {name:String, proc:(assert:Assert) -> Unit ->
        proc(assert)
    }

    init {
        proc(test)
    }

    fun run() {
        println("Run!")
    }

}

