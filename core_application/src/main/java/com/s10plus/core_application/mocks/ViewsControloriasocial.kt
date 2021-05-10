package com.s10plus.core_application.mocks

import com.s10plus.core_application.models.*

object ViewsControloriasocial {


    fun ViewControloriaSocial5(): ViewS10Plus {

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
                        Mocks.createTitle("Controloria Social"),
                        Mocks.createButton(
                            arrayListOf(
                                Property(KeyProperties.TEXT, "Información General"),
                                Property(KeyProperties.SEND_TO_VIEW, "20"),
                                Property(KeyProperties.SEND_ANALYTICS, "25|nav|CLICK/SUB_MENU|Información General|Información General_CS",)



                            )
                        ),
                        Mocks.createButton(
                            arrayListOf(
                                Property(
                                    KeyProperties.TEXT,
                                    "¡Regístrate como representante!"
                                ),
                                Property(KeyProperties.SEND_TO_VIEW, "21"),
                                Property(KeyProperties.SEND_ANALYTICS, "23|nav|CLICK/SUB_MENU|¡Regístrate como representante!|¡Regístrate como representante!",)


                            )
                        ),
                        Mocks.createButton(
                            arrayListOf(
                                Property(KeyProperties.TEXT, "Denuncia Ciudadana"),
                                Property(
                                    KeyProperties.OPEN_URL,
                                    "https://sidec.funcionpublica.gob.mx/#!/"
                                ),
                                Property(KeyProperties.SEND_ANALYTICS, "22|nav|CLICK/SUB_MENU|https://sidec.funcionpublica.gob.mx/#!/|Denuncia Ciudadana",)

                            )
                        ),
                        Mocks.createButton(
                            arrayListOf(
                                Property(KeyProperties.TEXT, "Ciudadanos Alertadores"),
                                Property(
                                    KeyProperties.OPEN_URL,
                                    "https://alertadores.funcionpublica.gob.mx/"
                                ),
                                Property(KeyProperties.SEND_ANALYTICS, "21|nav|CLICK/SUB_MENU|https://alertadores.funcionpublica.gob.mx/|Ciudadanos Alertadores",)

                            )
                        ),
                        Mocks.createButton(
                            arrayListOf(
                                Property(KeyProperties.TEXT, "Quejas y Denuncias"),
                                Property(KeyProperties.SEND_TO_VIEW, "22"),
                                Property(KeyProperties.SEND_ANALYTICS, "20|nav|CLICK/SUB_MENU|Quejas y Denuncias|Quejas y Denuncias",)


                            )
                        ),

                        )

                }
            ), Mocks.createFooterBack(),
            Mocks.createHeader(),
            "5", TypeView.NONE)
    }
    fun all(): List<ViewS10Plus> {
        return arrayListOf(
            ViewControloriaSocial5(),
            ViewInfomacionGeneral20(),
            registrate21(),
            quejas22()


        )
    }
    fun ViewInfomacionGeneral20(): ViewS10Plus {

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
                            "La Contraloría Social es el mecanismo mediante el cual las y los becarios vigilan el cumplimiento de las metas y la correcta aplicación de los recursos de los programas de la Coordinación Nacional de Becas para el Bienestar Benito Juárez.",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),
                        Mocks.createText(
                            "Funciona a través de Representantes, que realizan las actividades de Contraloría Social en su escuela:\n",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),
                        Mocks.createText(
                                    "• Informan y orientan a sus compañeros sobre el funcionamiento del Programa y de la Contraloría Social. ",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),
                        Mocks.createText(
                            "• Vigilan la operación del Programa y denuncian cualquier irregularidad.",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),    Mocks.createText(
                            "• Aplican una encuesta para evaluar el Programa. ",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),
                        Mocks.createText(
                            "• Participan en encuentros regionales, estatales y nacionales.",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),
                        Mocks.createText(
                            "Asimismo, los Representantes de Contraloría Social deben denunciar:",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),
                        Mocks.createText(
                            "• Si alguien condiciona la entrega de becas.",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),
                        Mocks.createText(
                            "• Si obligan a las y los becarios a realizar actividades distintas a las escolares.",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),
                        Mocks.createText(
                            "• Si se está usando el Programa para apoyar a una persona o partido político.",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),
                        Mocks.createText(
                            "• Si algún becario recibe malos tratos por parte de un servidor público, autoridad escolar o personal del banco.",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        )



                    )
                }
            ), Mocks.createFooterBack(),
            Mocks.createHeader(),
            "20", TypeView.NONE)
    }
    fun registrate21(): ViewS10Plus {

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
                            "Si requieres mayor información o quiere registrarte para ser Representante de " +
                                    "Contraloría Social en tu escuela, manda un correo a:",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),
                        Mocks.createText(
                            "Representantes de Becas de Educación  Básica: " +
                                    " <a href=\"contraloria.basica@becasbenitojuarez.gob.mx\">contraloria.basica@becasbenitojuarez.gob.mx</a> :",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"),
                                Property(
                                    KeyProperties.OPEN_EMAIL,
                                    "contraloria.basica@becasbenitojuarez.gob.mx"
                                ))

                        ),
                        Mocks.createText(
                            "Representantes de Beca Universal de Educación Media Superior:\n" +
                                    " <a href=\"contraloria.ems@becasbenitojuarez.gob.mx\">contraloria.ems@becasbenitojuarez.gob.mx</a> ",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"),
                                Property(
                                    KeyProperties.OPEN_EMAIL,
                                    "contraloria.ems@becasbenitojuarez.gob.mx"
                                ))

                        ),
                        Mocks.createText(
                            "Representantes de Jóvenes Escribiendo el Futuro:\n" +
                                    " <a href=\"contraloria.superior@becasbenitojuarez.gob.mx\">contraloria.superior@becasbenitojuarez.gob.mx</a>",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"),
                                Property(
                                    KeyProperties.OPEN_EMAIL,
                                    "contraloria.superior@becasbenitojuarez.gob.mx"
                                ))

                        ),
                        Mocks.createText(
                            "Representantes de Becas Elisa Acuña:\n" +
                                    " <a href=\"contraloria.elisaa@becasbenitojuarez.gob.mx\">contraloria.elisaa@becasbenitojuarez.gob.mx</a> ",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"),
                                Property(
                                    KeyProperties.OPEN_EMAIL,
                                    "contraloria.elisaa@becasbenitojuarez.gob.mx"
                                ))

                        ),



                        )
                }
            ), Mocks.createFooterBack(),
            Mocks.createHeader(),
            "21", TypeView.NONE)
    }
    fun quejas22(): ViewS10Plus {

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
                        Mocks.createTitle("Quejas y denunciuas"),

                        Mocks.createText(
                            "Si deseas presentar una queja o denuncia hacia un servidor público involucrado en la ejecución de alguno de los Programas\n" +
                                    "de la Coordinación Nacional de Becas para el Bienestar Benito Juárez (CNBBBJ) sigue los siguientes pasos:",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"))

                        ),
                        Mocks.createText(
                            " Descarga el\n" +
                                    " <a href=\"https://cnprospera-my.sharepoint.com/personal/monserrat_berber_becasbenitojuarez_gob_mx/_layouts/15/onedrive.aspx?id=%2Fpersonal%2Fmonserrat%5Fberber%5Fbecasbenitojuarez%5Fgob%5Fmx%2FDocuments%2FQuejas%20y%20Denuncias%2FFormato%5FQuejas%5FDenuncias%5F2020%5F%5F%2Epdf&parent=%2Fpersonal%2Fmonserrat%5Fberber%5Fbecasbenitojuarez%5Fgob%5Fmx%2FDocuments%2FQuejas%20y%20Denuncias&originalPath=aHR0cHM6Ly9jbnByb3NwZXJhLW15LnNoYXJlcG9pbnQuY29tL3BlcnNvbmFsL21vbnNlcnJhdF9iZXJiZXJfYmVjYXNiZW5pdG9qdWFyZXpfZ29iX214L19sYXlvdXRzLzE1L2d1ZXN0YWNjZXNzLmFzcHg_ZG9jaWQ9MTVmMTFiN2M0Nzg0YTRlYzZhYWQyM2ZmOTM2MTA3MTYzJmF1dGhrZXk9QWFYOHlCY1Y3akxRSEMtbEF1dDBDVzgmcnRpbWU9WXJTWlFtdVQyRWc\">Formato de Quejas y\n" +
                                    "Denuncias.</a>",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"),
                                Property(
                                    KeyProperties.OPEN_URL,
                                    "https://cnprospera-my.sharepoint.com/personal/monserrat_berber_becasbenitojuarez_gob_mx/_layouts/15/onedrive.aspx?id=%2Fpersonal%2Fmonserrat%5Fberber%5Fbecasbenitojuarez%5Fgob%5Fmx%2FDocuments%2FQuejas%20y%20Denuncias%2FFormato%5FQuejas%5FDenuncias%5F2020%5F%5F%2Epdf&parent=%2Fpersonal%2Fmonserrat%5Fberber%5Fbecasbenitojuarez%5Fgob%5Fmx%2FDocuments%2FQuejas%20y%20Denuncias&originalPath=aHR0cHM6Ly9jbnByb3NwZXJhLW15LnNoYXJlcG9pbnQuY29tL3BlcnNvbmFsL21vbnNlcnJhdF9iZXJiZXJfYmVjYXNiZW5pdG9qdWFyZXpfZ29iX214L19sYXlvdXRzLzE1L2d1ZXN0YWNjZXNzLmFzcHg_ZG9jaWQ9MTVmMTFiN2M0Nzg0YTRlYzZhYWQyM2ZmOTM2MTA3MTYzJmF1dGhrZXk9QWFYOHlCY1Y3akxRSEMtbEF1dDBDVzgmcnRpbWU9WXJTWlFtdVQyRWc\\"
                                ))

                        ),
                        Mocks.createText(
                            "<p style=\"text-align: center;\">Manutenci&oacute;n</p>\n" +
                                    "<p>2. Llena los datos que se solicitan.</p>\n" +
                                    "<p>3. Firma el formato.</p>",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"),
                                Property(
                                    KeyProperties.OPEN_EMAIL,
                                    "contraloria.ems@becasbenitojuarez.gob.mx"
                                ))

                        ),
                        Mocks.createText(
                            "4. Envía el formato (escaneado o por " +
                                    "fotografía) al correo electrónico " +
                                    " <a href=\"atencion@becasbenitojuarez.gob.mx\">atencion@becasbenitojuarez.gob.mx</a>\n" +
                                    "y/o entrégalo en la Oficina de " +
                                    "Representación Estatal más cercana a " +
                                    "tu domicilio.",
                            arrayListOf(Property(KeyProperties.TEXT_HTML, "true"),
                                Property(
                                    KeyProperties.OPEN_EMAIL,
                                    "atencion@becasbenitojuarez.gob.mx"
                                ))

                        ),



                        )
                }
            ), Mocks.createFooterBack(),
            Mocks.createHeader(),
            "22", TypeView.NONE)
    }



}