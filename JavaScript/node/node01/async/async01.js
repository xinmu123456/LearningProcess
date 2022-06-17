import fetch from 'node-fetch';

async function getZhihuColumn(id) {
    const url = `https://v0.yiketianqi.com/api?unescape=1&version=v91&appid=43656176&appsecret=I42og6Lm&ext=&cityid=&city=`;
    const response = await fetch(url);
    const columns = await response.json();
    console.log(columns);

}

getZhihuColumn('fweekly')