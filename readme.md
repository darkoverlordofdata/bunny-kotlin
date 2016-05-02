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

'''kotlin
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

        test("ECS Test Matcher")
        {
            var m = Matcher.allOf(1, 2, 3)
            //expect(m.toString()).to.equal("AllOf(Position,Movement,Resource)")
            expect(m.toString()).to.equal("AllOf(1,2,3)")
        }

    }
}
'''

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

