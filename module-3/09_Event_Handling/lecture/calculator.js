document.addEventListener("DOMContentLoaded", (event) => {
    //alert(document.getElementById("num1"));

    const btnCalculate = document.getElementById("btnCalculate");
    btnCalculate.addEventListener("click", (event) => {
        
        event.preventDefault();
        calculate();
    })
})

function calculate(){
    const num1 = document.getElementById("num1");
    const num2 = document.getElementById("num2");

    const sum = parseInt(num1.value) + parseInt(num2.value);

    const h2 = document.getElementById("result");
    h2.innerText = sum;
}


