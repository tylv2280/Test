
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.launch

class StudentViewModel : ViewModel() {
    private val db = Room.databaseBuilder(
        appContext,
        AppDatabase::class.java, "student-database"
    ).build()

    private val studentDao = db.studentDao()

    val allStudents = studentDao.getAll()

    fun addStudent(student: Student) {
        viewModelScope.launch {
            studentDao.insert(student)
        }
    }

    fun deleteStudent(student: Student) {
        viewModelScope.launch {
            studentDao.delete(student)
        }
    }
}
