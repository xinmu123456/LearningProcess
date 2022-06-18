import fetch from 'node-fetch';


function getWeather_1(city) {
    const url = `https://v0.yiketianqi.com/api?unescape=1&version=v91&appid=43656176&appsecret=I42og6Lm&ext=&cityid=&city=${city}`
    fetch(url)
        .then(resp => resp.json())
        .then(data => {
            console.log(data);
        })
}

getWeather_1('宜宾')


async function getWeather_2(city) {
    const url = `https://v0.yiketianqi.com/api?unescape=1&version=v91&appid=43656176&appsecret=I42og6Lm&ext=&cityid=&city=${city}`
    const response = await fetch(url)
    const data = await response.json()
    return data
}

getWeather_2('北京').then(data => console.log(data)).catch(err => console.log(err.message))

// getWeather_2('北').then(data => console.log(data)).catch(err => console.log(err.message))


async function getWeather_3(city) {
    const url = `https://v0.yiketianqi.com/api?unescape=1&version=v91&appid=43656176&appsecret=I42og6Lm&ext=&cityid=&city=${city}`
    const response = await fetch(url)
    if (response.status !== 200) {
        throw new Error(response.statusText)
    }
    return await response.json()
}

const showCityInfo = async (city) => {
    try {
        const data = await getWeather_3(city)
        console.log(data)
        console.log(`city: ${data.city}`);
    } catch (err) {
        console.log(err);
    }
}

showCityInfo('宜宾')

async function getWeather_4(city) {
    const url = `https://v0.yiketianqi.com/api?unescape=1&version=v91&appid=43656176&appsecret=I42og6Lm&ext=&cityid=&city=${city}`
    const response = await fetch(url)
    return await response.json()
}


const getMoreCityWeather = async () => {

    const c1p = getWeather_4('武汉')
    const c2p = getWeather_4('十堰')
    const c3p = getWeather_4('北京')


    const c1 = await c1p
    const c2 = await c2p
    const c3 = await c3p

    console.log(`weather: ${c1.city}`);
    console.log(`weather: ${c2.city}`);
    console.log(`weather: ${c3.city}`);
}

getMoreCityWeather()

const showWeatherInfo = async () => {
    const [c1, c2] = await Promise.all([
        getWeather_4('成都'),
        getWeather_4('北京')
    ])
    console.log(c1, 'f');
    console.log(c2, 'f');
}
showWeatherInfo()