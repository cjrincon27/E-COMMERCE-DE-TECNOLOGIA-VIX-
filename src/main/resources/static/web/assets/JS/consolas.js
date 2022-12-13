
const { createApp } = Vue
createApp({
  data() {
    return {
        consolas:[],
        urlConsolas:'/api/console',
        buyer:'',
        urlCurrent:"/api/buyer/current",

   
    }
   
  },
  created() {
    this.obtenerConsolas(this.urlConsolas)
    this.clienteAutenticado(this.urlCurrent)

  },
  

  methods: {
    obtenerConsolas(URL){
        axios.get(URL)
        .then(response => {
            this.consolas= response.data
            console.log(this.consolas);

        })
        .catch((error) => {
          this.error = error.response.data;
          console.log(error);
          if (this.error == "buyerCurrent is null") {
            Swal.fire({
              confirmButtonColor: "#1bb5db",
              background: "#212121",
              color: "white",
              text: "No authenticated buyer",
            });
          } if (this.error == "stock is equal to 0") {
            Swal.fire({
              confirmButtonColor: "#1bb5db",
              background: "#212121",
              color: "white",
              text: "Stock is equal to 0",
            });
          }if (this.error == "brand is empty") {
            Swal.fire({
              confirmButtonColor: "#1bb5db",
              background: "#212121",
              color: "white",
              text: "You have to choose a brand",
            });
          }if (this.error == "model is empty") {
            Swal.fire({
              confirmButtonColor: "#1bb5db",
              background: "#212121",
              color: "white",
              text: "You have to choose a model",
            });
          }if (this.error == "ram is empty") {
            Swal.fire({
              confirmButtonColor: "#1bb5db",
              background: "#212121",
              color: "white",
              text: "You have to choose a RAM",
            });
          }if (this.error == "rom is empty") {
            Swal.fire({
              confirmButtonColor: "#1bb5db",
              background: "#212121",
              color: "white",
              text: "You have to choose a ROM",
            });
          }if (this.error == "controls is empty") {
            Swal.fire({
              confirmButtonColor: "#1bb5db",
              background: "#212121",
              color: "white",
              text: "Controls is empty",
            });
          } if (this.error == "price is equal to 0") {
            Swal.fire({
              confirmButtonColor: "#1bb5db",
              background: "#212121",
              color: "white",
              text: "Price is equal to 0",
            });
          } if (this.error == "images size is equal to 0") {
            Swal.fire({
              confirmButtonColor: "#1bb5db",
              background: "#212121",
              color: "white",
              text: "Images size is equal to 0",
            });
          } if (this.error == "description is empty") {
            Swal.fire({
              confirmButtonColor: "#1bb5db",
              background: "#212121",
              color: "white",
              text: "Description is empty",
            });
          } 
        })
    },
    clienteAutenticado(URL){
      axios.get(URL)
      .then(response => {
        this.buyer = response.data
        console.log(this.buyer);
      })

    },
    agregarAlCarrito(id){
      if(this.buyer != 0){
      let ticketConsoleCart = {
        stocks:[1],
        consolesId:[id]
      }
      axios.post('/api/ticket/console/cart', ticketConsoleCart)
      Swal.fire({
        background:'#dc1d1d',
        color:'white',
        position: 'top-end',
        title: 'You have added a product to the cart',
        showConfirmButton: false,
        timer: 1500
      }).then(response => console.log('supuestamente anda'))
    } else {
      Swal.fire({
        confirmButtonColor: "#dc1d1d",
        background: "#0a0a0a",
        color: "white",
        text: "You should SIGN IN or SIGN UP to continue",
      }).then(() => window.location.href="/web/login.html")
    } 
    },
   
    logOut(){
      const swalWithBootstrapButtons = Swal.mixin({
          customClass: {
            confirmButton: '#212121',
            // cancelButton: '#212121'
          },
          buttonsStyling: true
        })
         swalWithBootstrapButtons.fire({
          background:'#dc1d1d',
          color:'white',
          title: 'Would you like to log out?',
         showCancelButton: false,
          confirmButtonColor: '#0a0a0a',
          confirmButtonText: 'Yes', 
          // cancelButtonText: 'No',
          reverseButtons: true
        }).then((result) => {
        if (result.isConfirmed) {
              Swal.fire({
                background:'#dc1d1d',
                  color:'white',
                  position: 'top-center',
                  title: 'You have logged out',
                  showConfirmButton: false,
                  timer: 10500
                })
              axios.post('/api/logout').then(response =>  window.location.href = '/index.html')
          }
        })
   },
    

  },
  computed:{

  }
}).mount('#app')