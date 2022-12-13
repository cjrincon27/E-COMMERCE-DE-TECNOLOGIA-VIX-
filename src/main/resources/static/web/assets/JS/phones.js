const { createApp } = Vue
createApp({
  data() {
    return {
      phones:[],
      phonesCompletos:[],
      marcas:[],
      modelos:[],
      ram:[],
      procesador:[],
      color:[],
      marcaSeleccionada:[],
      modeloSeleccionado:[],
      urlPhones:'/api/phone',
      precios:[],
      precioMinimo:'',
      precioMaximo:'',
      rangoDePrecio:'',
      ramSeleccionada:[],
      procesadorSeleccionado:[],
      colorSeleccionado:[],
      buscador:'',
      buyer:'',
      urlCurrent:"/api/buyer/current",
      error: "",


   
    }
   
  },
  created() {
    this.obtenerPhones(this.urlPhones)
    this.clienteAutenticado(this.urlCurrent)
    

  },

  methods: {
    obtenerPhones(URL){
      axios.get(URL)
      .then(response => {
          this.phones= response.data
          this.phonesCompletos = this.phones
          this.phones.forEach(phone => {           
            if(!this.marcas.includes(phone.brand)){
              this.marcas.push(phone.brand)};
            this.precios.push(phone.price);
            if(!this.modelos.includes(phone.model)){
            this.modelos.push(phone.model)};
           phone.ram.forEach(ram => {
             if(!this.ram.includes(ram)){
              this.ram.push(ram)
             }
           });
           if(!this.procesador.includes(phone.processor)){
            this.procesador.push(phone.processor)
           }
           phone.phoneImageAndColorDTOS.forEach(color =>{
            if(!this.color.includes(color.phoneColor)){
              this.color.push(color.phoneColor)
            }

           })
       
        })
          console.log(this.color);
          this.precioMinimo = Math.min(...this.precios)
          this.precioMaximo = Math.max(...this.precios)
         
        })
  
        
          },
          clienteAutenticado(URL){
            axios.get(URL)
            .then(response => {
              this.buyer = response.data
            
            })
      
          },
          agregarAlCarrito(id){
         if(this.buyer != 0){
            let variable1 = this.phonesCompletos.filter(phone => phone.id == id)
            console.log(variable1);
            let ticketPhoneCart = {
              stocks:[1],
              phonesId:[id],
              color: variable1[0].phoneImageAndColorDTOS[0].phoneColor
            }
            axios.post('/api/ticket/phone/cart', ticketPhoneCart)
            Swal.fire({
              background:'#dc1d1d',
              color:'white',
              position: 'top-end',
              title: 'You have added a product to the cart',
              showConfirmButton: false,
              timer: 1500, 
            }).then(response => console.log('supuestamente anda'))
            }else {
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
      this.phones = this.phonesCompletos
      if(this.buscador != ''){
        let filtro = this.phones.filter(phone => phone.brand.toLowerCase().includes(this.buscador.toLowerCase()) || phone.model.toLowerCase().includes(this.buscador.toLowerCase()))
        if(this.modeloSeleccionado != ''){
          filtro = this.phones.filter(phone => this.modeloSeleccionado.includes(phone.model))
         }
         if(this.procesadorSeleccionado != ''){
          filtro = this.phones.filter(phone => this.procesadorSeleccionado.includes(phone.processor))}
          if (this.rangoDePrecio != '') {
            filtro = filtro.filter(phone => phone.price < this.rangoDePrecio) }
         
          if(this.marcaSeleccionada != ''){
            filtro = filtro.filter(phone => this.marcaSeleccionada.includes(phone.brand))
          }

          this.phones= filtro

        } 

    },
    filtrarPhonesPorMarca(){
      this.phones = this.phonesCompletos

      if(this.marcaSeleccionada !=''){
         let filtro = this.phones.filter(phone => this.marcaSeleccionada.includes(phone.brand))  
         if (this.rangoDePrecio != '') {
          filtro = filtro.filter(phone => phone.price < this.rangoDePrecio) }
          if(this.modeloSeleccionado != ''){
            filtro = this.phones.filter(phone => this.modeloSeleccionado.includes(phone.model))
           }
           if(this.buscador != ''){
             filtro = this.phones.filter(phone => phone.brand.toLowerCase().includes(this.buscador.toLowerCase()) || phone.model.toLowerCase().includes(this.buscador.toLowerCase()))}
     /*       if(this.ramSeleccionada != ''){
            this.phones.forEach(phone => {
             phone.ram.forEach(r => {
               if(this.ramSeleccionada.includes(r)){
                 filtro.push(phone)
               }
           })})} */
           if(this.procesadorSeleccionado != ''){
            filtro = this.phones.filter(phone => this.procesadorSeleccionado.includes(phone.processor))}
            

         this.phones = filtro
      }
},


    filtroPorPrecio(){
      this.phones = this.phonesCompletos
      if (this.rangoDePrecio != '') {
          let filtro = this.phones.filter(phone => phone.price < this.rangoDePrecio)
        /*   if(this.ramSeleccionada != ''){
             this.phones.forEach(phone => {
              phone.ram.forEach(r => {
                if(this.ramSeleccionada.includes(r)){
                  filtro.push(phone)
                }
            })})}
            if(this.colorSeleccionado != ''){
              this.phones.forEach(phone => {
                phone.phoneImageAndColorDTOS.forEach(color => {
                  if(this.colorSeleccionado.includes(color.phoneColor)){
                    filtro.push(phone)
                  }
              })})} */
              if(this.buscador != ''){
                filtro = this.phones.filter(phone => phone.brand.toLowerCase().includes(this.buscador.toLowerCase()) || phone.model.toLowerCase().includes(this.buscador.toLowerCase()))}
          if(this.marcaSeleccionada != ''){
            filtro = filtro.filter(phone => this.marcaSeleccionada.includes(phone.brand))
          }
          if(this.modeloSeleccionado != ''){
           filtro = this.phones.filter(phone => this.modeloSeleccionado.includes(phone.model))
          }
          if(this.procesadorSeleccionado != ''){
            filtro = this.phones.filter(phone => this.procesadorSeleccionado.includes(phone.processor))}
          this.phones = filtro
          
      }
  },
  filtroPorModelo(){
    this.phones=this.phonesCompletos

    if(this.modeloSeleccionado != ''){
      let filtro = this.phones.filter(phone => this.modeloSeleccionado.includes(phone.model))
      
          if(this.buscador != ''){
            filtro = this.phones.filter(phone => phone.brand.toLowerCase().includes(this.buscador.toLowerCase()) || phone.model.toLowerCase().includes(this.buscador.toLowerCase()))}
      if(this.marcaSeleccionada != ''){
        filtro = filtro.filter(phone => this.marcaSeleccionada.includes(phone.brand))
      }
      if (this.rangoDePrecio != '') {
        filtro = filtro.filter(phone => phone.price < this.rangoDePrecio) }
        if(this.procesadorSeleccionado != ''){
          filtro = this.phones.filter(phone => this.procesadorSeleccionado.includes(phone.processor))}

         this.phones = filtro
    }
  },
  /* filtroPorRam(){
    this.phones=this.phonesCompletos
    if(this.ramSeleccionada != ''){
      let filtro=[]
       this.phones.forEach(phone => {
        phone.ram.forEach(r => {
          if(this.ramSeleccionada.includes(r)){
            filtro.push(phone)
          }
      })})
      if(this.colorSeleccionado != ''){
        this.phones.forEach(phone => {
          phone.phoneImageAndColorDTOS.forEach(color => {
            if(this.colorSeleccionado.includes(color.phoneColor)){
              filtro.push(phone)
            }
        })})}
      if (this.rangoDePrecio != '') {
        filtro = filtro.filter(phone => phone.price > this.rangoDePrecio) }

        if(this.marcaSeleccionada != ''){
          filtro = filtro.filter(phone => this.marcaSeleccionada.includes(phone.brand))
        }
        if(this.modeloSeleccionado != ''){
          filtro = this.phones.filter(phone => this.modeloSeleccionado.includes(phone.model))
         }
         if(this.procesadorSeleccionado != ''){
          filtro = this.phones.filter(phone => this.procesadorSeleccionado.includes(phone.processor))}
      this.phones = filtro

    }
  }, */
  filtroPorProcesador(){
    this.phones=this.phonesCompletos
    if(this.procesadorSeleccionado != ''){
      let filtro = this.phones.filter(phone => this.procesadorSeleccionado.includes(phone.processor))
  /*     if(this.ramSeleccionada != ''){
         this.phones.forEach(phone => {
          phone.ram.forEach(r => {
            if(this.ramSeleccionada.includes(r)){
              filtro.push(phone)
            }
        })})} */
    /*     if(this.colorSeleccionado != ''){
          this.phones.forEach(phone => {
            phone.phoneImageAndColorDTOS.forEach(color => {
              if(this.colorSeleccionado.includes(color.phoneColor)){
                filtro.push(phone)
              }
          })})} */
          if(this.buscador != ''){
            filtro = this.phones.filter(phone => phone.brand.toLowerCase().includes(this.buscador.toLowerCase()) || phone.model.toLowerCase().includes(this.buscador.toLowerCase()))}
        if (this.rangoDePrecio != '') {
          filtro = filtro.filter(phone => phone.price < this.rangoDePrecio) }
          if(this.marcaSeleccionada != ''){
            filtro = filtro.filter(phone => this.marcaSeleccionada.includes(phone.brand))
          }
          if(this.modeloSeleccionado != ''){
            filtro = this.phones.filter(phone => this.modeloSeleccionado.includes(phone.model))
           }

      this.phones = filtro
    }


  },
  /* filtroPorColor(){
    this.phones=this.phonesCompletos
    if(this.colorSeleccionado != ''){
      let filtro=[]
      this.phones.forEach(phone => {
        phone.phoneImageAndColorDTOS.forEach(color => {
          if(this.colorSeleccionado.includes(color.phoneColor)){
            filtro.push(phone)
          }
      })})
      if(this.ramSeleccionada != ''){
        this.phones.forEach(phone => {
         phone.ram.forEach(r => {
           if(this.ramSeleccionada.includes(r)){
             filtro.push(phone)
           }
       })})}
      if(this.modeloSeleccionado != ''){
        filtro = this.phones.filter(phone => this.modeloSeleccionado.includes(phone.model))
       }
       if (this.rangoDePrecio != '') {
        filtro = filtro.filter(phone => phone.price > this.rangoDePrecio) }
        if(this.marcaSeleccionada != ''){
          filtro = filtro.filter(phone => this.marcaSeleccionada.includes(phone.brand))
        }
        if(this.procesadorSeleccionado != ''){
          filtro = this.phones.filter(phone => this.procesadorSeleccionado.includes(phone.processor))}


      this.phones = filtro
    }
  }
 */
  }
}).mount('#app')