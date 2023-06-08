let Band = {
    Bandname: "",
    hometown: "",
    genre: "",
    last_ablbum: "",
    Singer: ""
}
function getData(){
    Band.Bandname=document.getElementById("Bandname").value;
    Band.hometown=document.getElementById("hometown").value;
    Band.genre=document.getElementById("genre").value;
    Band.last_ablbum=document.getElementById("last_ablbum").value;
    Band.Singer=document.getElementById("Singer").value;
    Band.idInDatabase=location.search.split("=")[1];
    let Json = JSON.stringify(Band);
    let xhrWrite = new XMLHttpRequest();
    xhrWrite.open("POST", "write",true);
    xhrWrite.setRequestHeader('Content-Type', 'application/json');
    xhrWrite.send(Json);
};