
const { createApp } = Vue
createApp({
  data() {
    return {
      buyer:'',
      urlCurrent:"/api/buyer/current",
      
        phones:[],
        phoneSeleccionado:[],
        propiedadesDelObjeto:[],
        valoresDelObjeto:[],
        coloresQueTiene:[],
        imagenesDelColorSeleccionado:[],
        primerImagenDelColorSeleccionado:'',
        urlPhone:'/api/phone',
        colorSeleccionado:'',
        stockSeleccionado:1,
    }
   
  },
  created() {

    this.obtenerPhones(this.urlPhone)
    this.clienteAutenticado(this.urlCurrent)
   

  },
  
  methods: {
 
    obtenerPhones(URL){
      axios.get(URL)
      .then(response => {
          this.phones= response.data
          const querystring = location.search
          const params = new URLSearchParams(querystring)
          const id = params.get("id")
          this.phoneSeleccionado = this.phones.find(item => item.id == id)
          this.coloresQueTiene = this.phoneSeleccionado.phoneImageAndColorDTOS
          this.imagenesDelColorSeleccionado =  this.coloresQueTiene[0] 
          this.primerImagenDelColorSeleccionado = this.imagenesDelColorSeleccionado.linkImage[0]
          console.log(this.coloresQueTiene);
          this.imagenesDelColorSeleccionado = this.imagenesDelColorSeleccionado.linkImage.filter(image => image != this.primerImagenDelColorSeleccionado)
     
       
         

      })
      
  },
  agregarAlCarrito(){
    if(this.buyer != 0){
    let ticketPhoneCart = {
      stocks:[this.stockSeleccionado],
      phonesId:[this.phoneSeleccionado.id],
      color:this.colorSeleccionado
    }
    axios.post('/api/ticket/phone/cart', ticketPhoneCart)
    Swal.fire({
      background:'#dc1d1d',
      color:'white',
      position: 'top-end',
      title: 'You have added a product to the cart',
      showConfirmButton: false,
      timer: 1500, 
    }).then(response => console.log(ticketPhoneCart))
  }else {
      Swal.fire({
        confirmButtonColor: "#dc1d1d",
        background: "#0a0a0a",
        color: "white",
        text: "You should SIGN IN or SIGN UP to continue",
      }).then(() => window.location.href="/web/login.html")
    }
  },
  clienteAutenticado(URL){
    axios.get(URL)
    .then(response => {
      this.buyer = response.data
    
    })

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
    cambiarColorSeleccionado(){
      if(this.colorSeleccionado != '' ){
        this.imagenesDelColorSeleccionado = this.coloresQueTiene.filter(acc => acc.phoneColor == this.colorSeleccionado)
        console.log(this.imagenesDelColorSeleccionado);
        this.primerImagenDelColorSeleccionado = this.imagenesDelColorSeleccionado[0].linkImage[0]
      
      this.imagenesDelColorSeleccionado = this.imagenesDelColorSeleccionado[0].linkImage.filter(image => image != this.primerImagenDelColorSeleccionado)
      }
    }

   

  }
}).mount('#app')