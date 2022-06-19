

f = () => {
    console.log(this)
}


f()


var A = {
    name: 'A',
    say: function () {
        return this.name
    }
}

var B = {
    name: "b"
}

console.log(A.say());

console.log(A.say.call(B));


var C = {
    name: 'C',
    sayHello: () => {
        console.log(this);
        console.log(this.name);
    }
}

C.sayHello()


var D = {
    name: 'D',
    sayHello: function () {
        var s = () => console.log(this.name);
        return s
    }
}

D.sayHello()()

var E = {
    name: "d",
    say: () => {
        console.log(this.name);
    }
}

E.say.call(B)

