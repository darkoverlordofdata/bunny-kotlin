package com.darkoverlordofdata.bunny

/**
 *
 * Inspired by chai.js
 *
var expect = chai.expect;

expect(foo).to.be.a('string');
expect(foo).to.equal('bar');
expect(foo).to.have.length(3);
expect(tea).to.have.property('flavors').with.length(3);

 */

class To(parent: Expectation) {

    val parent = parent
    val should = Should()
    var invert = false

    val not: To
            get() {
                invert = true
                return this
            }

    fun equal(expected:Any) {
        val test = parent.actual.equals(expected)
        Expectation.result = if (invert) !test else test
    }


}
