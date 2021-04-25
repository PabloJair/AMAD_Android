package com.s10plus.core_application.mocks

import android.app.ActionBar
import android.view.View
import android.widget.LinearLayout
import com.s10plus.core_application.models.ViewS10Plus
import com.s10plus.core_application.models.*
import com.s10plus.core_application.ui.ButtonImageS10Plus
import com.s10plus.core_application.utils.RandomUtils

object Mocks {



    fun createButtonImageBecas(
        text: String = "",
        url_image: String,
        properties: ArrayList<Property> = arrayListOf()
    ): ButtonModel {
        return ButtonModel().apply {

            this.typeComponent = TypeComponent.BUTTON_IMAGE


            this.properties.addAll(
                arrayListOf(
                    Property(KeyProperties.URL_IMAGE, url_image),
                    Property(KeyProperties.MARGIN, "10 10 10 10"),
                    Property(KeyProperties.SIZE, "-1 -2"),
                    Property(KeyProperties.TEXT, text),
                    Property(KeyProperties.COLOR_GRADIENT, "#0c231e #071411"),
                    Property(KeyProperties.COLOR, "#FFFFFF"),
                    Property(KeyProperties.CORNER_RADIUS, "10")
                )
            )

            this.properties.addAll(properties)
        }

    }

    fun createButton(properties: ArrayList<Property> = arrayListOf()): ButtonModel {
        return ButtonModel().apply {

            this.typeComponent = TypeComponent.BUTTON
            this.properties.addAll(
                arrayListOf(
                    Property(KeyProperties.MARGIN, "10 10 10 10"),
                    Property(KeyProperties.SIZE, "-1 -2"),
                    Property(KeyProperties.COLOR_GRADIENT, "#0c231e #071411"),
                    Property(KeyProperties.COLOR, "#FFFFFF"),
                    Property(KeyProperties.BACKGROUND, "#000000"),
                    Property(KeyProperties.CORNER_RADIUS, "10")

                )
            )
            this.properties.addAll(properties)
        }

    }


    fun createImage(url: String, properties: ArrayList<Property> = arrayListOf()): ImageModel {
        return ImageModel().apply {

            this.typeComponent = TypeComponent.IMAGE
            this.properties.add(
                Property(KeyProperties.URL_IMAGE, url)
            )

            this.properties.addAll(properties)


        }
    }

    fun createText(text: String = ""): TextViewModel {
        return TextViewModel().apply {

            this.typeComponent = TypeComponent.TEXTVIEW
            this.properties = arrayListOf(
                Property(KeyProperties.MARGIN, "10 10 10 10"),
                Property(KeyProperties.SIZE, "-1 -2"),
                Property(KeyProperties.TEXT, text),
            )


        }

    }

    fun createTitle(text: String = ""): TextViewModel {
        return TextViewModel().apply {

            this.typeComponent = TypeComponent.TEXTVIEW
            this.properties = arrayListOf(
                Property(KeyProperties.MARGIN, "20 10 20 10"),
                Property(KeyProperties.SIZE, "-1 100"),
                Property(KeyProperties.TEXT, text),
                Property(KeyProperties.SIZE_TEXT, "20"),
                Property(KeyProperties.TEXT_ALIGNMENT, "4"),
                Property(KeyProperties.COLOR, "#FFFFFF"),

                Property(KeyProperties.BACKGROUND, "#CAA473"),

                )


        }

    }



    fun createFooterBack(): FooterModel {
        return FooterModel(
            LinealLayoutModel().apply {
                typeView = TypeView.LINEAL
                childs = arrayListOf(
                    createButtonImageBecas(
                        "Menú Principal",
                        "https://firebasestorage.googleapis.com/v0/b/amad-b1de7.appspot.com/o/back.png?alt=media&token=cd70a2e0-3222-4b68-a7a2-63dd52c63bf8",
                        arrayListOf(Property(KeyProperties.BACK_VIEW,"OK"))
                    ),
                )
            }, "1"
        )

    }

    fun createHeader(): HeaderModel {
        return HeaderModel(
            LinealLayoutModel().apply {
                typeView = TypeView.LINEAL
            }, "1"
        )

    }


}