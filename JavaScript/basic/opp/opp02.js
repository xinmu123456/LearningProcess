class Person {
    constructor(name) {
        this.name = name
    }

    talk() {
        console.log('talk');
    }
}


class Student extends Person {
    constructor(name, score) {
        super(name)
        this.score = score
    }
    introduce() {
        console.log(this.name, this.score);
    }
}

const student = new Student('zhangsan', 123)
student.introduce()
console.log(student.__proto__.__proto__)
console.log(Student)