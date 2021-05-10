package com.s10plus.core_application.mocks

import com.s10plus.core_application.models.*

object BecasAmadMenuBienestarAzteca {

    fun all(): List<ViewS10Plus> {
        return arrayListOf(
            ViewBienestarAzteca6(),
            ViewQueEsBienestarAzteca8(),
            ViewEtapa1_9(),
            ViewEtapa2_10(),
            ViewAyudaNoRegistro11(),
            ViewNoQR12(),
            ViewOlvidePass13(),
            ViewAMicolonia14(),
            ViewDuranteElRegistro15(),
            ViewVigenciaQR16()
        )
    }

    fun ViewBienestarAzteca6(): ViewS10Plus {

        return ViewS10Plus(
            BodyModel(
                LinealLayoutModel().apply {
                    typeView = TypeView.LINEAL

                    childs = arrayListOf(


                        Mocks.createImage(
                            "https://firebasestorage.googleapis.com/v0/b/amad-b1de7.appspot.com/o/logo_becas.png?alt=media&token=100faa92-1dc3-4be1-a34d-79dd30d69097",
                            arrayListOf(
                                Property(KeyProperties.SIZE, "-1 200"),
                            )
                        ),
                        Mocks.createTitle("Bienestar Azteca"),

                        Mocks.createButton(
                            arrayListOf(
                                Property(KeyProperties.TEXT, "¿Qué es Bienestar Azteca?"),
                                Property(KeyProperties.SEND_TO_VIEW, "8"),
                                Property(KeyProperties.SEND_ANALYTICS, "44|nav|CLICK/DETALLE|¿Qué es Bienestar Azteca?|¿Qué es Bienestar Azteca?",)


                            )
                        ),
                        Mocks.createButton(
                            arrayListOf(
                                Property(KeyProperties.TEXT, "Etapa 1. Registro"),
                                Property(KeyProperties.SEND_TO_VIEW, "9"),
                                Property(KeyProperties.SEND_ANALYTICS, "43|nav|CLICK/DETALLE|Etapa 1. Registro|Etapa 1. Registro",)

                            )
                        ),
                        Mocks.createButton(
                            arrayListOf(
                                Property(KeyProperties.TEXT, "Etapa 2. Recibe tu beca"),
                                Property(KeyProperties.SEND_TO_VIEW, "10"),
                                Property(KeyProperties.SEND_ANALYTICS, "42|nav|CLICK/DETALLE|Etapa 2. Recibe tu beca.|Etapa 2. Recibe tu beca.",)

                            )
                        ),
                        Mocks.createButton(
                            arrayListOf(
                                Property(
                                    KeyProperties.TEXT,
                                    "¡Ayuda! No me puedo registrar"
                                ),
                                Property(KeyProperties.SEND_TO_VIEW, "11"),
                                Property(KeyProperties.SEND_ANALYTICS, "41|nav|CLICK/DETALLE|¡Ayuda! No me puedo registrar.|¡Ayuda! No me puedo registrar.",)


                            )
                        ),
                        Mocks.createButton(
                            arrayListOf(
                                Property(
                                    KeyProperties.TEXT,
                                    "No me llega el código de verificación ni al correo ni al teléfono"
                                ),
                                Property(KeyProperties.SEND_TO_VIEW, "12"),
                                Property(KeyProperties.SEND_ANALYTICS, "40|nav|CLICK/DETALLE|No me llega el código de verificación ni al correo ni al teléfono|No me llega el código de verificación ni al correo ni al teléfono",)


                            )
                        ),
                        Mocks.createButton(
                            arrayListOf(
                                Property(KeyProperties.TEXT, "Olvidé mi contraseña"),
                                Property(KeyProperties.SEND_TO_VIEW, "13"),
                                Property(KeyProperties.SEND_ANALYTICS, "39|nav|CLICK/DETALLE|Olvidé mi contraseña|Olvidé mi contraseña",)

                            )
                        ),
                        Mocks.createButton(
                            arrayListOf(
                                Property(
                                    KeyProperties.TEXT,
                                    "Mi colonia y/o mi código postal no\n" + "aparece en el listado desplegable"
                                ),
                                Property(KeyProperties.SEND_TO_VIEW, "14"),
                                Property(KeyProperties.SEND_ANALYTICS, "38|nav|CLICK/DETALLE|Mi colonia y/o mi código postal no aparece en el listado desplegable|Mi colonia y/o mi código postal no aparece en el listado desplegable",)


                            )
                        ),
                        Mocks.createButton(
                            arrayListOf(
                                Property(
                                    KeyProperties.TEXT,
                                    "Durante el registro el sistema no me " + "pidió tomarme la fotografía"
                                ),
                                Property(KeyProperties.SEND_TO_VIEW, "15"),
                                Property(KeyProperties.SEND_ANALYTICS, "37|nav|CLICK/DETALLE|Durante el registro el sistema no me pidió tomarme la fotografía|Durante el registro el sistema no me pidió tomarme la fotografía",)


                            )
                        ),
                        Mocks.createButton(
                            arrayListOf(
                                Property(
                                    KeyProperties.TEXT,
                                    "¿Cuál es la vigencia del código QR y del código de barras?"
                                ),
                                Property(KeyProperties.SEND_TO_VIEW, "16"),
                                Property(KeyProperties.SEND_ANALYTICS, "36|nav|CLICK/DETALLE|¿Cuál es la vigencia del código QR y delcódigo de barras?|¿Cuál es la vigencia del código QR y del código de barras?",)

                            )
                        ),


                        )
                }
            ), Mocks.createFooterBack(),
            Mocks.createHeader(),
            "6", TypeView.NONE)
    }

