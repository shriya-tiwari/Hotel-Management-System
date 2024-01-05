function edit(field) {
    const inputElement = document.getElementById(field);
    const editButton = inputElement.nextElementSibling;
    const saveButton = editButton.nextElementSibling;

    // Make the input field editable
    inputElement.removeAttribute('readonly');

    // For the "Gender" field, change the <select> to a dropdown
    if (field === 'gender') {
        const selectElement = document.getElementById('gender');
        selectElement.removeAttribute('readonly');
    }
    if (field === 'password') {
        const passwordInput = document.getElementById('password');
        passwordInput.type = 'text';
    }

    // Hide the "Edit" button and show the "Save" button
    editButton.classList.add('hidden');
    saveButton.classList.remove('hidden');
}

function save(field) {
    const inputElement = document.getElementById(field);
    const editButton = inputElement.nextElementSibling;
    const saveButton = editButton.nextElementSibling;
    const updatedValue = document.getElementById(field).value;

    const apiUrl = 'http://localhost:8080/editProfile';

    const data = {
        attributeName: field,
        attributeValue: updatedValue
    }

    axios.put(apiUrl, data, {
        headers: {
            Authorization: `Bearer ${localStorage.getItem('token')}`
        }
    })
            .then(response => {
                console.log(response);
                alert('`${field}`  updated successfully');
            })
            .catch(error => {
                console.error('Error updating name:', error);
                alert('Failed to update name. Please try again.');
            });

    // Make the input field read-only
    inputElement.setAttribute('readonly', true);

    // For the "Gender" field, make the <select> read-only
    if (field === 'gender') {
        const selectElement = document.getElementById('gender');
        selectElement.setAttribute('readonly', true);
    }

    // Hide the "Save" button and show the "Edit" button
    editButton.classList.remove('hidden');
    saveButton.classList.add('hidden');
}

function changePassword() {
    const nPass = document.getElementById("n_pass").value;
    const cPass = document.getElementById("c_pass").value;

    if(cPass !== nPass) {
        alert("Passwords do not match.");
    }
    else {
        const apiUrl = 'http://localhost:8080/changePassword';
        const data = {
            newPassword: cPass
        }
            axios.put(apiUrl, data, {
                headers: {
                    Authorization: `Bearer ${localStorage.getItem('token')}`
                }
            })
                    .then(response => {
                        console.log(response);
                        alert('Password updated successfully');
                    })
                    .catch(error => {
                        console.error('Error updating name:', error);
                        alert('Failed to update name. Please try again.');
                    });
    }

}

function fetchUserProfile() {
    const apiUrl = 'http://localhost:8080/getProfile';

    axios.get(apiUrl, {
        headers: {
            Authorization: `Bearer ${localStorage.getItem('token')}`
        }
    })
      .then((response) => {
        console.log(response);
        const userData = response.data;
        document.getElementById('fName').value = userData.fName;
        document.getElementById('lName').value = userData.lName;
        document.getElementById('pEmail').value = userData.pEmail;
        document.getElementById('houseNo').value = userData.houseNo;
        document.getElementById('state').value = userData.state;
        document.getElementById('city').value = userData.city;
        document.getElementById('country').value = userData.country;
        document.getElementById('pinCode').value = userData.pinCode;
        document.getElementById('gender').value = userData.gender;
        document.getElementById('aadhaarNo').value = userData.aadhaarNo;
      })
      .catch((error) => {
        console.error('Error fetching user profile data:', error);
      });
  }

window.addEventListener('load', fetchUserProfile);

function logOutUser() {
        localStorage.removeItem('token');
        axios
            .get('http://localhost:8080/logout')
            .then((response) => {
              console.log('User logged out successfully');
              window.location.href = '/login';
            })
            .catch((error) => {
              console.error('Error logging out:', error);
            });
    }