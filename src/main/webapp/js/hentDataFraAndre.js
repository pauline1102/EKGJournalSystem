/*
function getAftaleRemote(){
    fetch("https://ekg3.diplomportal.dk/data/aftaler?cpr=xxxxxxxxxx", {headers: {
            "authorization": "Bearer " + "hemmeliglogin"}})
        .then(function (data){
            data.text()
                .then(function(text){
                        alert(text)
                    let xmlDoc = new DOMParser().parseFromString(text,"text/xml")
                    let aftaleText =document.getElementById("aftale")
                    aftaleText.innerText=xmlDoc.getElementsByTagName("CPR").item(0).innerHTML +xmlDoc.getElementsByTagName("ID").item(0).innerHTML+xmlDoc.getElementsByTagName("KlinikID").item(0).innerHTML+xmlDoc.getElementsByTagName("TimeStart").item(0).innerHTML+xmlDoc.getElementsByTagName("TimeEnd").item(0).innerHTML+xmlDoc.getElementsByTagName("Notat").item(0).innerHTML
                    }
                )
        })
}
*/

function postAftale() {
    let res = fetch("rest/xml", {
        method: "POST"
    })
    console.log(res)
}
function getAftale() {
    let res = fetch("rest/xml/aftale?cpr=", {
        method: "GET"
    })
    console.log(res)
}