package com.darkoverlordofdata.bunny
/**
 * TestIt
 * An entire unit test framework in 80 lines of code
 */
class TestIt(name:String) {

    private var name = name
    private var beforeProc = {}
    private var afterProc = {}
    private var doneProc = {}
    private val tests:MutableList<Test> = mutableListOf()

    data class Test(val name:String, val proc:(assert) -> Unit) {}

    object assert {
        var result = false
        var actual:Any? = null
        var expected:Any? = null
        fun equals(actual:Any, expected:Any):Boolean {
            if (actual.equals(expected)) {
                this.result = true
            } else {
                this.result = false
                this.actual = actual
                this.expected = expected
            }
            return this.result;
        }
    }

    fun beforeEach(proc:() -> Unit):TestIt {
        beforeProc = proc
        return this
    }

    fun afterEach(proc:() -> Unit):TestIt {
        afterProc = proc
        return this
    }

    fun onDone(proc:() -> Unit):TestIt {
        doneProc = proc
        return this
    }

    fun run(main:(func:(name:String, proc:(assert) -> Unit) -> Unit) -> Unit) {

        val fail = "\u001b[31m" /* VT100 RED */
        val pass = "\u001b[32m" /* VT100 GREEN */
        val reset = "\u001b[0m" /* VT100 RESET */
        var passed = 0
        var failed = 0

        main {name:String, proc:(assert) -> Unit ->
            val ignore  = tests.add(Test(name, proc))
        }

        println("\t$name\n---------------------------------")
        for (test in tests) {
            assert.result = true
            beforeProc()
            test.proc(assert)
            afterProc()
            if (assert.result) {
                passed++
                println("${pass}PASS${reset} <=> ${test.name}")
            } else {
                failed++
                println("${fail}FAIL${reset} <=> ${test.name}")
                println("     expected ${fail}[${reset}${assert.expected}${fail}]${reset}")
                println("       actual ${fail}[${reset}${assert.actual}${fail}]${reset}")
            }
        }
        doneProc()
        println("---------------------------------")
        println("    <====> Pass: $passed")
        println("    <====> Fail: $failed\n\n")
    }
}