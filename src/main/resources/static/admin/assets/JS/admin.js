const { createApp } = Vue
createApp({
    data() {
        return {
            buyers: [],
            phones: [],
            accessories: [],
            consoles: [],
            ticketsPurchase: [],

            urlBuyer: "/api/buyer",
            urlPhones: "/api/phone",
            urlCreatePhone: "/api/phone",
            urlPhoneDelete: "/api/phone/delete",
            urlPhoneStock: "/api/phone/stock",
            urlPhonePrice: "/api/phone/price",
            urlAccessories: "/api/accessory",
            urlCreateAccessory: "/api/accessory",
            urlAccessoryDelete: "/api/accessory/delete",
            urlAccessoryStock: "/api/accessory/stock",
            urlAccessoryPrice: "/api/accessory/price",
            urlConsoles: "/api/console",
            urlConsoleDelete: "/api/console/delete",
            urlConsoleStock: "/api/console/stock",
            urlConsolePrice: "/api/console/price",
            urlTicketsPurchase: "/api/ticket",

            action: "",

            phoneBrand: "",
            phoneModel: "",
            phoneCamera: "",
            phoneProcessor: "",
            phoneBattery: "",
            phoneSize: "",
            phonePrice: null,
            phoneRam: "",
            phoneRom: "",
            phoneRams: [],
            phoneRoms: [],
            phoneStock: null,
            phoneImage: "",
            phoneImages: [],
            phoneColor: "",
            phoneNewStock: null,

            accessoryBrand: "",
            accessoryModel: "",
            accessoryDescription: "",
            accessoryType: "",
            accessoryPrice: null,
            accessoryStock: null,
            accessoryImage: "",
            accessoryImages: [],
            accessoryColor: ""
        }

    },
    created() {
        this.getBuyers(this.urlBuyer);
        this.getPhones(this.urlPhones);
        this.getAccessories(this.urlAccessories);
        this.getConsoles(this.urlConsoles);
        this.getTicketsPurchase(this.urlTicketsPurchase);
    },
    methods: {
        getBuyers(urlBuyer) {
            axios.get(urlBuyer)
                .then((response) => {
                    this.buyers = response.data
                })
        },
        getPhones(urlPhones) {
            axios.get(urlPhones)
                .then((response) => {
                    this.phones = response.data
                })
        },
        getAccessories(urlAccessories) {
            axios.get(urlAccessories)
                .then((response) => {
                    this.accessories = response.data
                })
        },
        getConsoles(urlConsoles) {
            axios.get(urlConsoles)
                .then((response) => {
                    this.consoles = response.data
                })
        },
        getTicketsPurchase(urlTicketsPurchase) {
            axios.get(urlTicketsPurchase)
                .then((response) => {
                    this.ticketsPurchase = response.data
                })
        },
        addRam() {
            if (!this.phoneRams.includes(this.phoneRam) && this.phoneRam != "") {
                this.phoneRams.push(this.phoneRam)
            }
            this.phoneRam = ""
        },
        deleteRam() {
            this.phoneRams.pop()
        },
        addRom() {
            if (!this.phoneRoms.includes(this.phoneRom) && this.phoneRom != "") {
                this.phoneRoms.push(this.phoneRom)
            }
            this.phoneRom = ""
        },
        deleteRom() {
            this.phoneRoms.pop()
        },
        addImage(produc) {
            if (produc == "phone") {
                if (!this.phoneImages.includes(this.phoneImage) && this.phoneImage != "") {
                    this.phoneImages.push(this.phoneImage)
                }
                this.phoneImage = ""

            }
            if (produc == "accessory") {
                if (!this.accessoryImages.includes(this.accessoryImage) && this.accessoryImage != "") {
                    this.accessoryImages.push(this.accessoryImage)
                }
                this.accessoryImage = ""
            }
            if (produc == "console") { }


        },
        deleteImage() {
            if (produc == "phone") {
                this.phoneImages.pop()
            }
            if (produc == "accessory") {
                this.accessoryImages.pop()
            }
            if (produc == "console") { }
        },
        createPhone() {
            axios.post(this.urlCreatePhone,
                {
                    brand: this.phoneBrand,
                    model: this.phoneModel,
                    ram: this.phoneRams,
                    rom: this.phoneRoms,
                    cameraDescription: this.phoneCamera,
                    processor: this.phoneProcessor,
                    price: this.phonePrice,
                    stock: this.phoneStock,
                    battery: this.phoneBattery,
                    size: this.phoneSize,
                    linkImage: this.phoneImages,
                    phoneColor: this.phoneColor
                }).then(() => {
                    this.getPhones(this.urlPhones);
                    this.phoneBrand = ""
                    this.phoneModel = ""
                    this.phoneCamera = ""
                    this.phoneProcessor = ""
                    this.phoneBattery = ""
                    this.phoneSize = ""
                    this.phonePrice = null
                    this.phoneRam = ""
                    this.phoneRam = ""
                    this.phoneRams = []
                    this.phoneRoms = []
                    this.phoneStock = null
                    this.phoneImages = []
                    this.phoneColor = ""
                    alert("new phone create")
                    this.getPhones(this.urlPhones);
                })
        },
        deletePhone(Id) {
            axios.post(this.urlPhoneDelete, "phoneId=" + Id)
                .then(() => {
                    this.getPhones(this.urlPhones);
                    alert("phone deleted")
                })
        },
        stockPhone(Id) {
            Swal.fire({
                title: 'New stock',
                input: 'number',
                inputAttributes: {
                    autocapitalize: 'off'
                },
                showCancelButton: true,
                confirmButtonText: 'Change',
                showLoaderOnConfirm: true,
                preConfirm: (login) => {
                    return fetch(`//api.github.com/users/${login}`)
                        .then(response => {
                            if (!response.ok) {
                                throw new Error(response.statusText)
                            }
                            return response.json()
                        })
                        .catch(error => {
                            Swal.showValidationMessage(
                                `Request failed: ${error}`
                            )
                        })
                },
                allowOutsideClick: () => !Swal.isLoading()
            }).then((result) => {
                if (result.isConfirmed) {
                    axios.patch(this.urlPhoneStock, "stock=" + result.value.login + "&phoneId=" + Id)
                        .then(() => {
                            this.getPhones(this.urlPhones);
                            alert("phone stock changed")
                        })
                }
            })

        },
        pricePhone(Id) {
            Swal.fire({
                title: 'New Price',
                input: 'number',
                inputAttributes: {
                    autocapitalize: 'off'
                },
                showCancelButton: true,
                confirmButtonText: 'Change',
                showLoaderOnConfirm: true,
                preConfirm: (login) => {
                    return fetch(`//api.github.com/users/${login}`)
                        .then(response => {
                            if (!response.ok) {
                                throw new Error(response.statusText)
                            }
                            return response.json()
                        })
                        .catch(error => {
                            Swal.showValidationMessage(
                                `Request failed: ${error}`
                            )
                        })
                },
                allowOutsideClick: () => !Swal.isLoading()
            }).then((result) => {
                if (result.isConfirmed) {
                    axios.patch(this.urlPhonePrice, "price=" + result.value.login + "&phoneId=" + Id)
                        .then(() => {
                            this.getPhones(this.urlPhones);
                            alert("phone price changed")
                        })
                }
            })
        },
        deleteAccessory(Id) {
            axios.post(this.urlAccessoryDelete, "accessoryId=" + Id)
                .then(() => {
                    this.getAccessories(this.urlAccessories);
                    alert("accessory deleted")
                })
        },
        stockAccessory(Id) {
            Swal.fire({
                title: 'New stock',
                input: 'number',
                inputAttributes: {
                    autocapitalize: 'off'
                },
                showCancelButton: true,
                confirmButtonText: 'Change',
                showLoaderOnConfirm: true,
                preConfirm: (login) => {
                    return fetch(`//api.github.com/users/${login}`)
                        .then(response => {
                            if (!response.ok) {
                                throw new Error(response.statusText)
                            }
                            return response.json()
                        })
                        .catch(error => {
                            Swal.showValidationMessage(
                                `Request failed: ${error}`
                            )
                        })
                },
                allowOutsideClick: () => !Swal.isLoading()
            }).then((result) => {
                if (result.isConfirmed) {
                    axios.patch(this.urlAccessoryStock, "stock=" + result.value.login + "&accessoryId=" + Id)
                        .then(() => {
                            this.getAccessories(this.urlAccessories);
                            alert("accessory stock changed")
                        })
                }
            })

        },
        priceAccessory(Id) {
            Swal.fire({
                title: 'New Price',
                input: 'number',
                inputAttributes: {
                    autocapitalize: 'off'
                },
                showCancelButton: true,
                confirmButtonText: 'Change',
                showLoaderOnConfirm: true,
                preConfirm: (login) => {
                    return fetch(`//api.github.com/users/${login}`)
                        .then(response => {
                            if (!response.ok) {
                                throw new Error(response.statusText)
                            }
                            return response.json()
                        })
                        .catch(error => {
                            Swal.showValidationMessage(
                                `Request failed: ${error}`
                            )
                        })
                },
                allowOutsideClick: () => !Swal.isLoading()
            }).then((result) => {
                if (result.isConfirmed) {
                    axios.patch(this.urlAccessoryPrice, "price=" + result.value.login + "&accessoryId=" + Id)
                        .then(() => {
                            this.getAccessories(this.urlAccessories);
                            alert("accessory price changed")
                        })
                }
            })
        },

        deleteConsole(Id) {
            axios.post(this.urlConsoleDelete, "consoleId=" + Id)
                .then(() => {
                    this.getConsoles(this.urlConsoles);
                    alert("accessory deleted")
                })
        },
        stockConsole(Id) {
            Swal.fire({
                title: 'New stock',
                input: 'number',
                inputAttributes: {
                    autocapitalize: 'off'
                },
                showCancelButton: true,
                confirmButtonText: 'Change',
                showLoaderOnConfirm: true,
                preConfirm: (login) => {
                    return fetch(`//api.github.com/users/${login}`)
                        .then(response => {
                            if (!response.ok) {
                                throw new Error(response.statusText)
                            }
                            return response.json()
                        })
                        .catch(error => {
                            Swal.showValidationMessage(
                                `Request failed: ${error}`
                            )
                        })
                },
                allowOutsideClick: () => !Swal.isLoading()
            }).then((result) => {
                if (result.isConfirmed) {
                    axios.patch(this.urlConsoleStock, "stock=" + result.value.login + "&consoleId=" + Id)
                        .then(() => {
                            this.getConsoles(this.urlConsoles);
                            alert("console stock changed")
                        })
                }
            })

        },
        priceConsole(Id) {
            Swal.fire({
                title: 'New Price',
                input: 'number',
                inputAttributes: {
                    autocapitalize: 'off'
                },
                showCancelButton: true,
                confirmButtonText: 'Change',
                showLoaderOnConfirm: true,
                preConfirm: (login) => {
                    return fetch(`//api.github.com/users/${login}`)
                        .then(response => {
                            // if (!response.ok) {
                            //     throw new Error(response.statusText)
                            // }
                            return response.json()
                        })
                        .catch(error => {
                            Swal.showValidationMessage(
                                `Request failed: ${error}`
                            )
                        })
                },
                allowOutsideClick: () => !Swal.isLoading()
            }).then((result) => {
                if (result.isConfirmed) {
                    axios.patch(this.urlConsolePrice, "price=" + result.value.login + "&consoleId=" + Id)
                        .then(() => {
                            this.getConsoles(this.urlConsoles);
                            alert("console price changed")
                        })
                }
            })
        },
        createAccessory() {
            let createAccessory = {
                description: this.accessoryDescription,
                type: this.accessoryType,
                brand: this.accessoryBrand,
                model: this.accessoryModel,
                stock: this.accessoryStock,
                price: this.accessoryPrice,
                linkImage: this.accessoryImages,
                accessoryColor: this.accessoryColor
            }
            axios.post(this.urlCreateAccessory, createAccessory)
                .then(() => {
                    this.accessoryDescription = "";
                    this.accessoryType = "";
                    this.accessoryBrand = "";
                    this.accessoryModel = "";
                    this.accessoryStock = null;
                    this.accessoryPrice = null;
                    this.accessoryImages = [];
                    this.accessoryColor = "";
                    alert("new accessory create")
                    this.getAccessories(this.urlAccessories);
                })
        }

    },
    computed: {

    }
}).mount('#app')