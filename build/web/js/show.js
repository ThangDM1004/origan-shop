function Show() {
    const element = document.getElementById("mytext");
    if (document.getElementById("myform").classList.toggle("show")) {
        element.innerHTML = "Hide Product List";
        document.getElementById("myform").style.display = "block";
    } else {
        element.innerHTML = "Show Product List";
        document.getElementById("myform").style.display = "none";
    }
}
function ShowForm() {
    const element = document.getElementById("mytext_1");
    if (document.getElementById("myform_1").classList.toggle("show")) {
        element.innerHTML = "Hide Create Form";
        document.getElementById("myform_1").style.display = "block";
    } else {
        element.innerHTML = "Show Create Form";
        document.getElementById("myform_1").style.display = "none";
    }
}