    fun ViewQueEsBienestarAzteca8(): ViewS10Plus {

        return ViewS10Plus(
            BodyModel(
                LinealLayoutModel().apply {
                    typeView = TypeView.LINEAL

                    childs = arrayListOf(


                        Mocks.createImage(
                            "https://firebasestorage.googleapis.com/v0/b/amad-b1de7.appspot.com/o/logo_becas.png?alt=media&token=100faa92-1dc3-4be1-a34d-79dd30d69097",
                            arrayListOf(
                                Property(KeyProperties.SIZE, "-1 200"),
                            )
                        ),
                        Mocks.createTitle("¿Qué es bienestar azteca ?"),

                        Mocks.createText(
                            "Derivado de la emergencia sanitaria, la Coordinación Nacional de Becas para el Bienestar Benito Juárez en conjunto con Banco Azteca, diseñamos el sitio" +
                                    "<a href=\"https://bienestarazteca.com/\"> https://bienestarazteca.com/ </a>  para que puedas recibir tu beca de forma electrónica.",
                            arrayListOf(
                                Property(KeyProperties.TEXT_HTML, "true"),

                                Property(
                                    KeyProperties.OPEN_URL,
                                    "https://bienestarazteca.com/"
                                ),
                                Property(KeyProperties.SEND_ANALYTICS, "58|nav|CLICK/URL|https://bienestarazteca.com/|¿Qué es Bienestar Azteca?",)


                            )
                        ),


                        )
                }
            ), Mocks.createFooterBack(),
            Mocks.createHeader(),
            "8", TypeView.NONE)
    }

