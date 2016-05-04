package com.darkoverlordofdata.bunny
/**
 *
 *     ___
 *    | _ )_  _ _ _  _ _ _  _
 *    | _ \ || | ' \| ' \ || |
 *    |___/\_,_|_||_|_||_\_, |
 *                       |__/
 *
 *        /\ /\
 *        \/_\/
 *        ('.')
 *       (     )
 *
 *
 * Simple Testing Framework for kotlin
 *    by Dark Overlord of Data
 *
 *    Copyright 2016 Bruce Davidson
 */


open class UnitTest(name:String="") {
    var passed = 0
    var failed = 0
    var name = name
    val tests:MutableList<Test> = mutableListOf()
    internal var beforeProc = {}
    internal var afterProc = {}
    internal var doneProc = {}

    val assert: Assert by lazy { Assert() }

    fun beforeEach(proc:() -> Unit) {
        beforeProc = proc
    }

    fun afterEach(proc:() -> Unit) {
        afterProc = proc
    }

    fun done(proc:() -> Unit) {
        doneProc = proc
    }

    fun describe(name:String) {
        this.name = name
    }

    fun test(name:String, proc:() -> Unit) {
        tests.add(Test(name, proc))
    }
    fun should(name:String, proc:() -> Unit) {
        tests.add(Test(name, proc))
    }

    fun assertEquals(actual:Any, expected:Any):Boolean {
        return assert.equal(actual, expected)
    }

    open fun start(){
        beforeProc()
    }
    open fun end(){
        afterProc()
    }

    fun run() {
        passed = 0
        failed = 0

        println("\t$name\n---------------------------------")
        for (test in tests) {
            Expectation.result = true
            start()
            test.proc()
            end()
            if (Expectation.result) {
                passed++
                println("${Ansi.foreground(Color.GREEN)}PASS${Ansi.reset()} <=> ${test.name}")
            } else {
                failed++
                println("${Ansi.foreground(Color.RED)}FAIL${Ansi.reset()} <=> ${test.name}")
                println("     expected ${Ansi.foreground(Color.RED)}[${Ansi.reset()}${Expectation.expected}${Ansi.foreground(Color.RED)}]${Ansi.reset()}")
                println("     actual   ${Ansi.foreground(Color.RED)}[${Ansi.reset()}${Expectation.actual}${Ansi.foreground(Color.RED)}]${Ansi.reset()}")
            }
        }
        doneProc()
        println("---------------------------------")
        println("    <====> Pass: $passed")
        println("    <====> Fail: $failed\n\n")

    }

//${Ansi.foreground(Color.RED)}
//${Ansi.reset()}
}
