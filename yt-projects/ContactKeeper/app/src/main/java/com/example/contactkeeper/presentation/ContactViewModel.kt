package com.example.contactkeeper.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.contactkeeper.data.database.Contact
import com.example.contactkeeper.data.database.ContactDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject


@HiltViewModel
class ContactViewModel @Inject constructor(var database: ContactDatabase): ViewModel() {

    private var isSortedByName = MutableStateFlow(true)
    private var contact = isSortedByName.flatMapLatest {

        if (it){
            database.getDao().getContactsSortedByName()
        }else{
            database.getDao().getContactsSortedByDat()
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    val _state = MutableStateFlow(ContactState())
    val state = combine(_state, contact, isSortedByName){state, contacts, isSortedByName ->

        state.copy(contacts = contacts)

    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ContactState())

    fun saveContact(){

        val contact = Contact(
            id = state.value.id.value,
            name = _state.value.name.value,
            phoneNumber = _state.value.phone.value,
            email = _state.value.email.value,
            isActive = true,
            dateOfCreation = System.currentTimeMillis().toLong(),
            img = state.value.img.value
        )
    }
}