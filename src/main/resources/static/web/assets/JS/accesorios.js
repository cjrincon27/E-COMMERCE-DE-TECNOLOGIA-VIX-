
const { createApp } = Vue
createApp({
  data() {
    return {
        accesorios:[],
        accesoriosFiltrados:[],
        accesoriosFiltradosPorMarca:[],
        accesoriosFiltradosPorTipo:[],
        accesoriosFiltradosPorPrecio:[],
        urlAccesorios:'/api/accessory',
        urlTipoDeAccesorios:'/api/accessory/type',
        tiposDeAccesorio:[],
        marcasDeAccesorios:[],
        precios:[],
        precioMinimo:'',
        precioMaximo:"",
        marcaSeleccionada:[],
        tipoSeleccionado:[],
        rangoDePrecio:"",
        buyer:'',
        urlCurrent:"/api/buyer/current",
        buscador:'',
      

   
    }
   
  },
  created() {
    this.obtenerAccesorios(this.urlAccesorios)
    this.clienteAutenticado(this.urlCurrent)
    
    this.obtenerTyposDeAccesorio(this.urlTipoDeAccesorios)

  },
  

  methods: {
    obtenerAccesorios(URL){
        axios.get(URL)
        .then(response => {
            this.accesorios= response.data
            this.accesoriosFiltrados = this.accesorios
            this.accesoriosFiltrados.forEach(accesorio => {
                if(!this.marcasDeAccesorios.includes(accesorio.brand)){
                    this.marcasDeAccesorios.push(accesorio.brand)
                }
                
            });
            this.accesoriosFiltrados.forEach(accesorio => {
                this.precios.push(accesorio.price)
            })
            this.precioMinimo = Math.min(...this.precios)
            this.precioMaximo = Math.max(...this.precios)

            console.log(this.precioMaximo);
            

        })
        
    },
    clienteAutenticado(URL){
        axios.get(URL)
        .then(response => {
          this.buyer = response.data
        
        })
  
      },
    obtenerTyposDeAccesorio(URL){
        axios.get(URL)
        .then(response => {
            this.tiposDeAccesorio= response.data
            console.log(response.data);
        })
    },
    agregarAlCarrito(id){
      if(this.buyer != 0){
        let variable1 =  this.accesoriosFiltrados.filter(accesorio => accesorio.id == id)
     
        console.log(variable1);
        let ticketAccessoryCart = {
          stocks:[1],
          accessoriesId:[id],
          color: variable1[0].accessoryImageAndColorDTOS[0].color
        }
        axios.post('/api/ticket/accessory/cart', ticketAccessoryCart)
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
    filtrarPorPalabra(){
        this.accesorios= this.accesoriosFiltrados
        if(this.buscador != ''){
          let filtro = this.accesorios.filter(accesorio => accesorio.brand.toLowerCase().includes(this.buscador.toLowerCase()) || accesorio.model.toLowerCase().includes(this.buscador.toLowerCase()))
          if(this.marcaSeleccionada != ''){
            filtro = filtro.filter(accesorio => this.marcaSeleccionada.includes(accesorio.brand))
        }
        if (this.rangoDePrecio != '') {

            filtro = filtro.filter(accesorio => accesorio.price < this.rangoDePrecio)
           }
           
           if(this.tipoSeleccionado != ''){

            filtro= filtro.filter(accesorio => this.tipoSeleccionado.includes(accesorio.type))
        }
  
            this.accesorios= filtro
  
          } 
        } ,
  
    
    filtroPortipo(){
    this.accesorios= this.accesoriosFiltrados
    if(this.tipoSeleccionado != ''){
        let filtroUno = this.accesorios.filter(accesorio => this.tipoSeleccionado.includes(accesorio.type))
        
        if (this.rangoDePrecio != '') {

            filtroUno = filtroUno.filter(accesorio => accesorio.price < this.rangoDePrecio)
           }
           if(this.marcaSeleccionada != ''){
            filtroUno = filtroUno.filter(accesorio => this.marcaSeleccionada.includes(accesorio.brand))
        }
        this.accesorios = filtroUno

    }


    },
    filtroPorMarca(){
        console.log(this.marcaSeleccionada);
        this.accesorios= this.accesoriosFiltrados
        
        if(this.marcaSeleccionada != ''){
            let filtroUno = this.accesorios.filter(accesorio => this.marcaSeleccionada.includes(accesorio.brand))
            if (this.rangoDePrecio != '') {

             filtroUno = filtroUno.filter(accesorio => accesorio.price < this.rangoDePrecio)
            }
            if(this.tipoSeleccionado != ''){

                filtroUno= filtroUno.filter(accesorio => this.tipoSeleccionado.includes(accesorio.type))
            }
            this.accesorios = filtroUno
    
        }
    
    
        },
        filtroPorPrecio(){
            this.accesorios= this.accesoriosFiltrados
           
        
            if (this.rangoDePrecio != '') {
                let filtroUno = this.accesorios.filter(accesorio => accesorio.price <  this.rangoDePrecio)
                if(this.tipoSeleccionado != ''){
                   filtroUno  = filtroUno.filter(accesorio => this.tipoSeleccionado.includes(accesorio.type))
                }
                if(this.marcaSeleccionada != ''){
                    filtroUno = filtroUno.filter(accesorio => this.marcaSeleccionada.includes(accesorio.brand))
                }
                this.accesorios = filtroUno
                
            }

        },
        

  }
}).mount('#app')