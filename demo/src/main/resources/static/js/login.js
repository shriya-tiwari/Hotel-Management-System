const wrapper = document.querySelector('.wrapper');
const loginLink = document.querySelector('.login-link');
const registerLink = document.querySelector('.register-link');

registerLink.addEventListener('click', ()=>{
    wrapper.classList.add('active');
});

loginLink.addEventListener('click', ()=>{
    wrapper.classList.remove('active');
});

document.getElementById('registrationForm').addEventListener('submit', function (e) {
    e.preventDefault();

    const firstName = document.getElementById('firstName').value;
    const lastName = document.getElementById('lastName').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const houseNo = document.getElementById('houseNo').value;
    const city = document.getElementById('city').value;
    const state = document.getElementById('state').value;
    const country = document.getElementById('country').value;
    const pinCode = document.getElementById('pinCode').value;
    const gender = document.getElementById('gender').value;
    const aadharCardNumber = document.getElementById('aadharCardNumber').value;

    const userData = {
        fName: firstName,
        lName: lastName,
        pEmail: email,
        password: password,
        houseNo: houseNo,
        city: city,
        state: state,
        country: country,
        pinCode: pinCode,
        gender: gender,
        aadhaarNo: aadharCardNumber
    };
    console.log(userData);

    axios.post('http://localhost:8080/register', userData)
        .then(function (response) {
            console.log(response.data);
            console.log(response.data.localeCompare('fail'));
            const i = response.data.localeCompare('fail');
            console.log(response);
            if (i === 0) {
                alert('User already exists!');
            } else {
                // Registration was successful; redirect to the login page
                window.location.href = '/login'; // Replace with the actual URL of your login page
            }
        })
        .catch(function (error) {
            console.error('There was an error!', error);
            alert('Invalid Input or Registration Failed!');
            // Handle navigation to an error page or other actions as needed
        });
    console.log("Sfs");
});

document.getElementById('loginForm').addEventListener('submit', function (e) {
    e.preventDefault();

    const email = document.getElementById('loginEmail').value;
    const password = document.getElementById('loginPassword').value;
    const rememberMe = document.getElementById('rememberMe').checked;

    const userData = {
        pEmail: email,
        password: password
    };

    axios.post('http://localhost:8080/login', userData)
        .then(function (response) {
            localStorage.setItem('token', response.data.token);
            console.log(response);
            console.log("ddd");
            // Check the response and redirect as needed
            if (response.status === 200) {
                window.location.href = '/dashboard';
            } else {
                alert('Login failed. Invalid Credentials.');
            }
        })
        .catch(function (error) {
            console.error('There was an error!', error);
            alert('Login failed. Please try again later.');
        });
});