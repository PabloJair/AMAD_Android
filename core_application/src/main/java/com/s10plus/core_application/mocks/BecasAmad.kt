package com.s10plus.core_application.mocks

import com.s10plus.core_application.mocks.Mocks.createButton
import com.s10plus.core_application.mocks.Mocks.createButtonImageBecas
import com.s10plus.core_application.mocks.Mocks.createFooterBack
import com.s10plus.core_application.mocks.Mocks.createHeader
import com.s10plus.core_application.mocks.Mocks.createImage
import com.s10plus.core_application.mocks.Mocks.createText
import com.s10plus.core_application.mocks.Mocks.createTitle
import com.s10plus.core_application.models.*

object BecasAmad {

    fun MenuHome(): ViewS10Plus {
        return ViewS10Plus(
            BodyModel(
                LinealLayoutModel().apply {
                    typeView = TypeView.LINEAL

                    childs = arrayListOf(

                        createImage(
                            "https://firebasestorage.googleapis.com/v0/b/amad-b1de7.appspot.com/o/logo_becas.png?alt=media&token=100faa92-1dc3-4be1-a34d-79dd30d69097",
                            arrayListOf(
                                Property(KeyProperties.SIZE, "-1 200"),
                            )
                        ),
                        createButtonImageBecas(
                            "Becas de Educación Basica",
                            "https://firebasestorage.googleapis.com/v0/b/amad-b1de7.appspot.com/o/6.png?alt=media&token=7c4baede-6d52-4c88-8461-741f436118da",
                            arrayListOf(Property(KeyProperties.SEND_TO_VIEW, "1"))
                        ),
                        createButtonImageBecas(
                            "Becas de Educación Media Superior",
                            "https://firebasestorage.googleapis.com/v0/b/amad-b1de7.appspot.com/o/2.png?alt=media&token=27518f31-f679-4fc8-a6b2-58111793f886",
                            arrayListOf(Property(KeyProperties.SEND_TO_VIEW, "2"))
                        ),
                        createButtonImageBecas(
                            "Becas Jovenes Escribiendo el futuro",
                            "https://firebasestorage.googleapis.com/v0/b/amad-b1de7.appspot.com/o/4.png?alt=media&token=d96cf614-383d-4da2-a898-17ad47f081c2",
                            arrayListOf(Property(KeyProperties.SEND_TO_VIEW, "3"))

                        ),
                        createButtonImageBecas(
                            "Becas Elisa Acuña",
                            "https://firebasestorage.googleapis.com/v0/b/amad-b1de7.appspot.com/o/3.png?alt=media&token=99b55840-5e3d-45f1-8aaf-236f5bb1affa",
                            arrayListOf(Property(KeyProperties.SEND_TO_VIEW, "4"))

                        ),
                        createButtonImageBecas(
                            "Contraloría Social",
                            "https://firebasestorage.googleapis.com/v0/b/amad-b1de7.appspot.com/o/5.png?alt=media&token=3dae3b31-f1ef-4ec9-81a3-8c54185caf04",
                            arrayListOf(Property(KeyProperties.SEND_TO_VIEW, "5"))


                        ),
                        createButtonImageBecas(
                            "Oficina Cerca de ti",
                            "https://firebasestorage.googleapis.com/v0/b/amad-b1de7.appspot.com/o/pin.png?alt=media&token=4efb26e9-b339-4735-afdf-1e4579aa2ada",
                            arrayListOf(Property(KeyProperties.OPEN_URL,
                                "https://www.google.com/maps/search/Coordinación nacional de becas cerca de mí"))
                        ),
                        createButtonImageBecas(
                            "Chat en Línea",
                            "https://firebasestorage.googleapis.com/v0/b/amad-b1de7.appspot.com/o/1.png?alt=media&token=09e9e121-0456-4091-844a-2f6f7824f122",
                            arrayListOf(Property(KeyProperties.OPEN_URL_INTERNAL,
                                "https://cariai.com/cVhlaTdqekZaZkkyL1VJUDd0VjFiUWRwb2tWbjdWQi9LWC9za2oyQllWbmlLOWhlQ0dneFlhSTFqTzNmb2lSY3liL2MveVVVT3JlMXVTTHpEQT09?phoneNumber="))


                        ),
                        createButtonImageBecas(
                            "Atención de un agente",
                            "https://firebasestorage.googleapis.com/v0/b/amad-b1de7.appspot.com/o/phone.png?alt=media&token=c8c0f11b-cd4c-4b68-9bf9-2e018b98f38d",


                        ),

                        )

                }
            ),
            FooterModel(
                LinealLayoutModel().apply {
                    typeView = TypeView.LINEAL

                    childs = arrayListOf(

                        createImage(
                            "https://firebasestorage.googleapis.com/v0/b/amad-b1de7.appspot.com/o/sep.jpg?alt=media&token=85e01f3e-a72e-4c09-9407-f2439c89c49a",
                            arrayListOf(
                                Property(KeyProperties.SIZE, "-1 200"),
                            )

                        )
                    )

                }
            ),
            createHeader(),
            "0", TypeView.NONE)


    }

