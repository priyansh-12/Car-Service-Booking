/**
 * 
 */
 
 




document.querySelector('form').addEventListener('submit', function(event) {
    var name = document.querySelector('input[name="name"]').value;
    var email = document.querySelector('input[name="email"]').value;
    var age = document.querySelector('input[name="age"]').value;
    var username = document.querySelector('input[name="username"]').value;
    var password = document.querySelector('input[name="password"]').value;
    var state = document.querySelector('input[name="state"]').value;
    var town = document.querySelector('input[name="town"]').value;
    var office = document.querySelector('input[name="office"]').value;
    var gender = document.querySelector('select').value;

    // Validate age
    if (age < 18) {
        alert('Age must be 18 or older.');
        event.preventDefault();
        return;
    }

    // Validate username (only alphabet and number)
    var usernameRegex = /^[a-zA-Z0-9]+$/;
    if (!username.match(usernameRegex)) {
        alert('Username must contain only alphabets and numbers.');
        event.preventDefault();
        return;
    }

    // Validate password (min length 5, alphabet, number, and special symbol)
    var passwordRegex = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{5,}$/;
    if (!password.match(passwordRegex)) {
        alert('Password must be at least 5 characters long and contain at least one alphabet, one number, and one special symbol.');
        event.preventDefault();
        return;
    }

    // Validate state, town, office, and name (only alphabets)
    //var nameRegex = /^[a-zA-Z]+/;
    //if (!state.match(nameRegex) || !town.match(nameRegex) || !office.match(nameRegex) || !name.match(nameRegex)) {
     //   alert('State, Town, RTO office, and Name must contain only alphabets.');
     //   event.preventDefault();
      //  return;
    //} 
});
