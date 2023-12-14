//We want to wait until the entire page is loaded so that when we 
//search for elements by id or use a query selector we will actually
//find those elements on the page (instead of trying to find them right away
//before the page has even finished loading)

//Any time we add an event listener, when the event is fired the event 
//itself will be passed as the first parameter to our function
document.addEventListener("DOMContentLoaded", (event) => {
    //alert(document.getElementById("num1"));
    const btnCalculate = document.getElementById("btnCalculate");
    btnCalculate.addEventListener("click", (event) => {
        
        alert(event.clientX + " x " + event.clientY);

        //This will prevent the form refresh (ie "default behavior")
        event.preventDefault();

        calculate();
    });

    btnCalculate.addEventListener('mouseover', () => {
        console.log("On Mouse Over");
    })

    const num1 = document.getElementById("num1");
    num1.addEventListener("focus", () => {
        console.log("On Focus")
    })

    num1.addEventListener("blur", () => {
        console.log("On Blur")
    })

    num1.addEventListener("change", () => {
        console.log("On Change")
    })

    num1.addEventListener("keyup", (event) => {
        console.log("On Keyup - You Pressed " + event.key)
    })

});


function calculate(){

    const num1 = document.getElementById("num1");
    const num2 = document.getElementById("num2");

    const sum = parseInt(num1.value) + parseInt(num2.value);

    const h2 = document.getElementById("result");
    h2.innerText = sum;
}

