class Subject {
    constructor(name) {
        this.name = name
        this.state = 'happy'
        this.observers = []
    }
    //添加观察者
    attach(them) {
        this.observers.push(them)
    }
    //更新状态
    setState(state) {
        this.state = state
        this.observers.forEach(them => {
            them.update(this)
        })
    }
}

class Observer {
    constructor(name) {
        this.name = name
    }
    //观察状态
    update(subject) {
        console.log(`${this.name} watch ->${subject.name} ${subject.state}`);
    }
}

let baby = new Subject('baby')
let father = new Observer('father')
let mother = new Observer('mother')

baby.attach(father)
baby.attach(mother)

baby.setState('unhappy')