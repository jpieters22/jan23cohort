const sadDay = () => {
    console.log("Our time is coming to an end way to fast")
    sadDay()
}
// sadDay()

var a = 0
const sadDayFixed = () => {
    // while loop version
    // console.log("Our time is coming to an end way to fast")
    // a++
    // while(a<50) {
    //     sadDayFixed()
    // }
    // do while version
    // do {
    //     a++
    //     console.log("Our time is coming to an end way to fast")
    // }
    // while(a < 50)
    // if version
    console.log("Our time is coming to an end way to fast")
    if(a == 50) {
        return
    } else {
        a++
        sadDayFixed()
    }
}
// sadDayFixed()

// Create a function that can look through an array of any dimension, that is a list that could have any number of lists in it, and will return the sum of all values within.
// Using this five dimensional array should return 80
var data = [
    3,
    [1, 2, 3, 4],
    [
        [1, 2, 3, 4],
        [1, 2, 3, 4, 5],
        [
            [1, 2, 3],
            [1, 2, 3, 4, [1, 2, 3, 4]],
        ]
    ],
    [3, 4, 5],
    1,
    3,
]
// will need a for loop to move through the dataset
// if index is a number add it to sum
// if index is an array we need to look into the array - call function
// isArray() -  using an if statement - if array do this if not do that
var sum = 0
const funWithRecursion = (a) => {
    for(var i=0; i< a.length; i++) {
        if(!Array.isArray(a[i])) { // if it is not an array
            sum = sum + a[i] // add it to sum
        } else {
            funWithRecursion(a[i]) // start at the current index and loop through
        }
    }
    return sum
}
console.log(funWithRecursion(data))

// find sum of
altdata = [1, 2, 3, 4]

const test = (a) => {
    for(i=0; i< a.length; i++) {
        sum += a[i]
    }
    console.log(sum)
}
// test(altdata)
// test(data)