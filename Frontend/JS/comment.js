// add comment
function manage(completeform) {
 let bt = document.getElementById('btSubmit');
if (completeform.value == '' ){
    bt.disabled = true;
}
else {
    bt.disabled = false;
}
}



//show all comments


const showcommsURL = 'http://localhost:8010/comment/showall';
fetch (showcommsURL)
.then(
    (response)=>{
        //200 status check
    if (response.status !== 200) {  
        console.warn('Looks like there was a problem. Status Code: ' + response.status);  
        return;  
    }
    //Examine the text in the response  
    response.json().then(function appendData(data) {
        console.log(data)
        // let commentsContainer = document.querySelector("myData");
        for (let i = 0; i<data.length; i++){
            console.log(data[i].review)
            let commentsContainer = document.getElementById("myData");
            let div = document.createElement('DIV');

            let deletebutton = document.createElement('button');
            deletebutton.classList = 'Delete';
            deletebutton.setAttribute("href", `http://localhost:8010/comment/delete/${review}`);
            deletebutton.addEventListener("click", (event) =>{
                event.preventDefault();
                deleteData(deleteButton.getAttribute("href"));
                location.reload();
            });
            
            div.innerHTML = 'Comments: ' + data[i].review + data[i].createdDate;
            commentsContainer.appendChild(div);
        }
    });
})
        .catch(function (error) {
          console.log("Request failed", error);
        });
