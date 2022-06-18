async function test1() {
    return 1
}

async function test2() {
    return Promise.resolve(2)
}

const ret1 = test1()
const ret2 = test2()
console.log(ret1);
console.log(ret2);

async function test3() {
    const p3 = Promise.resolve(3)
    p3.then(data3 => {
        console.log(data3);
    })
    const ret3 = await p3
    console.log(ret3);
}

test3()


async function test4() {
    const ret4 = await 4
    console.log(ret4);
}

test4()

async function test5() {
    const ret5 = await test1()
    console.log(ret5);
}
test5()


async function test6() {
    const p6 = Promise.reject(6)

    try {
        const ret6 = await p6
        console.log(ret6);
    } catch (error) {
        console.error(error);
    }
}
test6()