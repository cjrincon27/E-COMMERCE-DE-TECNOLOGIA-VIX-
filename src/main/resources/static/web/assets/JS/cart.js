
const { createApp } = Vue
createApp({
  data() {
    return {
      buyer:'',
      cardNumber:'',
      Cvv:'',
      ticketsPhone:'',
      ticketsConsola:[],
      ticketsAcc:[],
      precioFinal:'',
      urlCurrent:"/api/buyer/current",
      colorAccSeleccionado:'',
      colorPhoneSeleccionado:'',


    }
   
  },
  created() {
   
      this.clienteAutenticado(this.urlCurrent)
    
  },
  
  methods: {
    clienteAutenticado(URL){
      axios.get(URL)
      .then(response => {
        this.buyer = response.data
        console.log(this.buyer);
        
        if(this.buyer.shoppingCart.ticketPhone_carts.length != 0){

            this.ticketsPhone = this.buyer.shoppingCart.ticketPhone_carts
        }

    if(this.buyer.shoppingCart.ticketConsole_carts.length != 0){

            this.ticketsConsola = this.buyer.shoppingCart.ticketConsole_carts
        } 
        if(this.buyer.shoppingCart.ticketAccessory_carts.length != 0){

            this.ticketsAcc = this.buyer.shoppingCart.ticketAccessory_carts
        }
        let arrayDePrecios = [];
        if(this.buyer.shoppingCart.ticketPhone_carts.length != 0){

            this.ticketsPhone.forEach(ticket => {
              arrayDePrecios.push(ticket.ticket_phoneDTO.phoneDTO.price * ticket.ticket_phoneDTO.stock)  
            });
        }
        if(this.buyer.shoppingCart.ticketConsole_carts.length != 0){

            this.ticketsConsola.forEach(ticket => {
                arrayDePrecios.push(ticket.ticket_consoleDTO.consoleIdDTO.price *  ticket.ticket_consoleDTO.stock)  
            });
        }
        if(this.buyer.shoppingCart.ticketAccessory_carts.length != 0){

            this.ticketsAcc.forEach(ticket => {
                arrayDePrecios.push(ticket.ticket_accesoryDTO.accessoryDTO.price * ticket.ticket_accesoryDTO.stock)  
            });
        }
      
        this.precioFinal = arrayDePrecios.reduce((a, b) => a + b, 0)
     
    
          
      })

    },
    realizarCompra(){  

        let pagoDTO = {
          cardNumber: this.cardNumber,
          cvv: this.Cvv,
          amount: this.precioFinal,
          description:"Your purchase in Vix"
        }
        axios.post('http://localhost:8080/api/clients/current/accounts/transaction/pago', pagoDTO ).then(response => console.log("pay realizado"));
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
          title: 'Your purchase has been successful',
         showCancelButton: false,
          confirmButtonColor: '#0a0a0a',
          confirmButtonText: 'Ok', 
          // cancelButtonText: 'No',
          reverseButtons: true
        })
        .then((result) => {
          if (result.isConfirmed) {
            axios.post('/api/buyer/ticket').then(() => console.log('realizado'));
            axios.put('/api/cart').then(() => window.location.reload())
          }
        })
        .catch(error => console.log(error.data))   
       
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

  aumentarStock(id){
    let stockDePhone = document.getElementById('stock'+id)
    if(parseInt(stockDePhone.value) < parseInt(stockDePhone.max)){
        stockDePhone.value = parseInt(stockDePhone.value) + 1
        axios.patch('/api/ticket/phone/cart', 'idTicketPhone_Cart=' + id + '&stock='+ parseInt(stockDePhone.value)).then(response => console.log('stock cambiado'))
        this.clienteAutenticado(this.urlCurrent)
    }

},
restarStock(id){
    let stockDePhone = document.getElementById('stock'+id)
    if(parseInt(stockDePhone.value) > 1){
        stockDePhone.value = parseInt(stockDePhone.value) - 1
        axios.patch('/api/ticket/phone/cart', 'idTicketPhone_Cart=' + id + '&stock='+ parseInt(stockDePhone.value)).then(response => console.log('stock cambiado'))
        this.clienteAutenticado(this.urlCurrent)
    }
},
aumentarStockConsola(id){
    let stockDePhone = document.getElementById('stockConsola'+id)
    if(parseInt(stockDePhone.value) < parseInt(stockDePhone.max)){
        stockDePhone.value = parseInt(stockDePhone.value) + 1
        axios.patch('/api/ticket/console/cart', 'idTicketConsole_Cart=' + id + '&stock='+ parseInt(stockDePhone.value)).then(response => console.log('stock cambiado'))
        this.clienteAutenticado(this.urlCurrent)
    }

},
restarStockConsola(id){
    let stockDePhone = document.getElementById('stockConsola'+id)
    if(parseInt(stockDePhone.value) > 1){
        stockDePhone.value = parseInt(stockDePhone.value) - 1
        axios.patch('/api/ticket/console/cart', 'idTicketConsole_Cart=' + id + '&stock='+ parseInt(stockDePhone.value)).then(response => console.log('stock cambiado'))
        this.clienteAutenticado(this.urlCurrent)
    }
},
aumentarStockAcc(id){
    let stockDePhone = document.getElementById('stockAcc'+id)
    if(parseInt(stockDePhone.value) < parseInt(stockDePhone.max)){
        stockDePhone.value = parseInt(stockDePhone.value) + 1
        axios.patch('/api/ticket/accessory/cart', 'idTicketAccessory_Cart=' + id + '&stock='+ parseInt(stockDePhone.value)).then(response => console.log('stock cambiado'))
        this.clienteAutenticado(this.urlCurrent)
    }

},
restarStockAcc(id){
    let stockDePhone = document.getElementById('stockAcc'+id)
    if(parseInt(stockDePhone.value) > 1){
        stockDePhone.value = parseInt(stockDePhone.value) - 1
        axios.patch('/api/ticket/accessory/cart', 'idTicketAccessory_Cart=' + id + '&stock='+ parseInt(stockDePhone.value)).then(response => console.log('stock cambiado'))
        this.clienteAutenticado(this.urlCurrent)
    }
},
borrarPhone(id){
  axios.patch('/api/ticket/phone/cart/delete', 'ticketPhoneCartId=' + id).then(() => window.location.reload()).catch(error => console.log(error.data));
},
borrarConsola(id){
  axios.patch('/api/ticket/console/cart/delete', 'ticketConsoleCartId=' + id).then(() => window.location.reload()).catch(error => console.log(error.data));
},
borrarAcc(id){
  axios.patch('/api/ticket/accessory/cart/delete', 'ticketAccessoryCartId=' + id).then(() => window.location.reload()).catch(error => console.log(error.data));
  
}




  },
  computed:{

   

  }
}).mount('#app')