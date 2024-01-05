function formatDate(date) {
  const day = String(date.getDate()).padStart(2, '0');
  const month = String(date.getMonth() + 1).padStart(2, '0');
  const year = date.getFullYear();

  return `${day}-${month}-${year}`;
}

function fetchBookings() {
    const apiUrl = "http://localhost:8080/getBookings";
    axios.get(apiUrl, {
            headers: {
                Authorization: `Bearer ${localStorage.getItem('token')}`
            }
        })
        .then((response) => {
//            console.log(response);
            const data = response.data;
//            console.log(data.length)


            const choices = document.getElementById('bookingNo');
            choices.innerHTML = '';
            data.forEach((booking, index) => {

                const inDate = new Date(booking.getCheckInDate);
                const outDate = new Date(booking.getCheckOutDate);

                const checkInDate = formatDate(inDate);
                const checkOutDate = formatDate(outDate);

                const option = document.createElement('option');
                option.value = booking.getBookingID;
                option.innerHTML = `Booking ${index + 1}`;
                choices.appendChild(option);
            })
        })
        .catch(error => {
           console.error('Error fetching data: ', error);
       });
}

window.addEventListener('load', fetchBookings());

function getBill() {
    const bookingSelect = document.getElementById("bookingNo");
    const selectedBookingID = bookingSelect.value; // Get the selected booking ID

    // Make an API call to fetch booking details
    const apiUrl = "http://localhost:8080/getBill";

    const data = {
        bookingID: selectedBookingID
    }
    console.log(selectedBookingID);
    axios.post(apiUrl, data, {
            headers: {
                Authorization: `Bearer ${localStorage.getItem('token')}`
            }
        })
        .then(response => {
            const data = response.data;
            console.log(data);
            // Populate the HTML elements with   the retrieved data

            const inDate = new Date(data.checkInDate);
            const outDate = new Date(data.checkOutDate);

            const checkInDate = formatDate(inDate);
            const checkOutDate = formatDate(outDate);

            document.getElementById("bookingId").textContent = data.bookingID;
            document.getElementById("checkInDate").textContent = checkInDate;
            document.getElementById("checkOutDate").textContent = checkOutDate;
            document.getElementById("cost").textContent = data.cost;
            document.getElementById("typeName").textContent = data.typeName;

            const ulElement = document.getElementById("stringList");
            ulElement.innerHTML = '';

            data.services.forEach((str) => {
                const liElement = document.createElement("li");
                liElement.textContent = str;
                ulElement.appendChild(liElement);
            });

            const checkinDate = new Date(data.checkInDate);
            const checkoutDate = new Date(data.checkOutDate);
            const timeDiff = checkoutDate.getTime() - checkinDate.getTime();
            console.log(timeDiff);
            const numNights = Math.ceil(timeDiff / (1000 * 3600 * 24));

            document.getElementById('numNights').textContent = numNights;

        })
        .catch(error => {
            console.error("Error fetching booking details:", error);
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