    fun ViewBecasDeEducacion1(): ViewS10Plus {

        return ViewS10Plus(
            BodyModel(
                LinealLayoutModel().apply {
                    typeView = TypeView.LINEAL

                    childs = arrayListOf(


                        createImage(
                            "https://firebasestorage.googleapis.com/v0/b/amad-b1de7.appspot.com/o/logo_becas.png?alt=media&token=100faa92-1dc3-4be1-a34d-79dd30d69097",
                            arrayListOf(
                                Property(KeyProperties.SIZE, "-1 200"),
                            )
                        ),
                        createTitle("Becas de Educación Básica"),
                        createText("La beca de Educación Básica está dirigida a familias con niñas, niños y/o adolescentes inscritos en Instituciones de Educación Básica (inicial, primaria y secundaria) o con infantes menores de cinco años, habitantes en localidades prioritarias.\n"),
                        createText("La beca consiste en un apoyo de \$1,600 bimestrales, durante los diez meses que dura el ciclo escolar. Únicamente se otorga una beca por familia."),
                        createText("La incorporación al programa depende de los lugares disponibles conforme a la suficiencia presupuestal. Por el momento no hay una convocatoria abierta de incorporación, ¡mantente al pendiente!"),
                        createText("¿Quieres saber más? Visita las preguntas frecuentes."),


                        )

                }
            ),
            createFooterBack(),
            createHeader(),
            "1", TypeView.NONE)
    }

    fun ViewBecasDeEducacionMedia2(): ViewS10Plus {

        return ViewS10Plus(
            BodyModel(
                LinealLayoutModel().apply {
                    typeView = TypeView.LINEAL

                    childs = arrayListOf(


                        createImage(
                            "https://firebasestorage.googleapis.com/v0/b/amad-b1de7.appspot.com/o/logo_becas.png?alt=media&token=100faa92-1dc3-4be1-a34d-79dd30d69097",
                            arrayListOf(
                                Property(KeyProperties.SIZE, "-1 200"),
                            )
                        ),
                        createTitle("Becas de Educación Media Superior"),
                        createButton(
                            arrayListOf(Property(KeyProperties.TEXT, "Información General"))
                        ),
                        createButton(
                            arrayListOf(Property(KeyProperties.TEXT, "Bienestar Azteca"),
                                Property(KeyProperties.SEND_TO_VIEW, "6"))
                        ),


                        )
                }
            ), createFooterBack(),
            createHeader(),
            "2", TypeView.NONE)
    }


    fun ViewBecasJovenesEscribiendoElFuturo3(): ViewS10Plus {

        return ViewS10Plus(
            BodyModel(
                LinealLayoutModel().apply {
                    typeView = TypeView.LINEAL

                    childs = arrayListOf(


                        createImage(
                            "https://firebasestorage.googleapis.com/v0/b/amad-b1de7.appspot.com/o/logo_becas.png?alt=media&token=100faa92-1dc3-4be1-a34d-79dd30d69097",
                            arrayListOf(
                                Property(KeyProperties.SIZE, "-1 200"),
                            )
                        ),
                        createTitle("Becas Jovenes Escribiendo el futuro"),
                        createButton(
                            arrayListOf(Property(KeyProperties.TEXT, "Información General"))
                        ),
                        createButton(
                            arrayListOf(Property(KeyProperties.TEXT, "Convocatoría"))
                        ),


                        )

                }
            ), createFooterBack(),
            createHeader(),
            "3", TypeView.NONE)
    }


