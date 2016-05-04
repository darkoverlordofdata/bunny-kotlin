# Bunny

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
     * Simple Unit Test Framework for kotlin
     *    by Dark Overlord of Data
     * 
     *     Copyright 2016 Bruce Davidson
     */
     
     “Many human beings say that they enjoy the winter, but what they really enjoy is feeling proof against it.” 
     ― Richard Adams, Watership Down
     
     
# Why?
because jUnit isn't fully compatible with kotlin - you must write your test in java.
I don't do java.

### Functional
```kotlin

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
```

### OOP
```kotlin
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
```

    bunny test suite v0.0.2
          /\ /\
          \/_\/
          ('.')
         (     )
    It's no ordinary rabbit
    
    
        this is a test
    ---------------------------------
    PASS <=> Smoke Test Bunny::expect
    PASS <=> Smoke Test Bunny::assert
    PASS <=> ECS Test Matcher
    ---------------------------------
        <====> Pass: 3
        <====> Fail: 0
    
    
    
    Process finished with exit code 0

