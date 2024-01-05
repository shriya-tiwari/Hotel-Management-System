function validateDates() {
    const checkInDate = document.getElementById("checkInDate").value;
    const checkOutDate = document.getElementById("checkOutDate").value;
    const today = new Date();
    console.log(checkInDate);
    if (checkInDate >= checkOutDate || checkInDate < today) {
        alert("Invalid date selection. Please check your dates.");
        return false;
    }

    return true;
}

function checkAvailability() {
    const checkInDate = document.getElementById("checkInDate").value;
    const checkOutDate = document.getElementById("checkOutDate").value;
    const roomType = document.getElementById("roomType").value;
    const numOfGuests = document.getElementById("numOfGuests").value;
    const n = parseInt(numOfGuests, 10)
    console.log(n);
    console.log(typeof(roomType));
    console.log(typeof(n));
    if(validateDates()) {
        const apiUrl = 'http://localhost:8080/dashboard/check';
        const data = {
            checkInDate: checkInDate,
            checkOutDate: checkOutDate,
            roomType: roomType,
            noOfGuests: n,
        };

        axios.post(apiUrl, data, { headers: { Authorization: `Bearer ${localStorage.getItem('token')}`}})
          .then((response) => {
                console.log(response);
                if(response) {
                    alert("The required rooms are available! Please click on Book Now to confirm your booking.")
                }
                else {
                    alert("Sorry! The rooms you require are currently not available.")
                }
          })
          .catch((error) => {
            console.error('Error fetching user profile data:', error);
          });
    }
}

function bookNow() {
    const checkInDate = document.getElementById("checkInDate").value;
    const checkOutDate = document.getElementById("checkOutDate").value;
    const roomType = document.getElementById("roomType").value;
    const numOfGuests = document.getElementById("numOfGuests").value;
    const n = parseInt(numOfGuests, 10)
    console.log(n);
    console.log(typeof(n));

    const apiUrl = 'http://localhost:8080/dashboard/book';
    const data = {
        checkInDate: checkInDate,
        checkOutDate: checkOutDate,
        roomType: roomType,
        noOfGuests: n,
    };

    axios.post(apiUrl, data, { headers: { Authorization: `Bearer ${localStorage.getItem('token')}`}})
      .then((response) => {
            alert("Booking done");
            window.location.reload();
      })
      .catch((error) => {
        alert("Some error occurred!! Please try again later");
        console.error('Error fetching user profile data:', error);
      });
}

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