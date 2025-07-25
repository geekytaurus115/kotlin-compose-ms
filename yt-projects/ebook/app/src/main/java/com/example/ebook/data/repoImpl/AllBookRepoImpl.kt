package com.example.ebook.data.repoImpl

import com.example.ebook.common.BookCategoryModel
import com.example.ebook.common.BookModel
import com.example.ebook.common.ResultState
import com.example.ebook.domain.repo.AllBookRepo
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class AllBookRepoImpl @Inject constructor(val firebaseDatabase: FirebaseDatabase): AllBookRepo {

    override fun getAllBooks(): Flow<ResultState<List<BookModel>>> = callbackFlow {

        trySend(ResultState.Loading)

        val valueEvent = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                var items: List<BookModel> = emptyList()
                items = snapshot.children.map { value ->

                    value.getValue<BookModel>()!!
                }

                trySend(ResultState.Success(items))
            }

            override fun onCancelled(error: DatabaseError) {

                trySend(ResultState.Error(error.toException()))

            }


        }

        firebaseDatabase.reference.child("Books").addValueEventListener(valueEvent)

        awaitClose {

            firebaseDatabase.reference.removeEventListener(valueEvent)
            close()
        }

    }


    //get all Catagory
    override fun getAllCategory(): Flow<ResultState<List<BookCategoryModel>>> = callbackFlow{

        trySend(ResultState.Loading)

        val valueEvent = object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                var items: List<BookCategoryModel> = emptyList()
                items = snapshot.children.map { value ->

                    value.getValue<BookCategoryModel>()!!
                }
                    trySend(ResultState.Success(items))

            }

            override fun onCancelled(error: DatabaseError) {

                trySend(ResultState.Error(error.toException()))

            }


        }

        firebaseDatabase.reference.child("BooksCategory").addValueEventListener(valueEvent)

        awaitClose {

            firebaseDatabase.reference.removeEventListener(valueEvent)
            close()
        }

    }


    // Get all books by category
    override fun getAllBooksByCategory(category: String): Flow<ResultState<List<BookModel>>> = callbackFlow {

        trySend(ResultState.Loading)

        val valueEvent = object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                var items: List<BookModel> = emptyList()
                items = snapshot.children.filter{ value ->

                    value.getValue<BookModel>()!!.category == category
                }.map {value ->

                    value.getValue<BookModel>()!!

                }

                trySend(ResultState.Success(items))


            }

            override fun onCancelled(error: DatabaseError) {

                trySend(ResultState.Error(error.toException()))
            }


        }


        firebaseDatabase.reference.child("Books").addValueEventListener(valueEvent)

        awaitClose {

            firebaseDatabase.reference.removeEventListener(valueEvent)
            close()
        }

    }


}