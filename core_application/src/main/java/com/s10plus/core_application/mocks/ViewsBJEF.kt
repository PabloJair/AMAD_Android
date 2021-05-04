package com.s10plus.core_application.mocks

import com.s10plus.core_application.models.*

object ViewsBJEF {


    fun ViewMenu3(): ViewS10Plus {

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
                        Mocks.createTitle("Becas Jovenes Escribiendo el futuro"),
                        Mocks.createButton(
                            arrayListOf(Property(KeyProperties.TEXT, "Información General"),
                                Property(KeyProperties.SEND_TO_VIEW, "17")
                            )
                        ),
                        Mocks.createButton(
                            arrayListOf(Property(KeyProperties.TEXT, "Convocatoría"),
                                Property(KeyProperties.SEND_TO_VIEW, "18")
                            )
                        ),


                        )

                }
            ), Mocks.createFooterBack(),
            Mocks.createHeader(),
            "3", TypeView.NONE)
    }
    fun all(): List<ViewS10Plus> {
        return arrayListOf(
            ViewMenu3(),
            ViewInfomacionGeneral17(),
            convocatoria18()


        )
    }
    fun ViewInfomacionGeneral17(): ViewS10Plus {

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
                            "La beca Jóvenes Escribiendo el Futuro está dirigida a estudiantes en condición de pobreza o vulnerabilidad, que vivan en zonas con altos índices de violencia, así como de origen indígena y afrodescendientes, que estén inscritos en alguna Institución Pública de Educación Superior prioritaria, y que tengan hasta 29 años de edad.\n" +
                                    "La beca consiste en un apoyo de \$4,800 bimestrales que son entregados durante el periodo indicado en la convocatoria. ",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),
                        Mocks.createText(
                            "Para poder ser beneficiario de esta beca es necesario estar inscrito en una Institución Pública de Educación Superior (IPES), cumplir con los requisitos que establezca la convocatoria de participación y postularse en: ",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        )



                    )
                }
            ), Mocks.createFooterBack(),
            Mocks.createHeader(),
            "17", TypeView.NONE)
    }
    fun convocatoria18(): ViewS10Plus {

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
                        Mocks.createTitle("convocatoria"),

                        Mocks.createText(
                            "Por el momento no hay convocatorias abiertas.",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),




                    )
                }
            ), Mocks.createFooterBack(),
            Mocks.createHeader(),
            "18", TypeView.NONE)
    }



}