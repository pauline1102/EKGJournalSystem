//hent egk data og gem i objekt (json)

async function hentSessions(){
    let cpr1 = document.getElementById("skrivCPR").value
    let res = await fetch("rest/ekgSessions/" + cpr1,{
        headers:{
            "authorization": "Bearer " + localStorage.getItem("token"),
        }
    });
    console.log(res.status)
    if (res.status!=200){
        alert("noget gik galt!");
    }
    let json1 = await res.json();
    console.log("session ID" +json1)
    let sessionID1 = json1[0].sessions[i]
    document.getElementById("sessionsforCPR").innerHTML =JSON.stringify(sessionID1)


}


async function hentEKGDATA() {
    const sessionID = document.getElementById("skrivID").value
    let result = await fetch("rest/ekgSessions/measurements/" + sessionID, {
            headers: {
                "authorization": "Bearer " + localStorage.getItem("token")
            }
        }
    );
    console.log(result.status)
    if (result.status != 200) {
        alert("noget gik galt!");
    }
    let ekgdata = await result.json();
   let data = {
       datasets:
            [
                {label:"ekg",
                    backgroundColor: 'rgb(255, 0, 0)',
                    borderColor: 'rgb(255, 0, 0)',
                    data: ekgdata}
            ]
   }
   data.labels = Array(data.datasets[0].data.length).fill("")

    const config = {
        type: 'line',
        data: data,
        options: {}
    };

    const mychart = new Chart(
        document.getElementById('myChart'),
        config
    );

}


async function Tilbage(){
    localStorage.setItem("token"," ");
    window.location.href="lægeForside.html"

}