package com.example.compose_notes.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_notes.R
import com.example.compose_notes.components.NoteButton
import com.example.compose_notes.components.NoteInputText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen() {

    val title  = remember {
        mutableStateOf("")
    }
    val description = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.padding(6.dp),
        verticalArrangement = Arrangement.Top
    ) {
        TopAppBar(
            title = {
                Text(text = stringResource(id = R.string.app_name))
            },
            actions = {
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "Notification Icon"
                )
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFFCECE5A))
        )

        //Content:
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NoteInputText(
                modifier = Modifier.padding(10.dp),
                text = title.value,
                label = "Title",
                onTextChange = { inputText ->
                    if(inputText.all{eachCharacter ->
                            eachCharacter.isLetter() || eachCharacter.isWhitespace()
                        }) {
                        title.value = inputText
                    }
                }
            )

            NoteInputText(
                modifier = Modifier.padding(10.dp),
                text = description.value,
                label = "Description",
                maxLine = 15,
                onTextChange = {inputText ->
                    if(inputText.all {eachCharacter ->
                            eachCharacter.isLetter() || eachCharacter.isWhitespace() || eachCharacter.isDigit()
                        }) {
                        description.value = inputText
                    }
                    
                }
            )

            NoteButton(
                modifier = Modifier.padding(10.dp),
                text = "Save",
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen()
}