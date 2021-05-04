package com.s10plus.core_application.mocks

import com.s10plus.core_application.models.*

object ViewElisa {


    fun ViewBecasElisaAcuña4(): ViewS10Plus {

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
                        Mocks.createTitle("Becas Elisa Acuña"),
                        Mocks.createButton(
                            arrayListOf(Property(KeyProperties.TEXT, "Información General"),
                                    Property(KeyProperties.SEND_TO_VIEW, "19")

                            )
                        ),
                        Mocks.createButton(
                            arrayListOf(Property(KeyProperties.TEXT, "Convocatoría"),

                                Property(
                                    KeyProperties.OPEN_URL,
                                    "https://www.gob.mx/becasbenitojuarez/articulos/becas-elisa-acuna"
                                )
                            )
                        ),
                        Mocks.createButton(
                            arrayListOf(Property(KeyProperties.TEXT, "Resultados"),

                                Property(
                                    KeyProperties.OPEN_URL,
                                    "https://www.gob.mx/becasbenitojuarez/articulos/becas-elisa-acuna"
                                ))
                        ),


                        )

                }
            ), Mocks.createFooterBack(),
            Mocks.createHeader(),
            "4", TypeView.NONE)
    }

    fun all(): List<ViewS10Plus> {
        return arrayListOf(
            ViewBecasElisaAcuña4(),
            ViewInfomacionGeneral19(),

        )
    }
    fun ViewInfomacionGeneral19(): ViewS10Plus {

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
                        Mocks.createTitle("Información General"),

                        Mocks.createText(
                            "El programa de Becas Elisa Acuña apoya a estudiantes, egresados y docentes de Instituciones Públicas de Educación Superior (IPES), para que continúen su profesionalización en igualdad de condiciones. ",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),
                        Mocks.createText(
                            "El programa integra un conjunto de becas que acompañan la trayectoria académica del estudiante desde que ingresa hasta que concluye su Educación Superior, a través de diversas modalidades: ",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),
                        Mocks.createText(
                            "Manutención",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),
                        Mocks.createText(
                            "Excelencia",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),
                        Mocks.createText(
                            "Servicio social ",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),  Mocks.createText(
                            "Titulación ",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),  Mocks.createText(
                            "Prácticas profesionales",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),  Mocks.createText(
                            "Movilidad nacional e internacional",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),  Mocks.createText(
                            "Capacitación",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),
                        Mocks.createText(
                            "Atención de contingencias",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        )





                    )
                }
            ), Mocks.createFooterBack(),
            Mocks.createHeader(),
            "19", TypeView.NONE)
    }



}