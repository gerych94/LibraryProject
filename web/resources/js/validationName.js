/**
 * Created by Vitaliy on 25.06.2017.
 */
function validateform() {
    var name = document.username.username.value;
    if (name == null || name == "") {
        alert("Name can't be blank");
        return false;
    } else if (name.length < 5) {
        alert("Name must be at least 6 characters long.");
        return false;
    } else if (name == "username" || name == "login"){
         alert("Name can't be "+name)
        return false
    } else if(/\d/.test(name)){
        alert("Name can't contains number")
        return false;
    }
return true;
}

