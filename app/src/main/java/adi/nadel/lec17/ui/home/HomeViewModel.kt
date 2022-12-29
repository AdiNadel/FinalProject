package adi.nadel.lec17.ui.home

import adi.nadel.lec17.database.AppDatabase
import adi.nadel.lec17.models.Person
import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    val people: LiveData<List<Person>>

    init {
        val db = AppDatabase.create(application)
        people = db.peopleDao().getAll()

        viewModelScope.launch(Dispatchers.IO) {
            db.peopleDao().add(Person("Dave"))
        }
    }
}