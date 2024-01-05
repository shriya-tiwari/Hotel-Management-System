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