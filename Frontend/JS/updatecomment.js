document
  .getElementById("updateform")
  .addEventListener("submit", function (event) {
    event.preventDefault();

    const data = {
        "review": this.review_box2.value
      }
      fetch("http://localhost:8010/comment/edit/${data.commentID}", {
        method: "POST",
        headers: {
          "Content-type": " application/json;",
        },
        body: JSON.stringify(data),
      })
        .then(response => response.json())
        .then(function (data) {
          console.log("Request succeeded with JSON response", data);
        })
        .catch(function (error) {
          console.log("Request failed", error);
        });
    }























































let down = document.getElementById("myeditbutton"); 
function showForm() {
    
    let form = document.createElement("form"); 
    form.setAttribute("method", "PUT"); 
    form.setAttribute("action", "submit"); 

    let reviewform = document.createElement("input"); 
    reviewform.setAttribute("type", "text"); 
    reviewform.setAttribute("name", "UpdateComment"); 
    reviewform.setAttribute("placeholder", "Update Comment");

    let s = document.createElement("input"); 
    s.setAttribute("type", "submit"); 
    s.setAttribute("value", "SUBMIT");
    s.setAttribute("href", `http://localhost:8010/comment/edit/${data.commentID}`)

    form.appendChild(reviewform);
    form.appendChild(s);
    document.getElementsByTagName("body")[0].appendChild(form); 
    return form;
}



























// editbutton.setAttribute('id', 'myeditbutton')  
//                     // editbutton.addEventListener("onClick", "updateCommentForm()");  
//                     editbutton.classList = "btn btn-outline-warning";
//                     editbutton.innerText = 'Edit';

//                     let linktobtn = document.getElementById("myeditbutton");
//                     // editbutton.setAttribute("href", `http://localhost:8010/comment/edit/${data.commentID}`);
//                     editbutton.setAttribute("onClick", (event) => {
//                         event.preventDefault();
//                         updateCommentForm()
//                         location.reload();
//                       });
// function update(){
//     document.getElementById("myeditbutton")
//     editbutton.addEventListener("click", (event) => {
//         event.preventDefault();
//         function myFunction() {
//             let x = document.getElementById("commentForm");
//             if (x.style.display === "none") {
//               x.style.display = "block";
//             } else {
//               x.style.display = "none";
//             }
//         }

// }
// function updateCommentForm() {
//     let editform = document.createElement("form"); 
//     editform.setAttribute("method", "PUT"); 
//     editform.setAttribute("action", "submit"); 

//     let reviewform = document.createElement("input"); 
//     reviewform.setAttribute("type", "text"); 
//     reviewform.setAttribute("name", "UpdateComment"); 
//     reviewform.setAttribute("placeholder", "Update Comment");

//     editform.appendChild(br.cloneNode());

//     let s = document.createElement("input"); 
//     s.setAttribute("type", "submit"); 
//     s.setAttribute("value", "Update Comment");
//     s.setAttribute("href", `http://localhost:8010/comment/edit/${data.commentID}`)

//     editform.appendChild(reviewform);
//     editform.appendChild(s);
// }

// document
//   .getElementById("commentForm")
//   .addEventListener("submit", function (event) {
//     event.preventDefault();
  
//     const data = {
//       "review": this.review_box.value
//     }

//     document.querySelector('form').reset();
//     //comment

//     fetch("http://localhost:8010/comment/update/", {
//       method: "PUT",
//       headers: {
//         "Content-type": " application/json;",
//       },
//       body: JSON.stringify(data),
//     })
//       .then(response => response.json())
//       .then(function (data) {
//         console.log("Request succeeded with JSON response", data);
//       })
//       .catch(function (error) {
//         console.log("Request failed", error);
//       });

