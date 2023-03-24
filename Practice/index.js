/*
  Events 3 Question Rule:

  Overview:
    Click a button to make the text hello add ! to the end.

  Cause: event type 'click'
  
  Effect: creating a function to add an ! to the end of Hello
  
  When: DOMContentLoaded
*/

const button = () => document.querySelector("button");
const p = () => document.querySelector("p");

const addExclamationMark = (e) => {
  p().innerText += "!"
}


document.addEventListener("DOMContentLoaded", function() {
  button().addEventListener('click', addExclamationMark);
})