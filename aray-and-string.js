/*
Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation
is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
1.5
1.6
EXAMPLE
Input: Tact Coa
Output: True (permutations: "taco cat", "atco eta", etc.)  
*/

function isPalindromPermulation(input = "") {
  const normalizeInput = input.toLowerCase();
  const map = {};
  let trueLength = 0;

  //count each char
  for (let char of normalizeInput) {
    if (char >= "a" && char <= "z") {
      trueLength++;
      map[char] = (map[char] || 0) + 1;
    }
  }

  let isWrong = Object.keys(map).filter((key) => map[key] % 2 !== 0).length > 1;
  if (isWrong) {
    console.log("wrong fotmat");
    return false;
  }

  return true;
}

// isPalindromPermulation("tact coapapa");

function checkOneOrZeroEdit(str1, str2) {
  const del = str1.length - str2.length;
  const isMoreThanOneEdit = del * del > 1;
  const isEdit = str1.length == str2.length;
  if (isMoreThanOneEdit) {
    return false;
  }

  if (isEdit) {
    let countEdit = 0;
    for (let i = 0; i < str1.length; i++) {
      if (str1[i] !== str2[i]) {
        countEdit++;
      }

      if (countEdit > 1) {
        return false;
      }
    }
    return true;
  }

  const minlength = Math.min(str1.length, str2.length);
  const minStr = str1.length === minlength ? str1 : str2;
  const maxStr = str1.length === minlength ? str2 : str1;

  let i = 0; 
  let j = 0;
  let count = 0;
  while (i < minlength && j < maxStr.length) {
    if(count > 1) {
      return false;
    }

    if(minStr[i] !== maxStr[j]) {
      count++;
      // if(minStr[i+1] === maxStr[j]) {
      //   i++;
      // }

      // if(minStr[i] === maxStr[j+1]) {
      //   j++;
      // }
    
    }else{
      i++;
    }
    j++;
  }

  return true;
}

console.log("1",checkOneOrZeroEdit("pale", "pale"));


function oneEditAway(first, second) {
  // Kiểm tra độ dài, nếu chênh lệch lớn hơn 1 thì chắc chắn không thể chỉnh sửa 1 lần
  if (Math.abs(first.length - second.length) > 1) {
      return false;
  }

  // Xác định chuỗi ngắn hơn và dài hơn
  let s1 = first.length < second.length ? first : second;
  let s2 = first.length < second.length ? second : first;

  let index1 = 0, index2 = 0;
  let foundDifference = false;

  while (index2 < s2.length && index1 < s1.length) {
      if (s1[index1] !== s2[index2]) {
          // Nếu đã tìm thấy sự khác biệt trước đó thì return false
          if (foundDifference) {
              return false;
          }
          foundDifference = true;

          // Nếu độ dài bằng nhau, nghĩa là là trường hợp thay thế, nên tăng cả hai con trỏ
          if (s1.length === s2.length) {
              index1++;
          }
      } else {
          index1++; // Nếu giống nhau, di chuyển con trỏ của chuỗi ngắn hơn
      }
      index2++; // Luôn di chuyển con trỏ của chuỗi dài hơn
  }

  return true;
}

// Test cases
// console.log(oneEditAway("ale", "pale"));   // true (remove 'a')
// console.log(oneEditAway("pales", "pale")); // true (remove 's')
// console.log(oneEditAway("pale", "bale"));  // true (replace 'p' -> 'b')
// console.log(oneEditAway("pale", "bake"));  // false (replace 'p' -> 'b' and 'l' -> 'k')
// console.log(oneEditAway("pale", "palee")); // true (insert 'e')
// console.log(oneEditAway("pale", "pa"));    // false (remove more than on

function stringCompression(str) {
  let newStr = "";
  let count = 0;
  for (let index = 0; index < str.length; index++) {
   
    const ch = str[index];
    const isLast = index == str.length-1;
    const isEndGroup = isLast ? false : ch != str[index + 1];

    count++;
    if(count==1){
      newStr += ch;
    }
 
    if(isLast || isEndGroup)
    {
      newStr+=count;
      count = 0;
    }

    if( newStr.length >= str.length){
      return str;
    }
  }

  return newStr;
}

console.log(stringCompression("aabbcc"));

function rotateMatrix(maxtrix=[1,1,2,2]){

  let n = 2;
  let vectorLenth = 
  let rotateMatrix = [];

  let edgeLength = n-1;
  const transformToXY = (j, i)=>{
    return {
      x: j - edgeLength/2,
      y: i - edgeLength/2
    }
  }

  const transformToIJ = (x,y)=>{
   return {
    i: y+edgeLength/2,
    j: x+edgeLength/2
   }
  }


  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
     let item = matrix[i*n+j];
       let i1 = j;
       let j1 = i;
       i1 = edgeLength - i1;
       j1 = edgeLength - j1;
       rotateMatrix[i1*n+j1];
    }
  }


}

function printMatrix1D(arr, rows, cols) {
  for (let i = 0; i < rows; i++) {
      let row = [];
      for (let j = 0; j < cols; j++) {
          row.push(arr[i * cols + j]); // Tính chỉ số trong mảng 1D
      }
      console.log(row.join(" ")); // In hàng với tab giữa các số
  }
}

rotateMatrix();