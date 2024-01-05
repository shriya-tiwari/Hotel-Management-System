document.getElementById('employeeForm').addEventListener('submit', function (e) {
    e.preventDefault();

    const firstName = document.getElementById('fName').value;
    const lastName = document.getElementById('lName').value;
    const pEmail = document.getElementById('pEmail').value;
    const houseNo = document.getElementById('houseNo').value;
    const city = document.getElementById('city').value;
    const state = document.getElementById('state').value;
    const country = document.getElementById('country').value;
    const pincode = document.getElementById('pincode').value;
    const gender = document.getElementById('gender').value;
    const aadhaarNo = document.getElementById('aadhaarNo').value;
    const salary = document.getElementById('salary').value;
    const role = document.getElementById('role').value;
    const accountNo = document.getElementById('accountNo').value;
    const IFSCCode = document.getElementById('IFSCCode').value;
    const loan = document.getElementById('loan').value;
    const loanDetails = document.getElementById('loanDetails').value;
    const bankName = document.getElementById('bankName').value;

    const userData = {
        fName: firstName,
        lName: lastName,
        pEmail: pEmail,
        houseNo: houseNo,
        city: city,
        state: state,
        country: country,
        pincode: pincode,
        gender: gender,
        aadhaarNo: aadhaarNo,
        salary: salary,
        loan: loan,
        loanDetails: loanDetails,
        IFSCCode: IFSCCode,
        role: role,
        accountNo: accountNo,
        bankName: bankName
    };
    console.log(userData);

    axios.post('http://localhost:8080/admin/addEmployee', userData)
        .then(function (response) {
            console.log(response.data);
            console.log(response.data.localeCompare('fail'));
            const i = response.data.localeCompare('fail');
            console.log(response);
            if (i === 0) {
                alert('Employee already exists!');
            } else {
                // Registration was successful; redirect to the login page
                window.location.href = '/admin/allEmployees'; // Replace with the actual URL of your login page
            }
        })
        .catch(function (error) {
            console.error('There was an error!', error);
            alert('Invalid Input or Registration Failed!');
            // Handle navigation to an error page or other actions as needed
        });
    console.log("Sfs");
});