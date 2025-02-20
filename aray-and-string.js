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
