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

isPalindromPermulation("tact coapapa");



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

      i++;
    
    }else{
      i++;
      j++;
    }
  }

  return true;
}

console.log(checkOneOrZeroEdit("ale", "pale"));