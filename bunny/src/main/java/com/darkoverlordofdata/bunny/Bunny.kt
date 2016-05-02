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

open class Bunny {
    val LOGO = """
bunny test suite v0.0.2
      /\ /\
      \/_\/
      ('.')
     (     )
It's no ordinary rabbit

"""
    var passed = 0
    var failed = 0
    var name = ""
    var should = Should()
    val tests:MutableList<Test> = mutableListOf()

    init {
        println(LOGO)
    }

    val assert: Assert by lazy { Assert() }

    fun describe(name:String) {
        this.name = name
    }

    fun expect(actual:Any): Expectation = Expectation(actual)

    fun test(name:String, proc:() -> Unit) {
        tests.add(Test(name, proc))
    }

    fun run() {
        passed = 0
        failed = 0

        println("\t$name\n---------------------------------")
        for (test in tests) {
            Expectation.result = true
            test.proc()
            if (Expectation.result) {
                passed++
                println("PASS <=> ${test.name}")
            } else {
                failed++
                println("FAIL <=> ${test.name}")
            }
        }
        println("---------------------------------")
        println("    <====> Pass: $passed")
        println("    <====> Fail: $failed\n\n")

    }



}
