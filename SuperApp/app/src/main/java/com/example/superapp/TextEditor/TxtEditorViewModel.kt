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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

enum class Heading{
    H1, H2, H3, Normal
}

class TxtEditorViewModel () {
    var currentStyle by mutableStateOf(TxtEditorModel.myStyle())
        private set

    fun toggleBold(){
        currentStyle = currentStyle.toggleBold()
    }

    fun toggleItalic() {
        currentStyle = currentStyle.toggleItalic()
    }

    fun toggleUnderline() {
        currentStyle = currentStyle.toggleUnderline()
    }

    fun setFontSize(sizeSp: Float) {
        currentStyle = currentStyle.setFontSize(sizeSp.sp)
    }

    fun applyHeading(heading: Heading) {
        when(heading){
            Heading.H1 -> currentStyle = TxtEditorModel.HeadingTemplate.H1.myStyle
            Heading.H2 -> currentStyle = TxtEditorModel.HeadingTemplate.H2.myStyle
            Heading.H3 -> currentStyle = TxtEditorModel.HeadingTemplate.H3.myStyle
            Heading.Normal -> currentStyle = TxtEditorModel.myStyle()
        }
    }

//    fun transparan(): String {
//        return currentStyle.transparesyong()
//    }

    fun returnTextStyle(): TextStyle {
        return TxtEditorModel.myStyle.applyTextStyle(currentStyle)
    }
}

//@Preview
//@Composable
//fun dumdummy(){
//    val ella = TxtEditorViewModel()
//    print(ella.transparan())
//    ella.applyHeading(Heading.H2)
//    DummyTextField(ella.returnTextStyle())
//}
//
//@Composable
//fun DummyTextField(txtStyle: TextStyle) {
//    var textValue by remember { mutableStateOf("") }
//
//    TextField(
//        modifier = Modifier.fillMaxSize(),
//        value = textValue,
//        onValueChange = { it -> textValue = it },
//        textStyle = txtStyle
//    )
//}