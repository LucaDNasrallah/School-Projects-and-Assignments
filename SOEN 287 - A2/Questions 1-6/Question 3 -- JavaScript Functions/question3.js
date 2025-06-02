// Function A: Add Numbers of an Array
function addNumbers(arr) {
    let sum = arr.reduce((a, b) => a + b, 0);
    return sum;
  }

  // Function B: Finding the Max Number of an Array
  function findMaxNumber(arr) {
    let max = Math.max(...arr);
    return max;
  }

  // Function C: Taking the Sum of only Odd Numbers
  function addOddNumbers(arr) {
    let sum = 0;
    for (let i = 0; i < arr.length; i++) {
      let num = parseFloat(arr[i]);
      if (!isNaN(num) && num % 2 !== 0) {
        sum += num;
      }
    }
    return sum;
  }

  // Function D: Getting Digits of a String
  function getDigits(str) {
    let digits = str.match(/\d/g);
    // Return the digits as a single concatenated string (or an empty string if none found)
    return digits ? digits.join('') : '';
  }

  // Function E: Reversing a String
  function reverseString(str) {
    return str.split('').reverse().join('');
  }

  // Function F: Get Current Date
  function getCurrentDate(){
    const d = new Date();
    return d.toDateString();
  }