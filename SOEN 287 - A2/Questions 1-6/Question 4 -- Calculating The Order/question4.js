
function calculateOrder() {
    let input1 = parseInt(document.getElementById("input1").value) || 0;
    let input2 = parseInt(document.getElementById("input2").value) || 0;
    let input3 = parseInt(document.getElementById("input3").value) || 0;

    let total1 = input1 * 1.99;
    let total2 = input2 * 2.99;
    let total3 = input3 * 3.99;

    let finalTotal = total1 + total2 + total3;
    document.getElementById("totalPrice").innerHTML = "<strong>First Item (Quantity "+ input1+"):</strong> $"+total1.toFixed(2)+
    "<br><strong>Second Item (Quantity "+ input2+"):</strong> $"+total2.toFixed(2)+"<br><strong>Third Item (Quantity "+ 
    input3+"):</strong> $"+total3.toFixed(2)+"<br><br><strong>Total Price of Order:</strong> $"+finalTotal.toFixed(2);
}
