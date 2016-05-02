package com.darkoverlordofdata.bunny
/**
 *
 * Inspired by chai.js
 *
var assert = chai.assert;

assert.typeOf(foo, 'string');
assert.equal(foo, 'bar');
assert.lengthOf(foo, 3)
assert.property(tea, 'flavors');
assert.lengthOf(tea.flavors, 3);


 */

class Assert {

    fun match(actual:String, expected:String):Boolean {
        return actual.equals(expected)
    }

    fun equal(actual:Any, expected:Any):Boolean {
        return actual.equals(expected)
    }
}