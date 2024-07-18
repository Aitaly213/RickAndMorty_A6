package com.example.rickandmorty.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.models.BaseResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: CartoonRepository
):ViewModel() {
    fun getCharacters(): LiveData<BaseResponse>{
        return repository.getCharacters()
    }
}