    fun ViewEtapa1_9(): ViewS10Plus {

        return ViewS10Plus(
            BodyModel(
                LinealLayoutModel().apply {
                    typeView = TypeView.LINEAL

                    childs = arrayListOf(


                        Mocks.createImage(
                            "https://firebasestorage.googleapis.com/v0/b/amad-b1de7.appspot.com/o/logo_becas.png?alt=media&token=100faa92-1dc3-4be1-a34d-79dd30d69097",
                            arrayListOf(
                                Property(KeyProperties.SIZE, "-1 200"),
                            )
                        ),
                        Mocks.createTitle("Etapa 1. Registro"),

                        Mocks.createText(
                            "1. Ingresa a la página " +
                                    "<a href=\"https://bienestarazteca.com/\"> https://bienestarazteca.com/ </a> Lee el aviso de Privacidad.",
                            arrayListOf(
                                Property(KeyProperties.TEXT_HTML, "true"),

                                Property(
                                    KeyProperties.OPEN_URL,
                                    "https://bienestarazteca.com/"
                                ),
                                Property(KeyProperties.SEND_ANALYTICS, "55|nav|CLICK/URL|https://bienestarazteca.com/|Etapa 1. Registro",)




                            )
                        ),


                        Mocks.createText(
                            "2. Ingresa tu CURP. ",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))
                        ),
                        Mocks.createText(
                            "3. Ingresa los datos que te solicita la aplicación.",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),

                        Mocks.createText(
                            "4. Tómate una foto para que tus siguientes cobros sean más seguros.",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),

                        Mocks.createText(
                            "5. Crea una contraseña y escribe tu número celular y correo electrónico. No puedes utilizar el de otra persona.",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),

                        Mocks.createText(
                            "6. Cuando concluyas, recibirás tu usuario a través de mensaje en tu celular y/o tu correo electrónico registrado.",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),
                        )
                }
            ), Mocks.createFooterBack(),
            Mocks.createHeader(),
            "9", TypeView.NONE)
    }

    fun ViewEtapa2_10(): ViewS10Plus {

        return ViewS10Plus(
            BodyModel(
                LinealLayoutModel().apply {
                    typeView = TypeView.LINEAL

                    childs = arrayListOf(


                        Mocks.createImage(
                            "https://firebasestorage.googleapis.com/v0/b/amad-b1de7.appspot.com/o/logo_becas.png?alt=media&token=100faa92-1dc3-4be1-a34d-79dd30d69097",
                            arrayListOf(
                                Property(KeyProperties.SIZE, "-1 200"),
                            )
                        ),
                        Mocks.createTitle("Etapa 2. Recibe tu beca"),


                        Mocks.createText(
                            "1. Ingresa nuevamente " +
                                    "<a href=\"https://bienestarazteca.com/\"> https://bienestarazteca.com/ </a>. Deberás hacerlo con tu usuario y contraseña.",
                            arrayListOf(
                                Property(KeyProperties.TEXT_HTML, "true"),

                                Property(
                                    KeyProperties.OPEN_URL,
                                    "https://bienestarazteca.com/"
                                ),
                                Property(KeyProperties.SEND_ANALYTICS, "52|nav|CLICK/URL|https://bienestarazteca.com/|Etapa 1. Registro",)


                            )
                        ),
                        Mocks.createText(
                            "2. Elige la opción “Recibir apoyo” y selecciona si deseas cobrar tu beca en una sucursal de Banco Azteca o en un establecimiento autorizado. ",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        )
                        ,
                        Mocks.createText(
                            "3. Ingresa la cantidad que deseas retirar y confirma.",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),
                        Mocks.createText(
                            "4. Descarga tu código QR (cobro en banco) o código de barras (cobro en tiendas de autoservicio).",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),
                        Mocks.createText(
                            "5. Acude a cobrar tu beca, deberás presentar al cajero el código QR o código de barras generado e ingresar tu NIP. Si eres mayor de edad, deberás mostrar credencial del INE si deseas cobrar en las tiendas de autoservicio.",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),




                        )
                }
            ), Mocks.createFooterBack(),
            Mocks.createHeader(),
            "10", TypeView.NONE)
    }

    fun ViewAyudaNoRegistro11(): ViewS10Plus {

        return ViewS10Plus(
            BodyModel(
                LinealLayoutModel().apply {
                    typeView = TypeView.LINEAL

                    childs = arrayListOf(


                        Mocks.createImage(
                            "https://firebasestorage.googleapis.com/v0/b/amad-b1de7.appspot.com/o/logo_becas.png?alt=media&token=100faa92-1dc3-4be1-a34d-79dd30d69097",
                            arrayListOf(
                                Property(KeyProperties.SIZE, "-1 200"),
                            )
                        ),
                        Mocks.createTitle("¡Ayuda! No me puedo registrar"),

                        Mocks.createText(
                            "Si al momento de registrarte te aparece el mensaje “Los datos son incorrectos, por favor verifica e inténtalo más tarde” puede deberse a:",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        )
                        ,
                        Mocks.createText(
                            "1) Estás cometiendo un error al escribir tus datos, verifica que estés ingresando correctamente tu información.",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),
                        Mocks.createText(
                            "2) Tu correo electrónico y número celular no están actualizados ante la Coordinación Nacional de Becas. En este caso deberás solicitar una actualización de datos directamente en tu escuela con el responsable de becas.",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),
                        Mocks.createText(
                            "Después de unos días de actualizar tu información podrás intentar registrarte nuevamente.",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),


                        )
                }
            ), Mocks.createFooterBack(),
            Mocks.createHeader(),
            "11", TypeView.NONE)
    }

    fun ViewNoQR12(): ViewS10Plus {

        return ViewS10Plus(
            BodyModel(
                LinealLayoutModel().apply {
                    typeView = TypeView.LINEAL

                    childs = arrayListOf(


                        Mocks.createImage(
                            "https://firebasestorage.googleapis.com/v0/b/amad-b1de7.appspot.com/o/logo_becas.png?alt=media&token=100faa92-1dc3-4be1-a34d-79dd30d69097",
                            arrayListOf(
                                Property(KeyProperties.SIZE, "-1 200"),
                            )
                        ),
                        Mocks.createTitle("No me llega el código de verificación ni al correo ni al teléfono"),

                        Mocks.createText(
                            "Si al momento de registrarte te aparece el mensaje “Los datos son incorrectos, por favor verifica e inténtalo más tarde” puede deberse a:",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        )
                        ,
                        Mocks.createText(
                            "1) Estás cometiendo un error al escribir tus datos, verifica que estés ingresando correctamente tu información.",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),
                        Mocks.createText(
                            "2) Tu correo electrónico y número celular no están actualizados ante la Coordinación Nacional de Becas. En este caso deberás solicitar una actualización de datos directamente en tu escuela con el responsable de becas.",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),
                        Mocks.createText(
                            "Después de unos días de actualizar tu información podrás intentar registrarte nuevamente.",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),


                        )
                }
            ), Mocks.createFooterBack(),
            Mocks.createHeader(),
            "12", TypeView.NONE)
    }

    fun ViewOlvidePass13(): ViewS10Plus {

        return ViewS10Plus(
            BodyModel(
                LinealLayoutModel().apply {
                    typeView = TypeView.LINEAL

                    childs = arrayListOf(


                        Mocks.createImage(
                            "https://firebasestorage.googleapis.com/v0/b/amad-b1de7.appspot.com/o/logo_becas.png?alt=media&token=100faa92-1dc3-4be1-a34d-79dd30d69097",
                            arrayListOf(
                                Property(KeyProperties.SIZE, "-1 200"),
                            )
                        ),
                        Mocks.createTitle("Olvidé mi contraseña"),

                        Mocks.createText(
                            "1) Ingresa a" +
                                    "<a href=\"https://bienestarazteca.com/\"> https://bienestarazteca.com/ </a>",
                            arrayListOf(
                                Property(KeyProperties.TEXT_HTML, "true"),

                                Property(
                                    KeyProperties.OPEN_URL,
                                    "https://bienestarazteca.com/"
                                ),
                                Property(KeyProperties.SEND_ANALYTICS, "49|nav|CLICK/URL|https://bienestarazteca.com/|Etapa 1. Registro",)

                                )
                        ),
                        Mocks.createText(
                            "2) Da clic en Inicia sesión.",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),
                        Mocks.createText(
                            "3) Selecciona la opción ¿Olvidaste la contraseña?",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),
                        Mocks.createText(
                            "4) Ingresa tu usuario y fecha de nacimiento y sigue las indicaciones que te señala la página electrónica.",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),

                        )
                }
            ), Mocks.createFooterBack(),
            Mocks.createHeader(),
            "13", TypeView.NONE)
    }

    fun ViewAMicolonia14(): ViewS10Plus {

        return ViewS10Plus(
            BodyModel(
                LinealLayoutModel().apply {
                    typeView = TypeView.LINEAL

                    childs = arrayListOf(


                        Mocks.createImage(
                            "https://firebasestorage.googleapis.com/v0/b/amad-b1de7.appspot.com/o/logo_becas.png?alt=media&token=100faa92-1dc3-4be1-a34d-79dd30d69097",
                            arrayListOf(
                                Property(KeyProperties.SIZE, "-1 200"),
                            )
                        ),
                        Mocks.createTitle("Mi colonia y/o mi código postal no\n" + "aparece en el listado desplegable"),
                        Mocks.createText(
                            "Coloca una colonia cercana a tu domicilio, esta información no interfiere en el registro exitoso ni en la entrega de la beca.",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),

                        )
                }
            ), Mocks.createFooterBack(),
            Mocks.createHeader(),
            "15", TypeView.NONE)
    }

    fun ViewDuranteElRegistro15(): ViewS10Plus {

        return ViewS10Plus(
            BodyModel(
                LinealLayoutModel().apply {
                    typeView = TypeView.LINEAL

                    childs = arrayListOf(


                        Mocks.createImage(
                            "https://firebasestorage.googleapis.com/v0/b/amad-b1de7.appspot.com/o/logo_becas.png?alt=media&token=100faa92-1dc3-4be1-a34d-79dd30d69097",
                            arrayListOf(
                                Property(KeyProperties.SIZE, "-1 200"),
                            )
                        ),
                        Mocks.createTitle("Durante el registro el sistema no me " + "pidió tomarme la fotografía"),

                        Mocks.createText(
                            "Si durante el registro no te fue requerido tomarte la fotografía, es probable que no hayas dado acceso a tu cámara o ésta no sea compatible o no funcione.\n" +
                                    "El registro puede concluirse sin haberte tomado la foto, considera que una vez que te encuentres registrado ya no es posible agregar una imagen de perfil. Esta situación no interfiere en el registro exitoso ni en la entrega de la beca.",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),


                        )
                }
            ), Mocks.createFooterBack(),
            Mocks.createHeader(),
            "8", TypeView.NONE)
    }

    fun ViewVigenciaQR16(): ViewS10Plus {

        return ViewS10Plus(
            BodyModel(
                LinealLayoutModel().apply {
                    typeView = TypeView.LINEAL

                    childs = arrayListOf(


                        Mocks.createImage(
                            "https://firebasestorage.googleapis.com/v0/b/amad-b1de7.appspot.com/o/logo_becas.png?alt=media&token=100faa92-1dc3-4be1-a34d-79dd30d69097",
                            arrayListOf(
                                Property(KeyProperties.SIZE, "-1 200"),
                            )
                        ),
                        Mocks.createTitle("¿Cuál es la vigencia del código QR y del código de barras?"),

                        Mocks.createText(
                            "El código QR sólo funciona en sucursales de Banco Azteca y tienen una vigencia de un día.\n" +
                                    "El código de barras funciona sólo en los establecimientos autorizados (Bodega Aurrera, Walmart, Chedraui, Superama y Sam’s Club) y tiene una vigencia de dos días.\n" +
                                    "Los códigos podrás generarlos las veces que requieras, siempre y cuando no hayas cobrado la beca.",
                            arrayListOf(
                                Property(KeyProperties.TEXT_HTML, "true"),

                                )
                        ),


                        )
                }
            ), Mocks.createFooterBack(),
            Mocks.createHeader(),
            "16", TypeView.NONE)
    }
}