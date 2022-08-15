
async function msg(){
    let p = new Promise((resolve,reject)=>setTimeout(resolve,1000,'jackson'));
    console.log(await p);
}


async function foo(a) {
    setTimeout(() => {
        console.log(a);
    }, 3000);
    console.log(a);
    msg()
}

// await foo(1)


msg();//jackson
foo(1)