
async function  SeKonsultation(){
    let result = await fetch("rest/aftaler", {
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

    let listelements =""
    json.forEach(function(element){
        listelements +=("<li>"+element.date+"</li>")
    })

    let list = document.getElementById("aftaler");
    list.innerHTML=listelements
}
async function Tilbage(){
    localStorage.setItem("token"," ");
    window.location.href="konsultationer.html"

}