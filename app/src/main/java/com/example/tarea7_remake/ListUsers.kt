package com.example.tarea7_remake

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea7_remake.database.User
import com.example.tarea7_remake.database.UserDatabase
import com.example.tarea7_remake.helper.doAsync
import kotlinx.android.synthetic.main.activity_list_users.*

class ListUsers : AppCompatActivity() {

    private lateinit var viewAdapter: UserAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    val listUsers : List<User> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_users)

        viewManager = LinearLayoutManager(this)
        viewAdapter = UserAdapter(listUsers)

        recyclerViewUsers.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
            addItemDecoration(DividerItemDecoration(this@ListUsers, DividerItemDecoration.VERTICAL))
        }
    }

    override fun onResume() {
        super.onResume()
        doAsync{
            val users = UserDatabase.getInstance(this@ListUsers)?.userDao()?.loadAllUser()
            runOnUiThread{
                viewAdapter.setUsers(users!!)
            }
        }.execute()
    }
}
