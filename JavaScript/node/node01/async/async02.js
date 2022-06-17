import fetch from "node-fetch";

fetch(`https://v0.yiketianqi.com/api?unescape=1&version=v91&appid=43656176&appsecret=I42og6Lm&ext=&cityid=&city=北京`)
    .then(res => res.json())
    .then((json) => console.log(json))
    .catch((err) => {
        console.log(err.message);
    })

async function f() {
    const promiseA = fetch('https://v0.yiketianqi.com/api?unescape=1&version=v91&appid=43656176&appsecret=I42og6Lm&ext=&cityid=&city=宜宾').then(res => res.json())
    const promiseB = fetch(`https://v0.yiketianqi.com/api?unescape=1&version=v91&appid=43656176&appsecret=I42og6Lm&ext=&cityid=&city=上海`).then(res => res.json())
    const [a, b] = await Promise.all([promiseA, promiseB])
    console.log(a)
    console.log(b);
}

f()