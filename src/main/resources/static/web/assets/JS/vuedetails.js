
const { createApp } = Vue
createApp({
  data() {
    return {
        accesorios:[],
        accesorioSeleccionado: [],
        buyer:'',
        urlCurrent:"/api/buyer/current",
       
        propiedadesDelObjeto:[],
        valoresDelObjeto:[],
        coloresQueTiene:[],
        imagenesDelColorSeleccionado:[],
        primerImagenDelColorSeleccionado:'',
        urlAccesorios:'/api/accessory',
        urlPhone:'/api/phones',
        colorSeleccionado:'',
        stockSeleccionado:1,
    }
   
  },
  created() {
  this.obtenerAccesorios(this.urlAccesorios) 
  this.clienteAutenticado(this.urlCurrent)


  },
  

  methods: {
    obtenerAccesorios(URL){
        axios.get(URL)
        .then(response => {
            this.accesorios= response.data
            const querystring = location.search
            const params = new URLSearchParams(querystring)
            const id = params.get("id")
            this.accesorioSeleccionado = this.accesorios.find(item => item.id == id)
            this.coloresQueTiene = this.accesorioSeleccionado.accessoryImageAndColorDTOS
            this.imagenesDelColorSeleccionado =  this.coloresQueTiene[0] 
            /* console.log(this.imagenesDelColorSeleccionado); */
            this.primerImagenDelColorSeleccionado = this.imagenesDelColorSeleccionado.linksImages[0]
            this.imagenesDelColorSeleccionado = this.imagenesDelColorSeleccionado.linksImages.filter(image => image != this.primerImagenDelColorSeleccionado)
            /* this.propiedadesDelObjeto=Object.keys(this.accesorioSeleccionado)
            this.valoresDelObjeto = Object.values(this.accesorioSeleccionado) */
            console.log(this.imagenesDelColorSeleccionado);
           
  
        })
        
    },
    clienteAutenticado(URL){
      axios.get(URL)
      .then(response => {
        this.buyer = response.data
      
      })

    },

  agregarAlCarrito(){
    if(this.buyer != 0){
    let ticketAccessoryCart = {
      stocks:[this.stockSeleccionado],
      accessoriesId:[this.accesorioSeleccionado.id],
      color:this.colorSeleccionado
    }
    axios.post('/api/ticket/accessory/cart', ticketAccessoryCart)
    Swal.fire({
      background:'#dc1d1d',
      color:'white',
      position: 'top-end',
      title: 'You have added a product to the cart',
      showConfirmButton: false,
      timer: 1500, 
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
    cambiarColorSeleccionado(){
      if(this.colorSeleccionado != '' ){
        this.imagenesDelColorSeleccionado = this.coloresQueTiene.filter(acc => acc.color == this.colorSeleccionado)
        this.primerImagenDelColorSeleccionado = this.imagenesDelColorSeleccionado[0].linksImages[0]
        console.log(this.primerImagenDelColorSeleccionado);
        console.log(this.imagenesDelColorSeleccionado);
      this.imagenesDelColorSeleccionado = this.imagenesDelColorSeleccionado[0].linksImages.filter(image => image != this.primerImagenDelColorSeleccionado)
      }
    }

   

  }
}).mount('#app')