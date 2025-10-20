package com.example.superapp.TextEditor

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import org.jetbrains.annotations.TestOnly
import kotlin.apply

sealed class TxtEditorModel() {
    data class myStyle(
        var Bold : Boolean = false,
        var Italic : Boolean = false,
        var Underline : Boolean = false,
        var FontSize : TextUnit = 16.sp
    ){
        fun toggleBold() = copy(Bold = !Bold)
        fun toggleItalic() = copy(Italic = !Italic)
        fun toggleUnderline() = copy(Underline = !Underline)
        fun setFontSize(size: TextUnit) = copy(FontSize = size)

        private enum class MyFormat(val apply : (Boolean) -> Any){
            Bold({isBold -> if (isBold) FontWeight.Bold else FontWeight.Normal }),
            Italic( { isItalic  -> if (isItalic) FontStyle.Italic else FontStyle.Normal }),
            Underline({isUnderline -> if(isUnderline) TextDecoration.Underline else TextDecoration.None })
        }

        fun transparesyong(): String {
            return "${this.Bold}, ${this.Italic}, ${this.Underline}, ${this.FontSize}"
        }

        companion object{
            fun applyTextStyle(myStyle: TxtEditorModel.myStyle = myStyle()): TextStyle {
                return TextStyle(
                    fontWeight = MyFormat.Bold.apply(myStyle.Bold) as FontWeight,
                    fontStyle = MyFormat.Italic.apply(myStyle.Italic) as FontStyle,
                    textDecoration = MyFormat.Underline.apply(myStyle.Underline) as TextDecoration,
                    fontSize = myStyle.FontSize as TextUnit
                )
            }
        }
    }

    enum class HeadingTemplate(
        val myStyle: TxtEditorModel.myStyle
    ){
        H1(TxtEditorModel.myStyle(Bold = true, Italic = false, Underline = false, FontSize = 28.sp)),
        H2(TxtEditorModel.myStyle(Bold = true, Italic = false, Underline = false, FontSize = 24.sp)),
        H3(TxtEditorModel.myStyle(Bold = true, Italic = false, Underline = false, FontSize = 20.sp)),
    }
}

//@Preview
//@Composable
//fun DummyDummy(){
//    var parameterTxtSyle = TxtEditorModel.myStyle()
//    parameterTxtSyle = parameterTxtSyle.toggleBold()
//    val txtStyle : TextStyle = TxtEditorModel.myStyle.applyTextStyle(parameterTxtSyle)
//    DummyTextField(txtStyle)
//}
//
//@Composable
//fun DummyTextField(txtStyle: TextStyle) {
//    var textValue by remember { mutableStateOf("") }
//
//    TextField(
//        modifier = Modifier.fillMaxSize(),
//        value = textValue,
//        onValueChange = { textValue = it },
//        placeholder = { Text("Write something...", color = Color.LightGray) },
//        textStyle = txtStyle
//    )
//}