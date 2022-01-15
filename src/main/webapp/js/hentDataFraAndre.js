function getAftaleRemote(){
    fetch("rest/remote", {headers: {
            "authorization": "Bearer " + localStorage.getItem("token")}})
        .then(function (data){
            data.text()
                .then(function(text){
                        //alert(text)
                    let xmlDoc = new DOMParser().parseFromString(text,"text/xml")
                    let aftaleText =document.getElementById("aftale")
                    aftaleText.innerText=xmlDoc.getElementsByTagName("CPR").item(0).innerHTML +xmlDoc.getElementsByTagName("ID").item(0).innerHTML+xmlDoc.getElementsByTagName("KlinikID").item(0).innerHTML+xmlDoc.getElementsByTagName("TimeStart").item(0).innerHTML+xmlDoc.getElementsByTagName("TimeEnd").item(0).innerHTML+xmlDoc.getElementsByTagName("Notat").item(0).innerHTML
                    }
                )
        })
}
