
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import androidx.activity.viewModels

class MainActivity : ComponentActivity() {

    private val studentViewModel: StudentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Student List")

                val students = studentViewModel.allStudents.collectAsState(initial = emptyList())
                for (student in students.value) {
                    Text(text = "ID: ${student.id}, Name: ${student.name}")
                }

                Button(onClick = {
                    val student = Student(1, "Nguyễn Văn A")
                    studentViewModel.addStudent(student)
                }) {
                    Text(text = "Add Student")
                }

                Button(onClick = {
                    val student = Student(1, "Nguyễn Văn A")
                    studentViewModel.deleteStudent(student)
                }) {
                    Text(text = "Delete Student")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Column {
        Text(text = "Preview of app components")
    }
}
