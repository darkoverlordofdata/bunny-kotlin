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

open class Bunny(logo:Boolean=true) {
    val LOGO = """
bunny test suite $Version
      /\ /\
      \/_\/
      ('.')
     (     )
It's no ordinary rabbit

"""
    var logo = logo
    var passed = 0
    var failed = 0
    var name = ""
    var should = Should()
    val tests:MutableList<Test> = mutableListOf()

    init {
        if (logo) println(LOGO)
    }

    val assert: Assert by lazy { Assert() }

    fun describe(name:String) {
        this.name = name
    }

    fun expect(actual:Any): Expectation = Expectation(actual)

    fun test(name:String, proc:() -> Unit) {
        tests.add(Test(name, proc))
    }

    open fun start(){}
    open fun end(){}
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
            }
        }
        println("---------------------------------")
        println("    <====> Pass: $passed")
        println("    <====> Fail: $failed\n\n")

    }



}
