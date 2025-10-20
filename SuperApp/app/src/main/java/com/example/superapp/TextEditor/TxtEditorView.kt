package com.example.superapp.TextEditor

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.NavHostController

val TextEditor = TxtEditorViewModel()

@Composable
@Preview
fun TextEditorPreview() {
    TextEditor(Modifier.fillMaxSize())
}

@Composable
fun TextEditorNav(navController: NavHostController,){
    TextEditor()
}

@Composable
fun TextEditor(modifier: Modifier = Modifier) {
    val txtStyle = TextEditor.returnTextStyle() // karena di dalam ada mutableStateOf, Compose bakal aware

    Scaffold(
        topBar = { TextTitle() },
        bottomBar = { Edit() }
    ) { innerPadding ->
        Column(modifier = modifier.padding(innerPadding)) {
            TextContent(txtStyle)
        }
    }
}

@Composable
fun TextTitle() {
    var title by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = title,
        onValueChange = { newTitle -> title = newTitle },
        placeholder = {
            Text(
                "Title",
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                color = Color.LightGray
            )
        },
        textStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )
    )
}

@Composable
fun TextContent(txtStyle: TextStyle) {
    var textValue by remember { mutableStateOf("") }

    TextField(
        modifier = Modifier.fillMaxSize(),
        value = textValue,
        onValueChange = { textValue = it },
        placeholder = { Text("Write something...", color = Color.LightGray) },
        textStyle = txtStyle
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Edit() {
    var expanded by remember { mutableStateOf(false) }

    Row(modifier = Modifier.padding(8.dp)) {
        IconButton(onClick = { TextEditor.toggleBold() }) {
            Icon(Format_bold, contentDescription = "Bold")
        }
        IconButton(onClick = { TextEditor.toggleItalic() }) {
            Icon(Format_italic, contentDescription = "Italic")
        }
        IconButton(onClick = { TextEditor.toggleUnderline() }) {
            Icon(Format_underlined, contentDescription = "Underline")
        }

        Box {
            TextButton(onClick = { expanded = !expanded }) {
                Text("Heading", fontSize = 16.sp)
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(text = { Text("Normal") }, onClick = { TextEditor.applyHeading(Heading.Normal) })
                DropdownMenuItem(text = { Text("Heading 1") }, onClick = { TextEditor.applyHeading(Heading.H1) })
                DropdownMenuItem(text = { Text("Heading 2") }, onClick = { TextEditor.applyHeading(Heading.H2) })
                DropdownMenuItem(text = { Text("Heading 3") }, onClick = { TextEditor.applyHeading(Heading.H3) })
            }
        }
    }
}
