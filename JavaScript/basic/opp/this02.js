let f = () => {
    console.log('hello');
}

f()

let fn = n => ({ id: 1, name: "xinmu" })
console.log(fn(1));

let obj = {
    name: 'obj',
    init: () => {
        console.log(this)
    }
}

