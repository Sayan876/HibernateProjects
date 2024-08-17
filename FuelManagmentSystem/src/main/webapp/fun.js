let inputs = document.querySelectorAll("input");
let butt = document.querySelector(".hr")

function hox(){
    let x = inputs[2].value;
    let y = inputs[4].value;

    if(x>y){
        alert("Stock limit Exceeded");
        butt.style.cursor="not-allowed";

    }
}