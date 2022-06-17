async function f1() {
    return 'f1'
}

function f2() {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve('abc')
        }, 2000);
    })
}

async function f3() {
    var c = await f2()
    console.log('qqq');
    console.log(c);
}

f3()