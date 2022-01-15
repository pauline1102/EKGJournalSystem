//hent egk data og gem i objekt (json)

async function hentEKGDATA() {
    const sessionID = document.getElementById("skrivID").value
    let result = await fetch("rest/ecg/" + sessionID, {
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