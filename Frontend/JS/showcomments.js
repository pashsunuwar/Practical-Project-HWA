
 function mycommentRow (data){
                    let row = document.createElement("tr");
                    let rowTH  = document.createElement("th");
                    let commentidTd = document.createElement('td');
                    let reviewTd = document.createElement('td');
                    let dateTd = document.createElement('td');
                    let editbutton = document.createElement('button');
                    let deletebutton = document.createElement('button');
            
                    commentidTd.innerText = data.commentID;
                    reviewTd.innerText = data.review;
                    dateTd.innerText = data.createdDate;
            
                    editbutton.classList = "btn btn-warning";
                    editbutton.innerText = 'Edit';
                    // deletebutton.classList = 'Delete';
                    // deletebutton.setAttribute("href", `http://localhost:8010/comment/delete/${commentID}`)
            
                    // deletebutton.addEventListener("click", (event) =>{
                    //     event.preventDefault();
                    //     deleteData(deleteButton.getAttribute("href"));
                    //     location.reload();
                    // });
            
                    // row.appendChild(rowTH);
                    row.appendChild(commentidTd);
                    row.appendChild(reviewTd);
                    row.appendChild(dateTd);
            
                    return row;  
                }
    window.onload = () => {
        
    const commentsContainer = document.querySelector("#commentsContainer");
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
                for (let i = 0; i<=data.length; i++){
                    // console.log(data[i]);
                    // console.log(data[i].review);
                    // let row = mycommentRow(data[i]);
                    // console.log(row);
                    // commentsContainer.appendChild(row);
                    commentsContainer.appendChild(mycommentRow(data[i]));
                }
            });
        })
                .catch(function (error) {
                console.log("Request failed", error);
                });
            }

