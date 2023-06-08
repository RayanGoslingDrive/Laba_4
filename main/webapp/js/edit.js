let Band = {
    Bandname: "",
    hometown: "",
    genre: "",
    last_ablbum: "",
    Singer: "",
    idInDatabase: 0
}
function Edit(){
    let xhrEdit = new XMLHttpRequest();
    Band.Bandname=document.getElementById("Bandname").value;
    Band.hometown=document.getElementById("hometown").value;
    Band.genre=document.getElementById("genre").value;
    Band.last_ablbum=document.getElementById("last_ablbum").value;
    Band.Singer=document.getElementById("Singer").value;
    Band.idInDatabase=location.search.split("=")[1];
    let Json = JSON.stringify(Band);
    console.log(Band);
    xhrEdit.open("POST", "save", true);
    xhrEdit.setRequestHeader('Content-Type', 'application/json');
    xhrEdit.send(Json);
    location.href="read"
}