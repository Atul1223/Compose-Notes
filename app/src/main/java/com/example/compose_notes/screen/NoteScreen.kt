package com.example.compose_notes.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Divider
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_notes.R
import com.example.compose_notes.components.NoteButton
import com.example.compose_notes.components.NoteInputText
import com.example.compose_notes.components.NoteRow
import com.example.compose_notes.data.NotesDataSource
import com.example.compose_notes.model.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit,
) {

    val context = LocalContext.current
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
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFF79E0EE))
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
                onClick = {
                    if(title.value.isNotEmpty() && description.value.isNotEmpty()) {
                        //save the note
                        onAddNote(Note(title = title.value, description = description.value))
                        //clear the fields:
                        title.value = ""
                        description.value = ""
                        Toast.makeText(context, "Notes Added", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
        Divider(modifier = Modifier.padding(vertical = 10.dp))
        LazyColumn{
            items(items = notes) {note->
                NoteRow(
                    modifier = Modifier.padding(vertical = 10.dp, horizontal = 5.dp),
                    note = note,
                    onNoteClick = {note->
                        onRemoveNote(note)
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen(
        notes = NotesDataSource().loadNotes(),
        onAddNote = {},
        onRemoveNote = {}
    )
}