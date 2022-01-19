async function getAftale() {
    let cpr = document.getElementById("skrivcpr").value
    let result = await fetch("rest/xml/aftale?cpr="+cpr, {
            headers: {
                "authorization": "Bearer " + localStorage.getItem("token")
            }
        }
    );
    console.log(result.status)
    if (result.status!=200){
        alert("noget gik galt!");
    }
    let json = await result.json();
    console.log(json)
    for( let i = 0; i<json[0].aftaleListe.aftale.length; i++){
        let aftale = json[i].aftaleListe.aftale[i]
        document.getElementById("aftale").innerText += JSON.stringify(aftale)
    }
}

async function getSession() {
    let cpr1 = document.getElementById("skrivcpr").value
    let result1 = await fetch("rest/xml/sessions?cpr="+cpr1, {
            headers: {
                "authorization": "Bearer " + localStorage.getItem("token")
            }
        }
    );
    console.log(result1.status)
    if (result1.status!=200){
        alert("noget gik galt!");
    }
    let json1 = await result1.json();
    console.log(json1)
    for (let i =0; i<json1[0].sessions.ekgSession.length; i++){
        let session1 = json1[0].sessions.ekgSession[i]
        document.getElementById("sessions").innerHTML +=JSON.stringify(session1)
    }
    for (let i =0; i<json1[1].sessions.ekgSession.length; i++){
        let session2 = json1[1].sessions.ekgSession[i]
        document.getElementById("sessions").innerHTML +=JSON.stringify(session2)
    }
    for (let i =0; i<json1[2].ekgSessionList.ekgSession.length; i++){
        let session3 = json1[2].ekgSessionList.ekgSession[i]
        document.getElementById("sessions").innerHTML +=JSON.stringify(session3)
    }
    for (let i =0; i<json1[3].ekgListe.ekgSession.length; i++){
        let session4 = json1[3].ekgListe.ekgSession[i]
        document.getElementById("sessions").innerHTML +=JSON.stringify(session4)
    }
}

async function getMeasurements() {
    let sessionID = document.getElementById("skrivsessionID").value
    let result2 = await fetch("rest/xml/sessions/measurements?sessionID=" + sessionID, {
            headers: {
                "authorization": "Bearer " + localStorage.getItem("token")
            }
        }
    );
    console.log(result2.status)
    if (result2.status != 200) {
        alert("noget gik galt!");
    }
    let json2 = await result2.json();
    console.log(json2)
    for (let i =0; i<json2[0].measurements.measurment.length; i++){
        let measurement1 = json2[0].measurements[i]
        document.getElementById("measurements1").innerHTML +=JSON.stringify(measurement1)
    }
    for (let i =0; i<json2[1].measurements.measurment.length; i++){
        let measurement2 = json2[1].measurements[i]
        document.getElementById("measurements1").innerHTML +=JSON.stringify(measurement2)
    }
    for (let i =0; i<json2[2].ekgData.ekgSession.length; i++){
        let measurement3 = json2[2].ekgData.ekgSession[i]
        document.getElementById("measurements1").innerHTML +=JSON.stringify(measurement3)
    }

}


