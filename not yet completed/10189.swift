//NOT YET COMPLETED
// Your code here!
import Foundation

var inputs = Array(repeating: Array(repeating: "", count: 102), count: 102)
var map = Array(repeating: Array(repeating: 0, count: 102), count: 102)
var counter = 0

while let str = readLine() {
    let strArr = str.components
    print("strArr: \(strArr)"")
    if let n = Int(strArr[0]), let m = Int(strArr[1]) {
        //end point check
        if n == 0 && m == 0 {
            //print("break")
            break
        }
        
        print("n: \(n), m: \(m)")
        
        //input
        for i in 1...n {
            let str2 = readLine()!
            let str2Arr = str2.components(separatedBy: "")
            for j in 1...m {
                let letter = str2Arr[j]
                inputs[i][j] = letter
                if letter == "*" {
                    map[i - 1][j - 1] += 1
                    map[i - 1][j] += 1
                    map[i - 1][j + 1] += 1
                    map[i][j - 1] += 1
                    map[i][j + 1] += 1
                    map[i + 1][j - 1] += 1
                    map[i + 1][j] += 1
                    map[i + 1][j + 1] += 1
                }
                
            }
        }
        
        //plus 1 to counter
        counter += 1
        
        //output
        print("Field #\(counter):")
        for k in 1...n {
            for l in 1...m{
                if inputs[k][l] == "*" {
                    print("*", terminator: "")
                } else {
                    print(map[k][l], terminator: "")
                }
            } 
            print("\n")
        }
        print("\n")
                //print("\(n) \(m)")
    }
    
    
}

