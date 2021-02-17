function updateForm() {

    var form = document.getElementById('formArticle');
    if(form) {
        form.action = 'Update.test';
    }


    var articleID = document.getElementById('articleID').value;
    var articlePrice = document.getElementById('articlePrice').innerHTML;
    var articleName = document.getElementById('articleName').innerHTML;
    var articleQTE = document.getElementById('articleQTE').value;
    var articleDesc = document.getElementById('articleDesc').value;

    document.getElementById('updateID').value = articleID;
    document.getElementById('updatePRICE').value = articlePrice;
    document.getElementById('updateName').value = articleName;
    document.getElementById('updateQTE').value = articleQTE;
    document.getElementById('updateDESC').value = articleDesc;

   // document.getElementById('updateQTE').value = articleQTE;
   // document.getElementById('articleQTE').value = articleQTE;


    //document.getElementById('updatePRICE').value = articleName;

    //updateID
    //updateARTICLE
}

function insertForm() {

    var form = document.getElementById('formArticle');
    if(form) {
        form.action = 'Ajouter.test';
    }
}