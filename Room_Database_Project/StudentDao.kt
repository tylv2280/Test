
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDao {
    @Query("SELECT * FROM student")
    fun getAll(): Flow<List<Student>>

    @Insert
    suspend fun insert(student: Student)

    @Delete
    suspend fun delete(student: Student)
}