    fun ViewBecasElisaAcuña4(): ViewS10Plus {

        return ViewS10Plus(
            BodyModel(
                LinealLayoutModel().apply {
                    typeView = TypeView.LINEAL

                    childs = arrayListOf(


                        createImage(
                            "https://firebasestorage.googleapis.com/v0/b/amad-b1de7.appspot.com/o/logo_becas.png?alt=media&token=100faa92-1dc3-4be1-a34d-79dd30d69097",
                            arrayListOf(
                                Property(KeyProperties.SIZE, "-1 200"),
                            )
                        ),
                        createTitle("Becas Elisa Acuña"),
                        createButton(
                            arrayListOf(Property(KeyProperties.TEXT, "Información General"))
                        ),
                        createButton(
                            arrayListOf(Property(KeyProperties.TEXT, "Convocatoría"))
                        ),
                        createButton(
                            arrayListOf(Property(KeyProperties.TEXT, "Resultados"))
                        ),


                        )

                }
            ), createFooterBack(),
            createHeader(),
            "4", TypeView.NONE)
    }
    fun ViewControloriaSocial5(): ViewS10Plus {

        return ViewS10Plus(
            BodyModel(
                LinealLayoutModel().apply {
                    typeView = TypeView.LINEAL

                    childs = arrayListOf(


                        createImage(
                            "https://firebasestorage.googleapis.com/v0/b/amad-b1de7.appspot.com/o/logo_becas.png?alt=media&token=100faa92-1dc3-4be1-a34d-79dd30d69097",
                            arrayListOf(
                                Property(KeyProperties.SIZE, "-1 200"),
                            )
                        ),
                        createTitle("Controloria Social"),
                        createButton(
                            arrayListOf(Property(KeyProperties.TEXT, "Información General")

                            )
                        ),
                        createButton(
                            arrayListOf(Property(KeyProperties.TEXT, "¡Regístrate como representante!"))
                        ),
                        createButton(
                            arrayListOf(Property(KeyProperties.TEXT, "Denuncia Ciudadana"),
                                Property(KeyProperties.OPEN_URL,
                                    "https://sidec.funcionpublica.gob.mx/#!/"))
                        ),
                        createButton(
                            arrayListOf(Property(KeyProperties.TEXT, "Ciudadanos Alertadores"),
                                Property(KeyProperties.OPEN_URL,
                                    "https://alertadores.funcionpublica.gob.mx/"))
                        ),
                        createButton(
                            arrayListOf(Property(KeyProperties.TEXT, "Quejas y Denuncias"),
                                )
                        ),

                        )

                }
            ), createFooterBack(),
            createHeader(),
            "5", TypeView.NONE)
    }

    fun ViewBienestarAzteca6(): ViewS10Plus {

        return ViewS10Plus(
            BodyModel(
                LinealLayoutModel().apply {
                    typeView = TypeView.LINEAL

                    childs = arrayListOf(


                        createImage(
                            "https://firebasestorage.googleapis.com/v0/b/amad-b1de7.appspot.com/o/logo_becas.png?alt=media&token=100faa92-1dc3-4be1-a34d-79dd30d69097",
                            arrayListOf(
                                Property(KeyProperties.SIZE, "-1 200"),
                            )
                        ),
                        createTitle("Becas de Educación Media Superior"),

                        createButton(
                            arrayListOf(Property(KeyProperties.TEXT, "¿Qué es Bienestar Azteca?"))
                        ),
                        createButton(
                            arrayListOf(Property(KeyProperties.TEXT, "Etapa 1. Registro"))
                        ),
                        createButton(
                            arrayListOf(Property(KeyProperties.TEXT, "Etapa 2. Recibe tu beca"))
                        ),
                        createButton(
                            arrayListOf(Property(KeyProperties.TEXT, "¡Ayuda! No me puedo registrar"))
                        ),
                        createButton(
                            arrayListOf(Property(KeyProperties.TEXT, "No me llega el código de verificación ni al correo ni al teléfono"))
                        ),
                        createButton(
                            arrayListOf(Property(KeyProperties.TEXT, "Olvidé mi contraseña"))
                        ),
                        createButton(
                            arrayListOf(Property(KeyProperties.TEXT, "Durante el registro el sistema no me " + "pidió tomarme la fotografía"))
                        ),
                        createButton(
                            arrayListOf(Property(KeyProperties.TEXT, "Olvidé mi contraseña"))
                        ),
                        createButton(
                            arrayListOf(Property(KeyProperties.TEXT, "Mi colonia y/o mi código postal no\n" + "aparece en el listado desplegable"))
                        ),
                        createButton(
                            arrayListOf(Property(KeyProperties.TEXT, "Durante el registro el sistema no me " + "pidió tomarme la fotografía"))
                        ),
                        createButton(
                            arrayListOf(Property(KeyProperties.TEXT, "¿Cuál es la vigencia del código QR y del\n" + "código de barras?"))
                        ),


                        )
                }
            ), createFooterBack(),
            createHeader(),
            "6", TypeView.NONE)
    }

}