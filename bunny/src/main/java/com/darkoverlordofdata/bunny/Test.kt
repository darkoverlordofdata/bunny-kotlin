package com.darkoverlordofdata.bunny


class Test(name:String, proc:() -> Unit) {
    val name = name
    var proc = proc
    var result = false
    var hasReturn = false

}