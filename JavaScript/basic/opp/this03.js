// var obj = {
//     x: 100,
//     show() {
//         setTimeout(function () {
//             console.log(this.x);
//         }, 500)
//     }
// }

// obj.show()


// var obj = {
//     x: 100,
//     show() {
//         setTimeout(() => {
//             console.log(this.x);
//         }, 500);
//     }
// }

// obj.show()

var obj = {
    a: 5,
    fun: () => {
        console.log(this.a);
    }
}

obj.fun()


var obj = {
    a: 5,
    fun1() {
        console.log(this.a);
    },
    func2() {
        console.log(this);
    }
}

var obj = {
    a: 5,
    func1() {
        console.log(this.a);
    },
    f: function () {
        console.log(this.a);
    }
}

obj.f()
obj.func1()
console.log(obj);


(function () {
    console.log('hello');
})()