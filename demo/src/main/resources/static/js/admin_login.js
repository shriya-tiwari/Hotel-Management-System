document.getElementById('loginForm').addEventListener('submit', function (e) {
    e.preventDefault();

    const email = document.getElementById('loginEmail').value;
    const password = document.getElementById('loginPassword').value;

    const userData = {
        emailID: email,
        password: password
    };

    axios.post('http://localhost:8080/admin-login', userData)
        .then(function (response) {
            localStorage.setItem('token', response.data.token);
            console.log(response);
            console.log("ddd");
            // Check the response and redirect as needed
            if (response.status === 200) {
                window.location.href = '/admin';
            } else {
                alert('Login failed. Invalid Credentials.');
            }
        })
        .catch(function (error) {
            console.error('There was an error!', error);
            alert('Login failed. Please try again later.');
        });
});